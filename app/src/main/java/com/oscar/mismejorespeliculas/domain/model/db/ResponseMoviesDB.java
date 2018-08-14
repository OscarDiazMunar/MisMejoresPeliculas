package com.oscar.mismejorespeliculas.domain.model.db;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Property;
import org.greenrobot.greendao.annotation.Generated;

@Entity(nameInDb = "pageMovies")
public class ResponseMoviesDB {

    @Id(autoincrement = true)
    private Long id;

    @Property(nameInDb = "page")
    private String page;

    @Property(nameInDb = "total_page")
    private String total_pages;

    @Property(nameInDb = "type_movie")
    private String typeMovie;

    @Generated(hash = 490208822)
    public ResponseMoviesDB(Long id, String page, String total_pages,
            String typeMovie) {
        this.id = id;
        this.page = page;
        this.total_pages = total_pages;
        this.typeMovie = typeMovie;
    }

    @Generated(hash = 376297580)
    public ResponseMoviesDB() {
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPage() {
        return this.page;
    }

    public void setPage(String page) {
        this.page = page;
    }

    public String getTotal_pages() {
        return this.total_pages;
    }

    public void setTotal_pages(String total_pages) {
        this.total_pages = total_pages;
    }

    public String getTypeMovie() {
        return this.typeMovie;
    }

    public void setTypeMovie(String typeMovie) {
        this.typeMovie = typeMovie;
    }

    @Override
    public String toString() {
        return "ResponseMoviesDB{" +
                "id=" + id +
                ", page='" + page + '\'' +
                ", total_pages='" + total_pages + '\'' +
                ", typeMovie='" + typeMovie + '\'' +
                '}';
    }
}
