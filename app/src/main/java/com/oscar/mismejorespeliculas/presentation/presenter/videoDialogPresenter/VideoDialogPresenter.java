package com.oscar.mismejorespeliculas.presentation.presenter.videoDialogPresenter;

import com.oscar.mismejorespeliculas.domain.model.api.Videos;
import com.oscar.mismejorespeliculas.domain.usecase.UseCaseObserver;
import com.oscar.mismejorespeliculas.domain.usecase.listMovies.GetListMovies;
import com.oscar.mismejorespeliculas.presentation.presenter.Presenter;
import com.oscar.mismejorespeliculas.presentation.ui.VideoDialogFragment;
import com.oscar.mismejorespeliculas.presentation.view.IVideoDialogView;

/**
 * The type Video dialog presenter.
 */
public class VideoDialogPresenter extends Presenter<IVideoDialogView> implements IVideoDialogPresenter {
    private VideoDialogFragment videoDialogFragment;
    private GetListMovies getListMovies;

    /**
     * Instantiates a new Video dialog presenter.
     *
     * @param videoDialogFragment the video dialog fragment
     * @param getListMovies       the get list movies
     */
    public VideoDialogPresenter(VideoDialogFragment videoDialogFragment, GetListMovies getListMovies) {
        this.videoDialogFragment = videoDialogFragment;
        this.getListMovies = getListMovies;
    }

    @Override
    public void getVideo(String idMovie) {
        getListMovies.executeGetVideo(new GetVideosObserver(),idMovie);
    }

    /**
     * The type Get videos observer.
     */
    public class GetVideosObserver extends UseCaseObserver<Videos>{
        /**
         * The Videos.
         */
        Videos videos;
        @Override
        public void onNext(Videos value) {
            super.onNext(value);
            videos = value;
        }

        @Override
        public void onError(Throwable e) {
            super.onError(e);
        }

        @Override
        public void onComplete() {
            super.onComplete();
            if (videos.getResults().size() > 0){
                getView().showVideoFromYoutube(videos.getResults().get(0).getKey());
            }
        }
    }
}
