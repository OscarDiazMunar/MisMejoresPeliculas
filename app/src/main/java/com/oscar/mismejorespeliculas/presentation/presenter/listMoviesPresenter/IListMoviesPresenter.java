package com.oscar.mismejorespeliculas.presentation.presenter.listMoviesPresenter;

public interface IListMoviesPresenter {
    /**
     * On create.
     */
    void onCreate();
    void getListPopularMovies(String page);
    void getListTopratedMovies(String page);
    void getListUpcomingMovies(String page);
}
