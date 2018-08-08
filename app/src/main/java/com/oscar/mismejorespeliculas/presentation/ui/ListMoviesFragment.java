package com.oscar.mismejorespeliculas.presentation.ui;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

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
import butterknife.OnClick;
import butterknife.Unbinder;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * to handle interaction events.
 * Use the {@link ListMoviesFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ListMoviesFragment extends Fragment implements IListMoviesView, OnItemClickListener {


    /**
     * The Presenter.
     */
    @Inject
    ListMoviesPresenter presenter;

    /**
     * The Recycler list movies.
     */
    @BindView(R.id.RecyclerListMovies)
    RecyclerView recyclerListMovies;
    /**
     * The Unbinder.
     */
    Unbinder unbinder;

    /**
     * The Movies list adapter.
     */
    public MoviesListAdapter moviesListAdapter;
    /**
     * The Btnback.
     */
    @BindView(R.id.btnback)
    Button btnback;
    /**
     * The Page.
     */
    @BindView(R.id.page)
    TextView page;
    /**
     * The Btnnext.
     */
    @BindView(R.id.btnnext)
    Button btnnext;
    private Context context;
    private List<Results> resultsListAux = new ArrayList<>();
    private int typeFragment;
    private int pageCont = 1;
    private int pageTotal;

    /**
     * Instantiates a new List movies fragment.
     */
    public ListMoviesFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param typeFragment the type fragment
     * @return A new instance of fragment ListMoviesFragment.
     */
// TODO: Rename and change types and number of parameters
    public static ListMoviesFragment newInstance(int typeFragment) {
        ListMoviesFragment fragment = new ListMoviesFragment();
        Bundle args = new Bundle();
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
        presenter.onCreate();
        presenter.setTyeMovies(Integer.toString(typeFragment));
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
                .listMoviesModule(new ListMoviesModule(getContext())).build();
        listMoviesComponent.inject(this);
    }

    @Override
    public void onDetach() {
        super.onDetach();

    }

    @Override
    public void onStart() {
        super.onStart();
        presenter.setPageNow(Integer.toString(pageCont));
        selectTypeFragment(Integer.toString(pageCont));
    }

    private void selectTypeFragment(String page){
        switch (typeFragment) {
            case 0:
                presenter.getListPopularMovies(page);
                break;
            case 1:
                presenter.getListTopratedMovies(page);
                break;
            case 2:
                presenter.getListUpcomingMovies(page);
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
        resultsListAux.clear();
        List<Results> resultsList = responseMovies.getResults();
        for (Results item : resultsList) {
            resultsListAux.add(item);
        }
        moviesListAdapter.notifyDataSetChanged();
        pageTotal = Integer.parseInt(responseMovies.getTotal_pages());
        String pager = Integer.toString(pageCont) + " de " + responseMovies.getTotal_pages();
        page.setText(pager);
    }

    @Override
    public void showErrorNoConnection(String message) {
        Toast.makeText(getContext(), message, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    @Override
    public void onItemClick(Results results) {
        VideoDialogFragment videoDialogFragment = VideoDialogFragment.newInstance(results.getId());
        videoDialogFragment.show(getFragmentManager(), "hola");
    }

    /**
     * On view clicked.
     *
     * @param view the view
     */
    @OnClick({R.id.btnback, R.id.btnnext})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.btnback:
                if (pageCont != 1){
                    pageCont--;
                    selectTypeFragment(Integer.toString(pageCont));
                }
                break;
            case R.id.btnnext:
                if (pageCont < pageTotal){
                    pageCont++;
                    selectTypeFragment(Integer.toString(pageCont));
                }
                break;
        }
    }
}
