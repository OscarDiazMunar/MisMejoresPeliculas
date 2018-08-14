package com.oscar.mismejorespeliculas.data.repositories;

import com.oscar.mismejorespeliculas.domain.model.db.ResponseDataMovies;
import com.oscar.mismejorespeliculas.domain.model.db.ResponseMoviesDB;
import com.oscar.mismejorespeliculas.domain.model.db.ResultsDB;

import io.reactivex.Observable;


/**
 * The interface Repository db.
 */
public interface RepositoryDB {
    /**
     * Insert response movies long.
     *
     * @param responseMoviesDB the response movies db
     * @return the long
     */
    Long insertResponseMovies(ResponseMoviesDB responseMoviesDB);

    /**
     * Insert results long.
     *
     * @param resultsDB the results db
     * @return the long
     */
    Long insertResults(ResultsDB resultsDB);

    /**
     * Select all movies page a observable.
     *
     * @param page      the page
     * @param typeMovie the type movie
     * @return the observable
     */
    Observable<ResponseDataMovies> selectAllMoviesPageA(String page, String typeMovie);
}
