package com.example.triviaapp.AsyncTasks;

import android.os.AsyncTask;

import androidx.annotation.NonNull;

import com.example.triviaapp.Dao.GameDataDao;
import com.example.triviaapp.Database.TestRoomDB;
import com.example.triviaapp.Interfaces.FetchAllGameData;
import com.example.triviaapp.Models.GameData;

import java.util.List;

public class GetAllGamedata extends AsyncTask<Void,Void, List<GameData>> {

    private TestRoomDB testRoomDB;
    private FetchAllGameData fetchAllGameData;

    public GetAllGamedata(@NonNull FetchAllGameData fetchAllGameData,@NonNull TestRoomDB testRoomDB){
        this.fetchAllGameData=fetchAllGameData;
        this.testRoomDB=testRoomDB;
    }

    @Override
    protected List<GameData> doInBackground(Void... voids) {
        GameDataDao gameDataDao = testRoomDB.provideDataDao();
        return gameDataDao.getGameData();
    }

    @Override
    protected void onPostExecute(List<GameData> gameData) {
        if(fetchAllGameData!=null){
            fetchAllGameData.OnFetchAllgamedata(gameData);
        }

    }
}
