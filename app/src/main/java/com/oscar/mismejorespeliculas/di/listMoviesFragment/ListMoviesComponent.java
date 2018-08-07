package com.oscar.mismejorespeliculas.di.listMoviesFragment;

import com.oscar.mismejorespeliculas.presentation.ui.ListMoviesFragment;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = ListMoviesModule.class)
public interface ListMoviesComponent {
    void inject(ListMoviesFragment listMoviesFragment);
}
