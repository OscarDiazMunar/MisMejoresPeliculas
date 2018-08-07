package com.oscar.mismejorespeliculas.presentation.ui;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.oscar.mismejorespeliculas.R;
import com.oscar.mismejorespeliculas.di.listMoviesFragment.DaggerListMoviesComponent;
import com.oscar.mismejorespeliculas.di.listMoviesFragment.ListMoviesComponent;
import com.oscar.mismejorespeliculas.di.listMoviesFragment.ListMoviesModule;
import com.oscar.mismejorespeliculas.presentation.presenter.listMoviesPresenter.ListMoviesPresenter;
import com.oscar.mismejorespeliculas.presentation.view.IListMoviesView;

import javax.inject.Inject;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * to handle interaction events.
 * Use the {@link ListMoviesFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ListMoviesFragment extends Fragment implements IListMoviesView{


    @Inject
    ListMoviesPresenter presenter;

    public ListMoviesFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     * @return A new instance of fragment ListMoviesFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static ListMoviesFragment newInstance() {
        ListMoviesFragment fragment = new ListMoviesFragment();
        Bundle args = new Bundle();
        //args.putString(ARG_PARAM1, param1);
        //args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {

        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_list_movies, container, false);
    }

    @Override
    public void onAttach(Context context) {
        initializeDagger();
        presenter.setView(this);
        super.onAttach(context);

    }

    private void initializeDagger() {
        ListMoviesComponent listMoviesComponent = DaggerListMoviesComponent.builder()
                .listMoviesModule(new ListMoviesModule()).build();
        listMoviesComponent.inject(this);
    }

    @Override
    public void onDetach() {
        super.onDetach();

    }

    @Override
    public void onStart() {
        super.onStart();
        presenter.getListPopularMovies("1");
    }

    @Override
    public void showProgress() {

    }

    @Override
    public void dismissProgress() {

    }
}
