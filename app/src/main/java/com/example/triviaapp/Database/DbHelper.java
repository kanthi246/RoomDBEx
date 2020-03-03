package com.example.triviaapp.Database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.example.triviaapp.Models.GameData;
import com.example.triviaapp.R;
import com.j256.ormlite.android.apptools.OrmLiteSqliteOpenHelper;
import com.j256.ormlite.dao.RuntimeExceptionDao;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.table.TableUtils;

import java.sql.SQLException;

public class DbHelper extends OrmLiteSqliteOpenHelper {

    //Database name
    private static final String DATABASE_NAME = "Trivia.db";
    //Version of the database. Changing the version will call {@Link OrmLite.onUpgrade}
    private static final int DATABASE_VERSION = 1;

    public DbHelper(Context context) {
        super(context,DATABASE_NAME,null,DATABASE_VERSION, R.raw.ormlite_config);
    }


    @Override
    public void onCreate(SQLiteDatabase database, ConnectionSource connectionSource) {

        try {
            TableUtils.createTable(connectionSource, GameData.class);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onUpgrade(SQLiteDatabase database, ConnectionSource connectionSource, int oldVersion, int newVersion) {

    }

    private RuntimeExceptionDao<GameData, Integer> gameData;

    public RuntimeExceptionDao<GameData, Integer> getGameDetails() throws SQLException {
        if (gameData == null) {
            gameData = getRuntimeExceptionDao(GameData.class);
        }
        return gameData;
    }
}
