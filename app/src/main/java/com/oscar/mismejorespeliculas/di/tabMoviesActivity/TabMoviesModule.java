package com.oscar.mismejorespeliculas.di.tabMoviesActivity;

import android.content.Context;

import com.oscar.mismejorespeliculas.presentation.presenter.tabMoviesPresenter.TabMoviesPresenter;
import com.oscar.mismejorespeliculas.presentation.ui.TabMoviesActivity;

import dagger.Module;
import dagger.Provides;

/**
 * The type Tab movies module.
 */
@Module
public class TabMoviesModule {
    private final Context context;


    /**
     * Instantiates a new Tab movies module.
     *
     * @param context the context
     */
    public TabMoviesModule(Context context) {
        this.context = context;
    }

    /**
     * Get context context.
     *
     * @return the context
     */
    @Provides
    public Context getContext(){
        return context;
    }

    /**
     * Provides tab movies activity tab movies activity.
     *
     * @return the tab movies activity
     */
    @Provides
    public TabMoviesActivity providesTabMoviesActivity(){
        return new TabMoviesActivity();
    }

    /**
     * Provides tab movies presenter tab movies presenter.
     *
     * @param tabMoviesActivity the tab movies activity
     * @param context           the context
     * @return the tab movies presenter
     */
    @Provides
    public TabMoviesPresenter providesTabMoviesPresenter(TabMoviesActivity tabMoviesActivity, Context context){
        return new TabMoviesPresenter(tabMoviesActivity, context);
    }
}
