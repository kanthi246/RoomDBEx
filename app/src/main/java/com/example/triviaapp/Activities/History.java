package com.example.triviaapp.Activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.example.triviaapp.Adapter.HistoryRvAdapter;
import com.example.triviaapp.AsyncTasks.GetAllGamedata;
import com.example.triviaapp.Interfaces.FetchAllGameData;
import com.example.triviaapp.Models.GameData;
import com.example.triviaapp.R;
import com.j256.ormlite.android.apptools.OpenHelperManager;
import com.j256.ormlite.dao.RuntimeExceptionDao;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class History extends BaseActivity implements FetchAllGameData {

    @BindView(R.id.rv_history)
    RecyclerView recyclerView;
    @BindView(R.id.textView3)
    TextView textView;

    private HistoryRvAdapter historyRvAdapter;
    //private DbHelper mdbHelper;
    private List<GameData> mgameDataList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history);
        ButterKnife.bind(this);
        //mdbHelper = OpenHelperManager.getHelper(this, DbHelper.class);
    }

    @Override
    protected void onStart() {
        super.onStart();
        /*try {
            //retriving data for history from local db
            RuntimeExceptionDao<GameData, Integer> gameDatadao = mdbHelper.getGameDetails();
            mgameDataList = gameDatadao.queryForAll();
            Log.d("datasize", "" + mgameDataList.size());
        } catch (Exception e) {
            e.printStackTrace();
        }*/
        mgameDataList=new ArrayList<>();
        new GetAllGamedata(this,provideDatabase()).execute();
        //init();
    }

    private void init() {
        if(mgameDataList.size()>0){
            recyclerView.setVisibility(View.VISIBLE);
        }else {
            textView.setVisibility(View.VISIBLE);
        }
        historyRvAdapter = new HistoryRvAdapter(this);
        historyRvAdapter.update(this.mgameDataList);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(historyRvAdapter);
    }

    @Override
    public void OnFetchAllgamedata(List<GameData> gameData) {
        mgameDataList=gameData;
        init();
    }
}
