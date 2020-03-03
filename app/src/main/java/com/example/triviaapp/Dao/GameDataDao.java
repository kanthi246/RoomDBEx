package com.example.triviaapp.Dao;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.example.triviaapp.Models.GameData;

import java.util.List;

@Dao
public interface GameDataDao {
    @Query("SELECT * FROM gamedata")
    List<GameData> getGameData();

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    long insertAllGameData(GameData gameDataList);

    @Query("SELECT * FROM gamedata ORDER BY id DESC LIMIT 1")
    GameData getGamedatabyid();

    @Query("SELECT COUNT(*) from gamedata")
    int getGamedataCount();
}
