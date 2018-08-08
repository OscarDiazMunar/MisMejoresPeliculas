package com.oscar.mismejorespeliculas.domain.usecase.listMoviesDB;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.observers.DisposableObserver;
import io.reactivex.schedulers.Schedulers;

/**
 * The type Use case list movies db.
 *
 * @param <T> the type parameter
 */
abstract class UseCaseListMoviesDB<T> {
    private final CompositeDisposable compositeDisposable;

    /**
     * Instantiates a new Use case list movies.
     */
    protected UseCaseListMoviesDB() {
        this.compositeDisposable = new CompositeDisposable();
    }

    /**
     * Execute select movies db.
     *
     * @param disposableObserver the disposable observer
     * @param page               the page
     * @param typeMovies         the type movies
     */
    public void executeSelectMoviesDB(DisposableObserver<T> disposableObserver, String page, String typeMovies){
        final Observable<T> observable = this.buildUseCaseMoviesDBObservable(page, typeMovies)
                .subscribeOn(Schedulers.computation())
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
     * Build use case movies db observable observable.
     *
     * @param page       the page
     * @param typeMovies the type movies
     * @return the observable
     */
    abstract Observable<T> buildUseCaseMoviesDBObservable(String page, String typeMovies);
}
