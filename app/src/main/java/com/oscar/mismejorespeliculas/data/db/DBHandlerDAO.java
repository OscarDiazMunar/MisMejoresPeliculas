package com.oscar.mismejorespeliculas.data.db;

import android.content.Context;
import android.util.Log;

import com.oscar.mismejorespeliculas.data.repositories.RepositoryDB;
import com.oscar.mismejorespeliculas.domain.model.db.DaoMaster;
import com.oscar.mismejorespeliculas.domain.model.db.DaoSession;
import com.oscar.mismejorespeliculas.domain.model.db.ResponseDataMovies;
import com.oscar.mismejorespeliculas.domain.model.db.ResponseMoviesDB;
import com.oscar.mismejorespeliculas.domain.model.db.ResponseMoviesDBDao;
import com.oscar.mismejorespeliculas.domain.model.db.ResultsDB;
import com.oscar.mismejorespeliculas.domain.model.db.ResultsDBDao;
import com.oscar.mismejorespeliculas.utils.Constants;

import java.util.List;

import io.reactivex.Observable;

/**
 * The type Db handler dao.
 */
public class DBHandlerDAO implements RepositoryDB {
    private DaoSession daoSession;
    private static DBHandlerDAO instance;

    private DBHandlerDAO(Context context){
        daoSession =
                new DaoMaster(new DBOpenHelper(context, Constants.DATA_BASE.name).getWritableDb())
                        .newSession();
    }

    /**
     * Get instance db handler dao.
     *
     * @param context the context
     * @return the db handler dao
     */
    public static DBHandlerDAO getInstance(Context context){

        if (instance == null){
            instance = new DBHandlerDAO(context);
        }

        return instance;

    }

    @Override
    public Long insertResponseMovies(ResponseMoviesDB responseMoviesDB) {
        return daoSession.getResponseMoviesDBDao().insert(responseMoviesDB);
    }

    @Override
    public Long insertResults(ResultsDB resultsDB) {
        return daoSession.getResultsDBDao().insert(resultsDB);
    }

    @Override
    public Observable<ResponseDataMovies> selectAllMoviesPageA(String page, String typeMovie) {
        ResponseMoviesDBDao responseMoviesDBDao = daoSession.getResponseMoviesDBDao();
        List<ResponseMoviesDB> responseMoviesDB = responseMoviesDBDao.queryBuilder()
                .where(ResponseMoviesDBDao.Properties.Page.eq(page), ResponseMoviesDBDao.Properties.TypeMovie.eq(typeMovie))
                .list();

        Log.e("Lista", responseMoviesDB.toString());

        ResultsDBDao resultsDBDao = daoSession.getResultsDBDao();
        List<ResultsDB> resultsDBList = resultsDBDao.queryBuilder()
                .where(ResultsDBDao.Properties.Page.eq(page), ResultsDBDao.Properties.TypeMovie.eq(typeMovie))
                .list();

        ResponseDataMovies responseDataMovies = new ResponseDataMovies(responseMoviesDB.get(0), resultsDBList);
        return Observable.just(responseDataMovies);
    }


}
