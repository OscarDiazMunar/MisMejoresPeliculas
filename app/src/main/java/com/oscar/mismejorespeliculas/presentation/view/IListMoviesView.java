package com.oscar.mismejorespeliculas.presentation.view;

import com.oscar.mismejorespeliculas.domain.model.ResponseMovies;
import com.oscar.mismejorespeliculas.domain.model.Results;
import com.oscar.mismejorespeliculas.presentation.presenter.Presenter;

import java.util.List;

public interface IListMoviesView extends Presenter.PView {
    /**
     * Show progress.
     */
    void showProgress();

    /**
     * Dismiss progress.
     */
    void dismissProgress();
    void setDataResults(ResponseMovies responseMovies);
}
