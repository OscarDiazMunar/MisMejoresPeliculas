package com.oscar.mismejorespeliculas.domain.model.api;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 * The type Results.
 */
public class Results implements Serializable {
    @SerializedName("vote_average")
    private String vote_average;

    @SerializedName("id")
    private String id;

    @SerializedName("overview")
    private String overview;

    @SerializedName("original_language")
    private String original_language;

    @SerializedName("release_date")
    private String release_date;

    @SerializedName("original_title")
    private String original_title;

    @SerializedName("poster_path")
    private String poster_path;

    /**
     * Instantiates a new Results.
     *
     * @param vote_average   the vote average
     * @param overview       the overview
     * @param release_date   the release date
     * @param original_title the original title
     * @param poster_path    the poster path
     * @param id             the id
     */
    public Results(String vote_average, String overview, String release_date, String original_title, String poster_path, String id) {
        this.vote_average = vote_average;
        this.overview = overview;
        this.release_date = release_date;
        this.original_title = original_title;
        this.poster_path = poster_path;
        this.id = id;
    }

    /**
     * Gets vote average.
     *
     * @return the vote average
     */
    public String getVote_average ()
    {
        return vote_average;
    }

    /**
     * Sets vote average.
     *
     * @param vote_average the vote average
     */
    public void setVote_average (String vote_average)
    {
        this.vote_average = vote_average;
    }

    /**
     * Gets id.
     *
     * @return the id
     */
    public String getId ()
    {
        return id;
    }

    /**
     * Sets id.
     *
     * @param id the id
     */
    public void setId (String id)
    {
        this.id = id;
    }

    /**
     * Gets overview.
     *
     * @return the overview
     */
    public String getOverview ()
    {
        return overview;
    }

    /**
     * Sets overview.
     *
     * @param overview the overview
     */
    public void setOverview (String overview)
    {
        this.overview = overview;
    }

    /**
     * Gets original language.
     *
     * @return the original language
     */
    public String getOriginal_language ()
    {
        return original_language;
    }

    /**
     * Sets original language.
     *
     * @param original_language the original language
     */
    public void setOriginal_language (String original_language)
    {
        this.original_language = original_language;
    }

    /**
     * Gets release date.
     *
     * @return the release date
     */
    public String getRelease_date ()
    {
        return release_date;
    }

    /**
     * Sets release date.
     *
     * @param release_date the release date
     */
    public void setRelease_date (String release_date)
    {
        this.release_date = release_date;
    }

    /**
     * Gets original title.
     *
     * @return the original title
     */
    public String getOriginal_title ()
    {
        return original_title;
    }

    /**
     * Sets original title.
     *
     * @param original_title the original title
     */
    public void setOriginal_title (String original_title)
    {
        this.original_title = original_title;
    }

    /**
     * Gets poster path.
     *
     * @return the poster path
     */
    public String getPoster_path ()
    {
        return poster_path;
    }

    /**
     * Sets poster path.
     *
     * @param poster_path the poster path
     */
    public void setPoster_path (String poster_path)
    {
        this.poster_path = poster_path;
    }


    @Override
    public String toString() {
        return "Results{" +
                "vote_average='" + vote_average + '\'' +
                ", id='" + id + '\'' +
                ", overview='" + overview + '\'' +
                ", original_language='" + original_language + '\'' +
                ", release_date='" + release_date + '\'' +
                ", original_title='" + original_title + '\'' +
                ", poster_path='" + poster_path + '\'' +
                '}';
    }
}
