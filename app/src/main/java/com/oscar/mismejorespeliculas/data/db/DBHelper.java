package com.oscar.mismejorespeliculas.data.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.oscar.mismejorespeliculas.utils.Constants;

/**
 * The type Db helper.
 */
public class DBHelper extends SQLiteOpenHelper {
    private static DBHelper instance;

    private DBHelper(Context context) {
        super(context, Constants.DATA_BASE.name, null, Constants.DATA_BASE.version);
    }

    /**
     * Get instance db helper.
     *
     * @param context the context
     * @return the db helper
     */
    public static DBHelper getInstance(Context context){
        if (instance == null){
            instance = new DBHelper(context.getApplicationContext());
        }
        return instance;
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(CRUD.CREATE_TABLE_PAGEMOVIES);
        sqLiteDatabase.execSQL(CRUD.CREATE_TABLE_RESULTMOVIES);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
