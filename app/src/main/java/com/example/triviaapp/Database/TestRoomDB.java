package com.example.triviaapp.Database;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import com.example.triviaapp.Dao.GameDataDao;
import com.example.triviaapp.Models.GameData;

@Database(entities = {GameData.class},version = 1,exportSchema = false)
public abstract class TestRoomDB extends RoomDatabase {
    public abstract GameDataDao provideDataDao();
}
