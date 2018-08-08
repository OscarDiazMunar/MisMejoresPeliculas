package com.oscar.mismejorespeliculas.domain.usecase.listMoviesDB;

import com.oscar.mismejorespeliculas.data.repositories.RepositoryDB;

import io.reactivex.Observable;

/**
 * The type Select list movies db.
 */
public class SelectListMoviesDB extends UseCaseListMoviesDB{
    private final RepositoryDB repositoryDB;

    /**
     * Instantiates a new Select list movies db.
     *
     * @param repositoryDB the repository db
     */
    public SelectListMoviesDB(RepositoryDB repositoryDB) {
        this.repositoryDB = repositoryDB;
    }

    @Override
    Observable buildUseCaseMoviesDBObservable(String page, String typeMovies) {
        return repositoryDB.selectAllMoviesPage(page, typeMovies);
    }
}
