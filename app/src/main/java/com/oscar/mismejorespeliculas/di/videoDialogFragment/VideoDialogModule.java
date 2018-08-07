package com.oscar.mismejorespeliculas.di.videoDialogFragment;

import com.oscar.mismejorespeliculas.data.rest.themoviedb.MovieDbClient;
import com.oscar.mismejorespeliculas.domain.usecase.listMovies.GetListMovies;
import com.oscar.mismejorespeliculas.presentation.presenter.videoDialogPresenter.VideoDialogPresenter;
import com.oscar.mismejorespeliculas.presentation.ui.VideoDialogFragment;

import dagger.Module;
import dagger.Provides;

/**
 * The type Video dialog module.
 */
@Module
public class VideoDialogModule {
    /**
     * Provides video dialog fragment video dialog fragment.
     *
     * @return the video dialog fragment
     */
    @Provides
    public VideoDialogFragment providesVideoDialogFragment(){
        return new VideoDialogFragment();
    }

    /**
     * Provides get list movies get list movies.
     *
     * @return the get list movies
     */
    @Provides
    public GetListMovies providesGetListMovies(){
        return new GetListMovies(MovieDbClient.getInstance());
    }

    /**
     * Provides video dialog presenter video dialog presenter.
     *
     * @param videoDialogFragment the video dialog fragment
     * @param getListMovies       the get list movies
     * @return the video dialog presenter
     */
    @Provides
    public VideoDialogPresenter providesVideoDialogPresenter(VideoDialogFragment videoDialogFragment, GetListMovies getListMovies){
        return new VideoDialogPresenter(videoDialogFragment, getListMovies);
    }
}
