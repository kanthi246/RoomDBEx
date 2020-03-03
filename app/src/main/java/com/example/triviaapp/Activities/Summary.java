package com.example.triviaapp.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.triviaapp.AsyncTasks.insertGamedata;
import com.example.triviaapp.Models.GameData;
import com.example.triviaapp.R;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

import butterknife.BindView;
import butterknife.ButterKnife;

public class Summary extends BaseActivity {

    @BindView(R.id.tv_name)
    TextView tv_name;
    @BindView(R.id.txt_answerone)
    TextView tv_answerone;
    @BindView(R.id.txt_answertwo)
    TextView tv_answertwo;
    @BindView(R.id.bt_finish)
    Button bt_finish;

    String name,answerone,answertwo;
    //private DbHelper mdbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_summary);
        ButterKnife.bind(this);
        //mdbHelper = OpenHelperManager.getHelper(this, DbHelper.class);

        name=getIntent().getStringExtra("username");
        answerone=getIntent().getStringExtra("answerone");
        answertwo=getIntent().getStringExtra("answertwo");
    }

    @Override
    protected void onStart() {
        super.onStart();
        init();
    }

    private void init() {
        tv_name.setText("Hello "+name);
        tv_answerone.setText("Answer :"+answerone);
        tv_answertwo.setText("Answer :"+answertwo);
        bt_finish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                GameData details=new GameData();
                details.setName(name);
                details.setQuestionOne(getResources().getString(R.string.questionone));
                details.setAnswerOne(answerone);
                details.setQuestionTwo(getResources().getString(R.string.question_to));
                details.setAnswerTwo(answertwo);
                details.setDateandTime(getDateTime());
                //details.setId(1);
                new insertGamedata(provideDatabase(),details).execute();
                startActivity(new Intent(Summary.this,Welcome.class).
                        setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK));
                /*try {
                    //saving data in local db
                    RuntimeExceptionDao<GameData,Integer> gameDataDao = mdbHelper.getGameDetails();
                    gameDataDao.create(details);
                    Toast.makeText(Summary.this, "Saved", Toast.LENGTH_SHORT).show();
                    //finish();
                    startActivity(new Intent(Summary.this,Welcome.class).
                            setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK));
                } catch (SQLException e) {
                    e.printStackTrace();
                }*/
            }
        });
    }

    public static String getDateTime() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.sss'Z'", Locale.US);
        dateFormat.setTimeZone(TimeZone.getTimeZone("GMT"));
        Date date = new Date();
        return dateFormat.format(date);
    }
}
