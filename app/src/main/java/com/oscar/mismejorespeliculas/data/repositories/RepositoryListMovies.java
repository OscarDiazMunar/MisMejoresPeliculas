package com.oscar.mismejorespeliculas.data.repositories;

import com.oscar.mismejorespeliculas.domain.model.ResponseMovies;

import io.reactivex.Observable;

/**
 * The interface Repository list movies.
 */
public interface RepositoryListMovies {
    /**
     * Gets list popular movie.
     *
     * @param page the page
     * @return the list popular movie
     */
    Observable<ResponseMovies> getListPopularMovie(String page);

    /**
     * Gets list top rated movie.
     *
     * @param page the page
     * @return the list top rated movie
     */
    Observable<ResponseMovies> getListTopRatedMovie(String page);

    /**
     * Gets list upcoming movie.
     *
     * @param page the page
     * @return the list upcoming movie
     */
    Observable<ResponseMovies> getListUpcomingMovie(String page);
}
