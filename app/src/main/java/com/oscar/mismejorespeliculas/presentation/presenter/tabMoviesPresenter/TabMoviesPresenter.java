package com.oscar.mismejorespeliculas.presentation.presenter.tabMoviesPresenter;

import android.content.Context;
import android.util.Log;

import com.oscar.mismejorespeliculas.presentation.presenter.Presenter;
import com.oscar.mismejorespeliculas.presentation.ui.TabMoviesActivity;
import com.oscar.mismejorespeliculas.presentation.view.ITabMoviesView;

/**
 * The type Tab movies presenter.
 */
public class TabMoviesPresenter extends Presenter<ITabMoviesView> implements ITabMoviesPresenter{
    private TabMoviesActivity tabMoviesActivity;
    private Context context;


    /**
     * Instantiates a new Tab movies presenter.
     *
     * @param tabMoviesActivity the tab movies activity
     * @param context           the context
     */
    public TabMoviesPresenter(TabMoviesActivity tabMoviesActivity, Context context) {
        this.tabMoviesActivity = tabMoviesActivity;
        this.context = context;
    }

    @Override
    public void onCreate() {
        Log.e("DAGGER", "FUNCIONA");
    }
}
