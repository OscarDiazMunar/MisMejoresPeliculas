package com.oscar.mismejorespeliculas.domain.usecase.listMovies;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.observers.DisposableObserver;
import io.reactivex.schedulers.Schedulers;

/**
 * The type Use case list movies.
 *
 * @param <T> the type parameter
 */
abstract class UseCaseListMovies<T> {
    private final CompositeDisposable compositeDisposable;

    /**
     * Instantiates a new Use case list movies.
     */
    protected UseCaseListMovies() {
        this.compositeDisposable = new CompositeDisposable();
    }

    /**
     * Execute get popular movies.
     *
     * @param disposableObserver the disposable observer
     * @param page               the page
     */
    public void executeGetPopularMovies(DisposableObserver<T> disposableObserver, String page){
        final Observable<T> observable = this.buildUseCasePopularMoviesObservable(page)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());

        DisposableObserver observer = observable.subscribeWith(disposableObserver);
        compositeDisposable.add(observer);
    }

    /**
     * Execute get top rated movies.
     *
     * @param disposableObserver the disposable observer
     * @param page               the page
     */
    public void executeGetTopRatedMovies(DisposableObserver<T> disposableObserver, String page){
        final Observable<T> observable = this.buildUseCaseTopRatedMoviesObservable(page)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());

        DisposableObserver observer = observable.subscribeWith(disposableObserver);
        compositeDisposable.add(observer);
    }

    /**
     * Execute get upcoming movies.
     *
     * @param disposableObserver the disposable observer
     * @param page               the page
     */
    public void executeGetUpcomingMovies(DisposableObserver<T> disposableObserver, String page){
        final Observable<T> observable = this.buildUseCaseUpcomingMoviesObservable(page)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());

        DisposableObserver observer = observable.subscribeWith(disposableObserver);
        compositeDisposable.add(observer);
    }

    /**
     * Execute get video.
     *
     * @param disposableObserver the disposable observer
     * @param idMovie            the id movie
     */
    public void executeGetVideo(DisposableObserver<T> disposableObserver, String idMovie){
        final Observable<T> observable = this.buildUseCaseGetVideoObservable(idMovie)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());

        DisposableObserver observer = observable.subscribeWith(disposableObserver);
        compositeDisposable.add(observer);
    }

    /**
     * Dispose.
     */
    public void dispose(){
        if (!compositeDisposable.isDisposed()){
            compositeDisposable.dispose();
        }
    }

    /**
     * Build use case popular movies observable observable.
     *
     * @param page the page
     * @return the observable
     */
    abstract Observable<T> buildUseCasePopularMoviesObservable(String page);

    /**
     * Build use case top rated movies observable observable.
     *
     * @param page the page
     * @return the observable
     */
    abstract Observable<T> buildUseCaseTopRatedMoviesObservable(String page);

    /**
     * Build use case upcoming movies observable observable.
     *
     * @param page the page
     * @return the observable
     */
    abstract Observable<T> buildUseCaseUpcomingMoviesObservable(String page);

    /**
     * Build use case get video observable observable.
     *
     * @param idMovie the id movie
     * @return the observable
     */
    abstract Observable<T> buildUseCaseGetVideoObservable(String idMovie);

}
