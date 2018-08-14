package com.oscar.mismejorespeliculas.domain.model.db;

import java.util.List;

/**
 * The type Response data movies.
 */
public class ResponseDataMovies {
    private ResponseMoviesDB responseMoviesDB;
    private List<ResultsDB> resultsDBS;

    /**
     * Instantiates a new Response data movies.
     *
     * @param responseMoviesDB the response movies db
     * @param resultsDBS       the results dbs
     */
    public ResponseDataMovies(ResponseMoviesDB responseMoviesDB, List<ResultsDB> resultsDBS) {
        this.responseMoviesDB = responseMoviesDB;
        this.resultsDBS = resultsDBS;
    }

    /**
     * Gets response movies db.
     *
     * @return the response movies db
     */
    public ResponseMoviesDB getResponseMoviesDB() {
        return responseMoviesDB;
    }

    /**
     * Sets response movies db.
     *
     * @param responseMoviesDB the response movies db
     */
    public void setResponseMoviesDB(ResponseMoviesDB responseMoviesDB) {
        this.responseMoviesDB = responseMoviesDB;
    }

    /**
     * Gets results dbs.
     *
     * @return the results dbs
     */
    public List<ResultsDB> getResultsDBS() {
        return resultsDBS;
    }

    /**
     * Sets results dbs.
     *
     * @param resultsDBS the results dbs
     */
    public void setResultsDBS(List<ResultsDB> resultsDBS) {
        this.resultsDBS = resultsDBS;
    }
}
