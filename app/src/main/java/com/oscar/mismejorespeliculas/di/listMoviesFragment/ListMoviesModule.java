package com.oscar.mismejorespeliculas.di.listMoviesFragment;

import android.app.Activity;
import android.content.Context;

import com.oscar.mismejorespeliculas.data.db.DBHandlerDAO;
import com.oscar.mismejorespeliculas.data.rest.themoviedb.MovieDbClient;
import com.oscar.mismejorespeliculas.domain.usecase.listMovies.GetListMovies;
import com.oscar.mismejorespeliculas.domain.usecase.listMoviesDB.SelectListMoviesDB;
import com.oscar.mismejorespeliculas.presentation.presenter.listMoviesPresenter.ListMoviesPresenter;
import com.oscar.mismejorespeliculas.presentation.ui.ListMoviesFragment;

import dagger.Module;
import dagger.Provides;

/**
 * The type List movies module.
 */
@Module
public class ListMoviesModule {
    private final Context context;
    private final Activity activity;

    /**
     * Instantiates a new List movies module.
     *
     * @param context the context
     * @param activity
     */
    public ListMoviesModule(Context context, Activity activity) {
        this.context = context;
        this.activity = activity;
    }

    /**
     * Get context context.
     *
     * @return the context
     */
    @Provides
    public Context getContext(){
        return context;
    }

    /**
     * Provides list movies fragment list movies fragment.
     *
     * @return the list movies fragment
     */
    @Provides
    public ListMoviesFragment providesListMoviesFragment(){
        return new ListMoviesFragment();
    }

    /**
     * Provides get list movies get list movies.
     *
     * @return the get list movies
     */
    @Provides
    public GetListMovies providesGetListMovies(){
        return new GetListMovies(MovieDbClient.getInstance());
    }

    /**
     * Provides select list movies db select list movies db.
     *
     * @return the select list movies db
     */
    @Provides
    public SelectListMoviesDB providesSelectListMoviesDB(){
        return new SelectListMoviesDB(DBHandlerDAO.getInstance(context));
    }

    /**
     * Provides list movies presenter list movies presenter.
     *
     * @param listMoviesFragment the list movies fragment
     * @param getListMovies      the get list movies
     * @param selectListMoviesDB the select list movies db
     * @return the list movies presenter
     */
    @Provides
    public ListMoviesPresenter providesListMoviesPresenter(ListMoviesFragment listMoviesFragment,
                                                           GetListMovies getListMovies,
                                                           SelectListMoviesDB selectListMoviesDB){
        return new ListMoviesPresenter(listMoviesFragment, getListMovies, context, selectListMoviesDB);
    }
}
