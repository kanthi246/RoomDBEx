package com.example.triviaapp.Models;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import com.j256.ormlite.field.DatabaseField;

import java.io.Serializable;

@Entity
public class GameData implements Serializable {

    //@DatabaseField
    @ColumnInfo(name = "name")
    private String name;

    //@DatabaseField
    @ColumnInfo(name = "QuestionOne")
    private String QuestionOne;

    //@DatabaseField
    @ColumnInfo(name = "AnswerOne")
    private String AnswerOne;

    //@DatabaseField
    @ColumnInfo(name = "QuestionTwo")
    private String QuestionTwo;

    //@DatabaseField
    @ColumnInfo(name = "AnswerTwo")
    private String AnswerTwo;

    //@DatabaseField
    @ColumnInfo(name = "DateandTime")
    private String DateandTime;

    @PrimaryKey(autoGenerate = true)
    @NonNull
    @ColumnInfo(name = "id")
    private Integer id;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getQuestionOne() {
        return QuestionOne;
    }

    public void setQuestionOne(String questionOne) {
        QuestionOne = questionOne;
    }

    public String getAnswerOne() {
        return AnswerOne;
    }

    public void setAnswerOne(String answerOne) {
        AnswerOne = answerOne;
    }

    public String getQuestionTwo() {
        return QuestionTwo;
    }

    public void setQuestionTwo(String questionTwo) {
        QuestionTwo = questionTwo;
    }

    public String getAnswerTwo() {
        return AnswerTwo;
    }

    public void setAnswerTwo(String answerTwo) {
        AnswerTwo = answerTwo;
    }

    public String getDateandTime() {
        return DateandTime;
    }

    public void setDateandTime(String dateandTime) {
        DateandTime = dateandTime;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
