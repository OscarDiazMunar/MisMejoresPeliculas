package com.oscar.mismejorespeliculas.presentation.presenter.listMoviesPresenter;

import android.content.Context;
import android.util.Log;

import com.jakewharton.retrofit2.adapter.rxjava2.HttpException;
import com.oscar.mismejorespeliculas.data.db.DBHandler;
import com.oscar.mismejorespeliculas.domain.model.ResponseMovies;
import com.oscar.mismejorespeliculas.domain.usecase.UseCaseObserver;
import com.oscar.mismejorespeliculas.domain.usecase.listMovies.GetListMovies;
import com.oscar.mismejorespeliculas.domain.usecase.listMoviesDB.SelectListMoviesDB;
import com.oscar.mismejorespeliculas.presentation.presenter.Presenter;
import com.oscar.mismejorespeliculas.presentation.ui.ListMoviesFragment;
import com.oscar.mismejorespeliculas.presentation.view.IListMoviesView;

/**
 * The type List movies presenter.
 */
public class ListMoviesPresenter extends Presenter<IListMoviesView> implements IListMoviesPresenter {
    private ListMoviesFragment listMoviesFragment;
    private GetListMovies getListMovies;
    private SelectListMoviesDB selectListMoviesDB;
    private DBHandler dbHandler;
    private String typeMovies;
    private String pageNow;
    private Context context;

    /**
     * Instantiates a new List movies presenter.
     *
     * @param listMoviesFragment the list movies fragment
     * @param getListMovies      the get list movies
     * @param context            the context
     * @param selectListMoviesDB the select list movies db
     */
    public ListMoviesPresenter(ListMoviesFragment listMoviesFragment,
                               GetListMovies getListMovies,
                               Context context,
                               SelectListMoviesDB selectListMoviesDB) {
        this.listMoviesFragment = listMoviesFragment;
        this.getListMovies = getListMovies;
        this.context = context;
        this.selectListMoviesDB = selectListMoviesDB;
    }

    @Override
    public void onCreate() {
        dbHandler = new DBHandler(context);
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

    @Override
    public void setTyeMovies(String tyeMovies) {
        this.typeMovies = tyeMovies;
    }

    @Override
    public void setPageNow(String pageNow) {
        this.pageNow = pageNow;
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
            if (e instanceof HttpException){

            }else {
                getView().showErrorNoConnection("No internet connection. Data saved");
                selectListMoviesDB.executeSelectMoviesDB(new SelectMoviesObserver(), pageNow , typeMovies);
            }
        }

        @Override
        public void onComplete() {
            super.onComplete();
            if (responseMovies != null){
                getView().setDataResults(responseMovies);

                Long res = dbHandler.insertDataMovies(responseMovies, typeMovies);
                Log.e("RES", Long.toString(res));
            }
        }
    }

    private class SelectMoviesObserver extends UseCaseObserver<ResponseMovies>{
        /**
         * The Response movies.
         */
        ResponseMovies responseMovies;
        @Override
        public void onNext(ResponseMovies value) {
            super.onNext(value);
            responseMovies = value;
        }

        @Override
        public void onError(Throwable e) {
            super.onError(e);
        }

        @Override
        public void onComplete() {
            super.onComplete();
            Log.e("DB DATA", responseMovies.toString());
            getView().setDataResults(responseMovies);
        }
    }
}
