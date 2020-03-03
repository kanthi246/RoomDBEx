package com.example.triviaapp.Database;

import android.content.Context;

import androidx.room.Room;

public class RoomBuilder {


    //Database name
    private static final String DATABASE_NAME = "Trivia.db";

    public static TestRoomDB testRoomDB;

    public static TestRoomDB provideRoomDB(Context context){
        if(testRoomDB == null)
            return testRoomDB = Room.
                    databaseBuilder(context
                            , TestRoomDB.class
                            , DATABASE_NAME).build();
        else
            return testRoomDB;
    }
}
