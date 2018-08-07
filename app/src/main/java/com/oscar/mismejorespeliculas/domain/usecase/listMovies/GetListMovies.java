package com.oscar.mismejorespeliculas.domain.usecase.listMovies;

import com.oscar.mismejorespeliculas.data.repositories.RepositoryListMovies;

import io.reactivex.Observable;

/**
 * The type Get list movies.
 */
public class GetListMovies extends UseCaseListMovies {
    private final RepositoryListMovies repositoryListMovies;

    /**
     * Instantiates a new Get list movies.
     *
     * @param repositoryListMovies the repository list movies
     */
    public GetListMovies(RepositoryListMovies repositoryListMovies) {
        this.repositoryListMovies = repositoryListMovies;
    }

    @Override
    Observable buildUseCasePopularMoviesObservable(String page) {
        return repositoryListMovies.getListPopularMovie(page);
    }

    @Override
    Observable buildUseCaseTopRatedMoviesObservable(String page) {
        return repositoryListMovies.getListTopRatedMovie(page);
    }

    @Override
    Observable buildUseCaseUpcomingMoviesObservable(String page) {
        return repositoryListMovies.getListUpcomingMovie(page);
    }
}
