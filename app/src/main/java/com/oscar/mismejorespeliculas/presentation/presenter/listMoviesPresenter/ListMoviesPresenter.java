package com.oscar.mismejorespeliculas.presentation.presenter.listMoviesPresenter;

import android.app.Activity;
import android.content.Context;
import android.util.Log;

import com.jakewharton.retrofit2.adapter.rxjava2.HttpException;
import com.oscar.mismejorespeliculas.data.db.DBHandlerDAO;
import com.oscar.mismejorespeliculas.domain.model.api.ResponseMovies;
import com.oscar.mismejorespeliculas.domain.model.api.Results;
import com.oscar.mismejorespeliculas.domain.model.db.ResponseDataMovies;
import com.oscar.mismejorespeliculas.domain.model.db.ResponseMoviesDB;
import com.oscar.mismejorespeliculas.domain.model.db.ResultsDB;
import com.oscar.mismejorespeliculas.domain.usecase.UseCaseObserver;
import com.oscar.mismejorespeliculas.domain.usecase.listMovies.GetListMovies;
import com.oscar.mismejorespeliculas.domain.usecase.listMoviesDB.SelectListMoviesDB;
import com.oscar.mismejorespeliculas.presentation.presenter.Presenter;
import com.oscar.mismejorespeliculas.presentation.ui.ListMoviesFragment;
import com.oscar.mismejorespeliculas.presentation.view.IListMoviesView;

import java.util.ArrayList;
import java.util.List;

/**
 * The type List movies presenter.
 */
public class ListMoviesPresenter extends Presenter<IListMoviesView> implements IListMoviesPresenter {
    private ListMoviesFragment listMoviesFragment;
    private GetListMovies getListMovies;
    private SelectListMoviesDB selectListMoviesDB;
    private String typeMovies;
    private String pageNow;
    private Context context;
    private DBHandlerDAO dbHandlerDAO;

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
        dbHandlerDAO = DBHandlerDAO.getInstance(context);
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

                ResponseMoviesDB responseMoviesDB = new ResponseMoviesDB();
                responseMoviesDB.setPage(responseMovies.getPage());
                responseMoviesDB.setTotal_pages(responseMovies.getTotal_pages());
                responseMoviesDB.setTypeMovie(typeMovies);

                Long res1 = dbHandlerDAO.insertResponseMovies(responseMoviesDB);

                for (Results item : responseMovies.getResults()) {
                    ResultsDB resultsDB = new ResultsDB();
                    resultsDB.setDate(item.getRelease_date());
                    resultsDB.setIdMovie(item.getId());
                    resultsDB.setOverview(item.getOverview());
                    resultsDB.setOriginalTitle(item.getOriginal_title());
                    resultsDB.setVote(item.getVote_average());
                    resultsDB.setPosterPath(item.getPoster_path());
                    resultsDB.setPage(responseMovies.getPage());
                    resultsDB.setTypeMovie(typeMovies);
                    Long resto = dbHandlerDAO.insertResults(resultsDB);
                    Log.e("RESTO", Long.toString(resto));
                }

                Log.e("RES", Long.toString(res1));
            }
        }
    }

    private class SelectMoviesObserver extends UseCaseObserver<ResponseDataMovies>{
        /**
         * The Response movies.
         */
        ResponseMovies responseMovies = new ResponseMovies();
        @Override
        public void onNext(ResponseDataMovies value) {
            super.onNext(value);
            responseMovies.setPage(value.getResponseMoviesDB().getPage());
            responseMovies.setTotal_pages(value.getResponseMoviesDB().getTotal_pages());


            List<Results> resultsList = new ArrayList<>();
            for (ResultsDB item : value.getResultsDBS()) {
                Results results = new Results(item.getVote(),
                        item.getOverview(),
                        item.getDate(),
                        item.getOriginalTitle(),
                        item.getPosterPath(),
                        item.getIdMovie());
                resultsList.add(results);
            }

            responseMovies.setResults(resultsList);

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
