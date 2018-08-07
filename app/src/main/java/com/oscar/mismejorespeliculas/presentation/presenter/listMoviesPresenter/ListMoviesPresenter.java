package com.oscar.mismejorespeliculas.presentation.presenter.listMoviesPresenter;

import android.util.Log;

import com.oscar.mismejorespeliculas.domain.model.ResponseMovies;
import com.oscar.mismejorespeliculas.domain.usecase.UseCaseObserver;
import com.oscar.mismejorespeliculas.domain.usecase.listMovies.GetListMovies;
import com.oscar.mismejorespeliculas.presentation.presenter.Presenter;
import com.oscar.mismejorespeliculas.presentation.ui.ListMoviesFragment;
import com.oscar.mismejorespeliculas.presentation.view.IListMoviesView;

/**
 * The type List movies presenter.
 */
public class ListMoviesPresenter extends Presenter<IListMoviesView> implements IListMoviesPresenter {
    private ListMoviesFragment listMoviesFragment;
    private GetListMovies getListMovies;

    /**
     * Instantiates a new List movies presenter.
     *
     * @param listMoviesFragment the list movies fragment
     * @param getListMovies      the get list movies
     */
    public ListMoviesPresenter(ListMoviesFragment listMoviesFragment, GetListMovies getListMovies) {
        this.listMoviesFragment = listMoviesFragment;
        this.getListMovies = getListMovies;
    }

    @Override
    public void onCreate() {

    }

    @Override
    public void getListPopularMovies(String page) {
        getListMovies.executeGetPopularMovies(new GetRequestPopularObserver(),page);
    }

    @Override
    public void getListTopratedMovies(String page) {
        getListMovies.executeGetTopRatedMovies(new GetRequestPopularObserver(),page);
    }

    @Override
    public void getListUpcomingMovies(String page) {
        getListMovies.executeGetUpcomingMovies(new GetRequestPopularObserver(),page);
    }

    private class GetRequestPopularObserver extends UseCaseObserver<ResponseMovies>{
        /**
         * The Response movies.
         */
        ResponseMovies responseMovies;
        @Override
        public void onNext(ResponseMovies value) {
            super.onNext(value);
            Log.e("PERRO", value.toString());
            responseMovies = value;
        }

        @Override
        public void onError(Throwable e) {
            super.onError(e);

        }

        @Override
        public void onComplete() {
            super.onComplete();
            if (responseMovies != null){
                getView().setDataResults(responseMovies);
            }

        }
    }
}
