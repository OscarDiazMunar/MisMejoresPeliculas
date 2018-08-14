package com.oscar.mismejorespeliculas;

import android.app.Application;

import com.oscar.mismejorespeliculas.data.db.DBOpenHelper;
import com.oscar.mismejorespeliculas.domain.model.db.DaoMaster;
import com.oscar.mismejorespeliculas.domain.model.db.DaoSession;
import com.oscar.mismejorespeliculas.utils.Constants;

public class App extends Application {
    private DaoSession daoSession;

    @Override
    public void onCreate() {
        super.onCreate();
        /*daoSession =
                new DaoMaster(new DBOpenHelper(this, Constants.DATA_BASE.name).getWritableDb())
                .newSession();*/
    }

    /*public DaoSession getDaoSession() {
        return daoSession;
    }*/
}
