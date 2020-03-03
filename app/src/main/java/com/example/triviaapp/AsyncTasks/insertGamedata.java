package com.example.triviaapp.AsyncTasks;

import android.os.AsyncTask;
import android.util.Log;

import androidx.annotation.NonNull;

import com.example.triviaapp.Dao.GameDataDao;
import com.example.triviaapp.Database.TestRoomDB;
import com.example.triviaapp.Models.GameData;


public final class insertGamedata extends AsyncTask<Void, Void, Long> {

	private TestRoomDB testRoomDB;
	private GameData gameData;

	public insertGamedata(@NonNull TestRoomDB testRoomDB, GameData gameData) {
		this.testRoomDB = testRoomDB;
		this.gameData = gameData;
	}

	@Override
	protected Long doInBackground(Void... params) {
		Log.d("gamedata",""+gameData);
		GameDataDao gameDataDao = testRoomDB.provideDataDao();
		/*if (gameDataDao.getGamedataCount() == 0) {
			gameData.setId(1);
		} else {
			GameData gameDataid = gameDataDao.getGamedatabyid();
			gameDataid.setId(gameData.getId() + 1);
		}*/
		return gameDataDao.insertAllGameData(gameData);
	}
}