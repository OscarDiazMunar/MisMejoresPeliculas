package com.oscar.mismejorespeliculas.presentation.presenter.listMoviesPresenter;

/**
 * The interface List movies presenter.
 */
public interface IListMoviesPresenter {
    /**
     * On create.
     */
    void onCreate();

    /**
     * Gets list popular movies.
     *
     * @param page the page
     */
    void getListPopularMovies(String page);

    /**
     * Gets list toprated movies.
     *
     * @param page the page
     */
    void getListTopratedMovies(String page);

    /**
     * Gets list upcoming movies.
     *
     * @param page the page
     */
    void getListUpcomingMovies(String page);
}
