package com.oscar.mismejorespeliculas.domain.model;

import java.io.Serializable;
import java.util.List;

/**
 * The type Response movies.
 */
public class ResponseMovies implements Serializable {
    private List<Results> results;

    private String page;

    private String total_pages;

    private String total_results;

    /**
     * Gets results.
     *
     * @return the results
     */
    public List<Results> getResults ()
    {
        return results;
    }

    /**
     * Sets results.
     *
     * @param results the results
     */
    public void setResults (List<Results> results)
    {
        this.results = results;
    }

    /**
     * Gets page.
     *
     * @return the page
     */
    public String getPage ()
    {
        return page;
    }

    /**
     * Sets page.
     *
     * @param page the page
     */
    public void setPage (String page)
    {
        this.page = page;
    }

    /**
     * Gets total pages.
     *
     * @return the total pages
     */
    public String getTotal_pages ()
    {
        return total_pages;
    }

    /**
     * Sets total pages.
     *
     * @param total_pages the total pages
     */
    public void setTotal_pages (String total_pages)
    {
        this.total_pages = total_pages;
    }

    /**
     * Gets total results.
     *
     * @return the total results
     */
    public String getTotal_results ()
    {
        return total_results;
    }

    /**
     * Sets total results.
     *
     * @param total_results the total results
     */
    public void setTotal_results (String total_results)
    {
        this.total_results = total_results;
    }

    @Override
    public String toString() {
        return "ResponseMovies{" +
                "results=" + results +
                ", page='" + page + '\'' +
                ", total_pages='" + total_pages + '\'' +
                ", total_results='" + total_results + '\'' +
                '}';
    }
}
