package com.oscar.mismejorespeliculas.presentation.ui;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.oscar.mismejorespeliculas.R;
import com.oscar.mismejorespeliculas.di.videoDialogFragment.DaggerVideoDialogComponent;
import com.oscar.mismejorespeliculas.di.videoDialogFragment.VideoDialogComponent;
import com.oscar.mismejorespeliculas.di.videoDialogFragment.VideoDialogModule;
import com.oscar.mismejorespeliculas.presentation.presenter.videoDialogPresenter.VideoDialogPresenter;
import com.oscar.mismejorespeliculas.presentation.view.IVideoDialogView;
import com.oscar.mismejorespeliculas.utils.Constants;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * to handle interaction events.
 * Use the {@link VideoDialogFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class VideoDialogFragment extends DialogFragment implements IVideoDialogView{

    /**
     * The Youtube video.
     */
    WebView youtubeVideo;

    private View layoutVideo;
    private WebViewClient webViewClient;
    private WebSettings webSettings;
    private String idMovie;

    /**
     * The Presenter.
     */
    @Inject
    VideoDialogPresenter presenter;

    /**
     * Instantiates a new Video dialog fragment.
     */
    public VideoDialogFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param idMovie the id movie
     * @return A new instance of fragment VideoDialogFragment.
     */
// TODO: Rename and change types and number of parameters
    public static VideoDialogFragment newInstance(String idMovie) {
        VideoDialogFragment fragment = new VideoDialogFragment();
        Bundle args = new Bundle();
        args.putString(Constants.ARGS.ID_MOVIE, idMovie);
        fragment.setArguments(args);
        return fragment;
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        if (getArguments() != null) {
            idMovie = getArguments().getString(Constants.ARGS.ID_MOVIE);
        }
        Log.e("IDMOVIE", idMovie);
        return showVideoDialog();
    }

    /**
     * Show video dialog alert dialog.
     *
     * @return the alert dialog
     */
    public AlertDialog showVideoDialog() {
        AlertDialog.Builder dialogVideo = new AlertDialog.Builder(getActivity());
        LayoutInflater inflater = LayoutInflater.from(getActivity());
        layoutVideo = inflater.inflate(R.layout.fragment_video_dialog, null);
        youtubeVideo = layoutVideo.findViewById(R.id.youtubeVideo);
        dialogVideo.setView(layoutVideo);
        return dialogVideo.create();
    }

    @Override
    public void onStart() {
        super.onStart();
        presenter.getVideo(idMovie);
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        initializeDagger();
        presenter.setView(this);
    }

    private void initializeDagger() {
        VideoDialogComponent videoDialogComponent = DaggerVideoDialogComponent.builder()
                .videoDialogModule(new VideoDialogModule()).build();
        videoDialogComponent.inject(this);
    }

    @Override
    public void onDetach() {
        super.onDetach();

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();

    }

    @Override
    public void showProgress() {

    }

    @Override
    public void dismissProgress() {

    }

    @Override
    public void showVideoFromYoutube(String keyMovie) {
        webViewClient = new WebViewClient();
        webSettings = youtubeVideo.getSettings();
        webSettings.setJavaScriptEnabled(true);
        String urlYoutube = Constants.URL.YOUTUBE + keyMovie;
        youtubeVideo.loadUrl(urlYoutube);
        youtubeVideo.setWebViewClient(webViewClient);
    }
}
