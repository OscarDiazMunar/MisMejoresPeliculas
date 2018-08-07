package com.oscar.mismejorespeliculas.presentation.view;

import com.oscar.mismejorespeliculas.presentation.presenter.Presenter;

public interface IListMoviesView extends Presenter.PView {
    /**
     * Show progress.
     */
    void showProgress();

    /**
     * Dismiss progress.
     */
    void dismissProgress();
}
