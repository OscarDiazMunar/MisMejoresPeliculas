package com.oscar.mismejorespeliculas.presentation.view;

import com.oscar.mismejorespeliculas.domain.model.ResponseMovies;
import com.oscar.mismejorespeliculas.domain.model.Results;
import com.oscar.mismejorespeliculas.presentation.presenter.Presenter;

import java.util.List;

/**
 * The interface List movies view.
 */
public interface IListMoviesView extends Presenter.PView {
    /**
     * Show progress.
     */
    void showProgress();

    /**
     * Dismiss progress.
     */
    void dismissProgress();

    /**
     * Sets data results.
     *
     * @param responseMovies the response movies
     */
    void setDataResults(ResponseMovies responseMovies);

    /**
     * Show error no connection.
     *
     * @param message the message
     */
    void showErrorNoConnection(String message);
}
