package com.oscar.mismejorespeliculas.data.rest.themoviedb;

import com.oscar.mismejorespeliculas.domain.model.ResponseMovies;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * The interface Movie db service.
 */
public interface MovieDbService {
    /**
     * Gets list popular movies.
     *
     * @param apiKey   the api key
     * @param language the language
     * @param page     the page
     * @return the list popular movies
     */
    @GET("popular")
    Observable<ResponseMovies> getListPopularMovies(@Query("api_key") String apiKey,
                                                        @Query("language") String language,
                                                        @Query("page") String page);

    /**
     * Gets list toprated movies.
     *
     * @param apiKey   the api key
     * @param language the language
     * @param page     the page
     * @return the list toprated movies
     */
    @GET("top_rated")
    Observable<ResponseMovies> getListTopratedMovies(@Query("api_key") String apiKey,
                                                        @Query("language") String language,
                                                        @Query("page") String page);

    /**
     * Gets list upcoming movies.
     *
     * @param apiKey   the api key
     * @param language the language
     * @param page     the page
     * @return the list upcoming movies
     */
    @GET("upcoming")
    Observable<ResponseMovies> getListUpcomingMovies(@Query("api_key") String apiKey,
                                                        @Query("language") String language,
                                                        @Query("page") String page);
}
