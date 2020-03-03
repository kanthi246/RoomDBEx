package com.example.triviaapp.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.example.triviaapp.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class QuestionOne extends BaseActivity {

    @BindView(R.id.radioGroup)
    RadioGroup rd_group;
    /*@BindView(R.id.radioButton1)
    RadioGroup rd_one;
    @BindView(R.id.radioButton2)
    RadioGroup rd_two;
    @BindView(R.id.radioButton3)
    RadioGroup rd_three;
    @BindView(R.id.radioButton4)
    RadioGroup rd_four;*/
    RadioButton rd_button;

    @BindView(R.id.bt_next)
    Button Bt_next;

    String name;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question_one);
        ButterKnife.bind(this);
        name=getIntent().getStringExtra("username");
    }

    @Override
    protected void onStart() {
        super.onStart();
        init();
    }

    private void init() {
        Bt_next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (rd_group.getCheckedRadioButtonId() == -1) {
                    Toast.makeText(QuestionOne.this, "Please Select One Option", Toast.LENGTH_SHORT).show();
                } else {
                    int selectedId = rd_group.getCheckedRadioButtonId();
                    rd_button = (RadioButton) findViewById(selectedId);
                    startActivity(new Intent(QuestionOne.this,QuestionTwo.class).
                            putExtra("username",name).putExtra("answerone",rd_button.getText()));

                    //Toast.makeText(QuestionOne.this, rd_button.getText(), Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
