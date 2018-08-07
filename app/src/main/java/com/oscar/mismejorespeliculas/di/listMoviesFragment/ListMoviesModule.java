package com.oscar.mismejorespeliculas.di.listMoviesFragment;

import com.oscar.mismejorespeliculas.data.rest.themoviedb.MovieDbClient;
import com.oscar.mismejorespeliculas.domain.usecase.listMovies.GetListMovies;
import com.oscar.mismejorespeliculas.presentation.presenter.listMoviesPresenter.ListMoviesPresenter;
import com.oscar.mismejorespeliculas.presentation.ui.ListMoviesFragment;

import dagger.Module;
import dagger.Provides;

/**
 * The type List movies module.
 */
@Module
public class ListMoviesModule {

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
     * Provides list movies presenter list movies presenter.
     *
     * @param listMoviesFragment the list movies fragment
     * @param getListMovies      the get list movies
     * @return the list movies presenter
     */
    @Provides
    public ListMoviesPresenter providesListMoviesPresenter(ListMoviesFragment listMoviesFragment, GetListMovies getListMovies){
        return new ListMoviesPresenter(listMoviesFragment, getListMovies);
    }
}
