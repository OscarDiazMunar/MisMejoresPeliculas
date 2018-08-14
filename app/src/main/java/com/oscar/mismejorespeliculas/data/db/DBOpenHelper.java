package com.oscar.mismejorespeliculas.data.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.oscar.mismejorespeliculas.domain.model.db.DaoMaster;

import org.greenrobot.greendao.database.Database;

/**
 * The type Db open helper.
 */
public class DBOpenHelper extends DaoMaster.OpenHelper {
    /**
     * Instantiates a new Db open helper.
     *
     * @param context the context
     * @param name    the name
     */
    public DBOpenHelper(Context context, String name) {
        super(context, name);
    }

    /**
     * Instantiates a new Db open helper.
     *
     * @param context the context
     * @param name    the name
     * @param factory the factory
     */
    public DBOpenHelper(Context context, String name, SQLiteDatabase.CursorFactory factory) {
        super(context, name, factory);
    }

    @Override
    public void onUpgrade(Database db, int oldVersion, int newVersion) {
        super.onUpgrade(db, oldVersion, newVersion);
    }
}
