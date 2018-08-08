package com.oscar.mismejorespeliculas.data.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.oscar.mismejorespeliculas.domain.model.ResponseMovies;
import com.oscar.mismejorespeliculas.domain.model.Results;

import java.util.ArrayList;

import io.reactivex.Observable;

/**
 * The type Crud.
 */
public class CRUD {
    private DBHelper dbHelper;

    /**
     * Instantiates a new Crud.
     *
     * @param context the context
     */
    public CRUD(Context context) {
        this.dbHelper = DBHelper.getInstance(context);
    }

    /**
     * The constant CREATE_TABLE_PAGEMOVIES.
     */
    public static final String CREATE_TABLE_PAGEMOVIES = "CREATE TABLE IF NOT EXISTS "+ ResponseMovies.TABLE + "("
            + ResponseMovies.KEY_ID + " integer primary key autoincrement,"
            + ResponseMovies.KEY_PAGE + " text not null,"
            + ResponseMovies.KEY_TOTAL_PAGE + " text not null,"
            + ResponseMovies.KEY_TYPEMOVIE + " text not null"
            + ");";

    /**
     * The constant CREATE_TABLE_RESULTMOVIES.
     */
    public static final String CREATE_TABLE_RESULTMOVIES = "CREATE TABLE IF NOT EXISTS "+ Results.TABLE + "("
            + Results.KEY_ID + " integer primary key autoincrement,"
            + Results.KEY_DATE + " text not null,"
            + Results.KEY_ID_MOVIE + " text not null,"
            + Results.KEY_OVERVIEW + " text not null,"
            + Results.KEY_TITLE + " text not null,"
            + Results.KEY_VOTE + " text not null,"
            + Results.KEY_POSTER + " text not null,"
            + Results.KEY_PAGE + " text not null,"
            + Results.KEY_TYPEMOVIE + " text not null"
            + ");";

    /**
     * Insert movies db long.
     *
     * @param responseMovies the response movies
     * @param typeMovie      the type movie
     * @return the long
     */
    public Long insertMoviesDB(ResponseMovies responseMovies, String typeMovie){
        SQLiteDatabase db = this.dbHelper.getWritableDatabase();
        ContentValues values = new ContentValues();
        long response = 0;

        String pageU = responseMovies.getPage();
        values.put(ResponseMovies.KEY_PAGE, responseMovies.getPage());
        values.put(ResponseMovies.KEY_TOTAL_PAGE, responseMovies.getTotal_pages());
        values.put(ResponseMovies.KEY_TYPEMOVIE, typeMovie);

        response = db.insert(ResponseMovies.TABLE, null, values);
        Log.e("RESPRIEMR", Long.toString(response));

        for (Results item : responseMovies.getResults()) {
            ContentValues values2 = new ContentValues();
            values2.put(Results.KEY_DATE, item.getRelease_date());
            values2.put(Results.KEY_ID_MOVIE, item.getId());
            values2.put(Results.KEY_OVERVIEW, item.getOverview());
            values2.put(Results.KEY_TITLE, item.getOriginal_title());
            values2.put(Results.KEY_VOTE, item.getVote_average());
            values2.put(Results.KEY_POSTER, item.getPoster_path());
            values2.put(Results.KEY_PAGE, pageU);
            values2.put(Results.KEY_TYPEMOVIE, typeMovie);
            response = db.insert(Results.TABLE, null, values2);
        }


        db.close();
        return response;
    }

    /**
     * Get all movies type db observable.
     *
     * @param page      the page
     * @param typeMovie the type movie
     * @return the observable
     */
    public Observable<ResponseMovies> getAllMoviesTypeDB(String page, String typeMovie){
        //ResponseMovies responseMoviesList = new ArrayList<ResponseMovies>();
        ResponseMovies responseMovies = new ResponseMovies();
        ArrayList<Results> resultsArrayList = new ArrayList<Results>();

        SQLiteDatabase db = this.dbHelper.getReadableDatabase();

        Cursor cursor1 = db.query(ResponseMovies.TABLE,
                new String[]{ResponseMovies.KEY_TOTAL_PAGE,
                        ResponseMovies.KEY_PAGE},
                ResponseMovies.KEY_PAGE + "=?" + "AND " + ResponseMovies.KEY_TYPEMOVIE + "=?",
                new String[]{page, typeMovie},
                null, null, null, null);

        if (cursor1.moveToFirst()){
            do {
                responseMovies = new ResponseMovies(cursor1.getString(cursor1.getColumnIndex(ResponseMovies.KEY_PAGE)),cursor1.getString(cursor1.getColumnIndex(ResponseMovies.KEY_TOTAL_PAGE)));
            }while (cursor1.moveToNext());
        }


        Cursor cursor = db.query(Results.TABLE,
                new String[]{Results.KEY_DATE,
                        Results.KEY_POSTER,
                        Results.KEY_VOTE,
                        Results.KEY_TITLE,
                        Results.KEY_OVERVIEW,
                        Results.KEY_ID_MOVIE},
                Results.KEY_PAGE + "=?" + "AND " + Results.KEY_TYPEMOVIE + "=?",
                new String[]{page, typeMovie},
                null, null, null, null);

        if (cursor.moveToFirst()){
            do {
                Results results = new Results(cursor.getString(cursor.getColumnIndex(Results.KEY_VOTE)),
                        cursor.getString(cursor.getColumnIndex(Results.KEY_OVERVIEW)),
                        cursor.getString(cursor.getColumnIndex(Results.KEY_DATE)),
                        cursor.getString(cursor.getColumnIndex(Results.KEY_TITLE)),
                        cursor.getString(cursor.getColumnIndex(Results.KEY_POSTER)),
                        cursor.getString(cursor.getColumnIndex(Results.KEY_ID_MOVIE)));
                resultsArrayList.add(results);

            }while (cursor.moveToNext());
        }

        responseMovies.setResults(resultsArrayList);
        cursor.close();
        cursor1.close();
        db.close();

        return Observable.just(responseMovies);
    }
}
