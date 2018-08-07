package com.oscar.mismejorespeliculas.presentation.ui;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.oscar.mismejorespeliculas.R;
import com.oscar.mismejorespeliculas.di.listMoviesFragment.DaggerListMoviesComponent;
import com.oscar.mismejorespeliculas.di.listMoviesFragment.ListMoviesComponent;
import com.oscar.mismejorespeliculas.di.listMoviesFragment.ListMoviesModule;
import com.oscar.mismejorespeliculas.domain.model.ResponseMovies;
import com.oscar.mismejorespeliculas.domain.model.Results;
import com.oscar.mismejorespeliculas.managers.MoviesListAdapter;
import com.oscar.mismejorespeliculas.managers.OnItemClickListener;
import com.oscar.mismejorespeliculas.presentation.presenter.listMoviesPresenter.ListMoviesPresenter;
import com.oscar.mismejorespeliculas.presentation.view.IListMoviesView;
import com.oscar.mismejorespeliculas.utils.Constants;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * to handle interaction events.
 * Use the {@link ListMoviesFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ListMoviesFragment extends Fragment implements IListMoviesView, OnItemClickListener {


    @Inject
    ListMoviesPresenter presenter;

    @BindView(R.id.RecyclerListMovies)
    RecyclerView recyclerListMovies;
    Unbinder unbinder;

    public MoviesListAdapter moviesListAdapter;
    private Context context;
    private List<Results> resultsListAux = new ArrayList<>();
    private int typeFragment;

    public ListMoviesFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @return A new instance of fragment ListMoviesFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static ListMoviesFragment newInstance(int typeFragment) {
        ListMoviesFragment fragment = new ListMoviesFragment();
        Bundle args = new Bundle();
        //args.putString(ARG_PARAM1, param1);
        //args.putString(ARG_PARAM2, param2);
        args.putInt(Constants.ARGS.TYPE_FRAGMENT, typeFragment);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            typeFragment = getArguments().getInt(Constants.ARGS.TYPE_FRAGMENT);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_list_movies, container, false);
        unbinder = ButterKnife.bind(this, view);
        moviesListAdapter = new MoviesListAdapter(resultsListAux, getContext(), this);
        recyclerListMovies.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerListMovies.setAdapter(moviesListAdapter);
        return view;
    }


    @Override
    public void onAttach(Context context) {
        initializeDagger();
        this.context = context;
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
        switch (typeFragment){
            case 0:
                presenter.getListPopularMovies("1");
                break;
            case 1:
                presenter.getListTopratedMovies("1");
                break;
            case 2:
                presenter.getListUpcomingMovies("1");
                break;

        }


    }

    @Override
    public void showProgress() {

    }

    @Override
    public void dismissProgress() {

    }

    @Override
    public void setDataResults(ResponseMovies responseMovies) {
        List<Results> resultsList = responseMovies.getResults();
        Log.e("HOLA", "LISTA");
        for (Results item: resultsList ) {
            Log.e("ITEM", item.toString());
            resultsListAux.add(item);
        }
        moviesListAdapter.notifyDataSetChanged();

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    @Override
    public void onItemClick(Results results) {

    }
}
