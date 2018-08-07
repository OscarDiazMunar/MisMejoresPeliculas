package com.oscar.mismejorespeliculas.presentation.view;

import com.oscar.mismejorespeliculas.presentation.presenter.Presenter;

/**
 * The interface Video dialog view.
 */
public interface IVideoDialogView extends Presenter.PView{
    /**
     * Show progress.
     */
    void showProgress();

    /**
     * Dismiss progress.
     */
    void dismissProgress();

    /**
     * Show video from youtube.
     *
     * @param keyMovie the key movie
     */
    void showVideoFromYoutube(String keyMovie);
}
