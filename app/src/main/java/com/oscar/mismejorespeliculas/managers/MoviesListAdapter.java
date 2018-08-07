package com.oscar.mismejorespeliculas.managers;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.oscar.mismejorespeliculas.R;
import com.oscar.mismejorespeliculas.domain.model.Results;
import com.oscar.mismejorespeliculas.utils.Constants;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MoviesListAdapter extends RecyclerView.Adapter<MoviesListAdapter.ViewHolder> {

    private Context context;
    private List<Results> resultsList;
    private OnItemClickListener onItemClickListener;

    public MoviesListAdapter(List<Results> resultsList, Context context, OnItemClickListener onItemClickListener) {
        this.context = context;
        this.resultsList = resultsList;
        this.onItemClickListener = onItemClickListener;
    }

    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.content_movies_list, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Results dataMovie = resultsList.get(position);
        holder.txtTitleMovie.setText(dataMovie.getOriginal_title());
        holder.txtOverviewMovie.setText(dataMovie.getOverview());
        holder.txtScore.setText(dataMovie.getVote_average());
        holder.txtRelease.setText(dataMovie.getRelease_date());
        String urlPhoto = Constants.URL.PHOTO + dataMovie.getPoster_path();
        Glide.with(context).load(urlPhoto).into(holder.imgPoster);
        holder.setClickListener(dataMovie, onItemClickListener);
    }

    @Override
    public int getItemCount() {
        return resultsList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.txt_title_movie)
        TextView txtTitleMovie;
        @BindView(R.id.img_poster)
        ImageView imgPoster;
        @BindView(R.id.txt_overview_movie)
        TextView txtOverviewMovie;
        @BindView(R.id.txt_release)
        TextView txtRelease;
        @BindView(R.id.txt_score)
        TextView txtScore;

        View view;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            this.view = itemView;
            ButterKnife.bind(this, itemView);
        }

        public void setClickListener(final Results results, final OnItemClickListener listner){
            view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    listner.onItemClick(results);
                }
            });
        }
    }
}
