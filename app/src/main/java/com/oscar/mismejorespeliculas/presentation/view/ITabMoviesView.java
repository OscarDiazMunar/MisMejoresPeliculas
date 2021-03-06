package com.oscar.mismejorespeliculas.presentation.view;

import com.oscar.mismejorespeliculas.presentation.presenter.Presenter;

/**
 * The interface Tab movies view.
 */
public interface ITabMoviesView extends Presenter.PView {
    /**
     * Show progress.
     */
    void showProgress();

    /**
     * Dismiss progress.
     */
    void dismissProgress();
}
