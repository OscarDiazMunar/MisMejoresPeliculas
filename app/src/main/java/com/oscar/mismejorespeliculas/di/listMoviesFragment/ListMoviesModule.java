package com.oscar.mismejorespeliculas.di.listMoviesFragment;

import com.oscar.mismejorespeliculas.data.rest.themoviedb.MovieDbClient;
import com.oscar.mismejorespeliculas.domain.usecase.listMovies.GetListMovies;
import com.oscar.mismejorespeliculas.presentation.presenter.listMoviesPresenter.ListMoviesPresenter;
import com.oscar.mismejorespeliculas.presentation.ui.ListMoviesFragment;

import dagger.Module;
import dagger.Provides;

@Module
public class ListMoviesModule {

    @Provides
    public ListMoviesFragment providesListMoviesFragment(){
        return new ListMoviesFragment();
    }

    @Provides
    public GetListMovies providesGetListMovies(){
        return new GetListMovies(MovieDbClient.getInstance());
    }

    @Provides
    public ListMoviesPresenter providesListMoviesPresenter(ListMoviesFragment listMoviesFragment, GetListMovies getListMovies){
        return new ListMoviesPresenter(listMoviesFragment, getListMovies);
    }
}
