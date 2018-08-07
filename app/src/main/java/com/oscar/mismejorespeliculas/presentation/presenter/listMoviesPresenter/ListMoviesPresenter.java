package com.oscar.mismejorespeliculas.presentation.presenter.listMoviesPresenter;

import android.util.Log;

import com.oscar.mismejorespeliculas.domain.model.ResponseMovies;
import com.oscar.mismejorespeliculas.domain.usecase.UseCaseObserver;
import com.oscar.mismejorespeliculas.domain.usecase.listMovies.GetListMovies;
import com.oscar.mismejorespeliculas.presentation.presenter.Presenter;
import com.oscar.mismejorespeliculas.presentation.ui.ListMoviesFragment;
import com.oscar.mismejorespeliculas.presentation.view.IListMoviesView;

public class ListMoviesPresenter extends Presenter<IListMoviesView> implements IListMoviesPresenter {
    private ListMoviesFragment listMoviesFragment;
    private GetListMovies getListMovies;

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

    private class GetRequestPopularObserver extends UseCaseObserver<ResponseMovies>{
        @Override
        public void onNext(ResponseMovies value) {
            super.onNext(value);
            Log.e("PERRO", value.toString());
        }

        @Override
        public void onError(Throwable e) {
            super.onError(e);
            Log.e("ERROR", "GOSQUE");
            Log.e("GORSO", e.toString());
        }

        @Override
        public void onComplete() {
            super.onComplete();
        }
    }
}
