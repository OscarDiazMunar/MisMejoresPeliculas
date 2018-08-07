package com.oscar.mismejorespeliculas.di.listMoviesFragment;

import com.oscar.mismejorespeliculas.presentation.ui.ListMoviesFragment;

import javax.inject.Singleton;

import dagger.Component;

/**
 * The interface List movies component.
 */
@Singleton
@Component(modules = ListMoviesModule.class)
public interface ListMoviesComponent {
    /**
     * Inject.
     *
     * @param listMoviesFragment the list movies fragment
     */
    void inject(ListMoviesFragment listMoviesFragment);
}
