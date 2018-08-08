package com.oscar.mismejorespeliculas.data.repositories;

import com.oscar.mismejorespeliculas.domain.model.ResponseMovies;

import io.reactivex.Observable;


/**
 * The interface Repository db.
 */
public interface RepositoryDB {
    /**
     * Select all movies page observable.
     *
     * @param page      the page
     * @param typeMovie the type movie
     * @return the observable
     */
    Observable<ResponseMovies> selectAllMoviesPage(String page, String typeMovie);

    /**
     * Insert data movies.
     *
     * @param responseMovies the response movies
     * @param typeMoves      the type moves
     * @return the long
     */
    Long insertDataMovies(ResponseMovies responseMovies, String typeMoves);
}
