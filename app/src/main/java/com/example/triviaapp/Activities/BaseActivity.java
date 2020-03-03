package com.example.triviaapp.Activities;

import androidx.appcompat.app.AppCompatActivity;

import com.example.triviaapp.Database.RoomBuilder;
import com.example.triviaapp.Database.TestRoomDB;

public class BaseActivity extends AppCompatActivity {
    public TestRoomDB provideDatabase(){
        return RoomBuilder.provideRoomDB(this);
    }
}
