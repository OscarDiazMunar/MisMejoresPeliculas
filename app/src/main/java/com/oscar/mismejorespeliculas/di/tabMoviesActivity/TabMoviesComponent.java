package com.oscar.mismejorespeliculas.di.tabMoviesActivity;

import com.oscar.mismejorespeliculas.presentation.ui.TabMoviesActivity;

import javax.inject.Singleton;

import dagger.Component;

/**
 * The interface Tab movies component.
 */
@Singleton
@Component(modules = TabMoviesModule.class)
public interface TabMoviesComponent {

    /**
     * Inject.
     *
     * @param moviesActivity the movies activity
     */
    void inject(TabMoviesActivity moviesActivity);
}
