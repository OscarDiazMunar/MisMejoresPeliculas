package com.oscar.mismejorespeliculas.di.videoDialogFragment;

import com.oscar.mismejorespeliculas.presentation.ui.VideoDialogFragment;

import javax.inject.Singleton;

import dagger.Component;

/**
 * The interface Video dialog component.
 */
@Singleton
@Component(modules = VideoDialogModule.class)
public interface VideoDialogComponent {
    /**
     * Inject.
     *
     * @param videoDialogFragment the video dialog fragment
     */
    void inject(VideoDialogFragment videoDialogFragment);
}
