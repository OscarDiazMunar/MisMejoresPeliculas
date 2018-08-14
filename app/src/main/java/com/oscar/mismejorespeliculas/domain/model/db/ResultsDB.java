package com.oscar.mismejorespeliculas.domain.model.db;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Property;
import org.greenrobot.greendao.annotation.Generated;

@Entity(nameInDb = "resultsMovies")
public class ResultsDB {
    @Id(autoincrement = true)
    private Long id;

    @Property(nameInDb = "date")
    private String date;

    @Property(nameInDb = "id_movie")
    private String idMovie;

    @Property(nameInDb = "overview")
    private String overview;

    @Property(nameInDb = "original_title")
    private String originalTitle;

    @Property(nameInDb = "vote")
    private String vote;

    @Property(nameInDb = "poster_path")
    private String posterPath;

    @Property(nameInDb = "page")
    private String page;

    @Property(nameInDb = "type_movie")
    private String typeMovie;

    @Generated(hash = 84878868)
    public ResultsDB(Long id, String date, String idMovie, String overview,
            String originalTitle, String vote, String posterPath, String page,
            String typeMovie) {
        this.id = id;
        this.date = date;
        this.idMovie = idMovie;
        this.overview = overview;
        this.originalTitle = originalTitle;
        this.vote = vote;
        this.posterPath = posterPath;
        this.page = page;
        this.typeMovie = typeMovie;
    }

    @Generated(hash = 383981607)
    public ResultsDB() {
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDate() {
        return this.date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getIdMovie() {
        return this.idMovie;
    }

    public void setIdMovie(String idMovie) {
        this.idMovie = idMovie;
    }

    public String getOverview() {
        return this.overview;
    }

    public void setOverview(String overview) {
        this.overview = overview;
    }

    public String getOriginalTitle() {
        return this.originalTitle;
    }

    public void setOriginalTitle(String originalTitle) {
        this.originalTitle = originalTitle;
    }

    public String getVote() {
        return this.vote;
    }

    public void setVote(String vote) {
        this.vote = vote;
    }

    public String getPosterPath() {
        return this.posterPath;
    }

    public void setPosterPath(String posterPath) {
        this.posterPath = posterPath;
    }

    public String getPage() {
        return this.page;
    }

    public void setPage(String page) {
        this.page = page;
    }

    public String getTypeMovie() {
        return this.typeMovie;
    }

    public void setTypeMovie(String typeMovie) {
        this.typeMovie = typeMovie;
    }
}
