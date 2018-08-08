package com.oscar.mismejorespeliculas.data.db;

import android.content.Context;

import com.oscar.mismejorespeliculas.data.repositories.RepositoryDB;
import com.oscar.mismejorespeliculas.domain.model.ResponseMovies;

import io.reactivex.Observable;

/**
 * The type Db handler.
 */
public class DBHandler implements RepositoryDB {
    private CRUD DBCRUD;

    /**
     * Instantiates a new Db handler.
     *
     * @param context the context
     */
    public DBHandler(Context context) {
        this.DBCRUD = new CRUD(context);
    }

    @Override
    public Observable<ResponseMovies> selectAllMoviesPage(String page, String typeMovie) {
        return DBCRUD.getAllMoviesTypeDB(page, typeMovie);
    }

    @Override
    public Long insertDataMovies(ResponseMovies responseMovies, String typeMoves) {
        return DBCRUD.insertMoviesDB(responseMovies, typeMoves);
    }
}
