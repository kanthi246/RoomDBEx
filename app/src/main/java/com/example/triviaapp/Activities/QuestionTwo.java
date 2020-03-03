package com.example.triviaapp.Activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.LinearLayout;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.example.triviaapp.R;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class QuestionTwo extends BaseActivity {

    @BindView(R.id.checkbox_group)
    LinearLayout ll_checkgroup;

    @BindView(R.id.bt_next)
    Button bt_next;

    String name,answerone;
    List<String> answers;
    String answer=null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question_two);
        ButterKnife.bind(this);
        name=getIntent().getStringExtra("username");
        answerone=getIntent().getStringExtra("answerone");
    }

    @Override
    protected void onStart() {
        super.onStart();
        init();
    }

    private void init() {
        String flagcolors="White,Yellow,Orange,Green";
        String[] options = flagcolors.split(",");

        for (String option : options) {
            CheckBox checkBox = new CheckBox(this);
            checkBox.setText(option);
            checkBox.setAllCaps(true);
            ll_checkgroup.addView(checkBox);
            checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                    answers = getCheckedAnswers(ll_checkgroup);
                }
            });
        }

        bt_next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (answers!=null && answers.size() == 1) {
                    Toast.makeText(QuestionTwo.this, "Please Select 1 or More", Toast.LENGTH_SHORT).show();
                    return;
                }else {
                    String models = getcheckeddata(answers);
                    startActivity(new Intent(QuestionTwo.this,Summary.class).
                            putExtra("username",name).putExtra("answerone",answerone).
                            putExtra("answertwo", models));
                }
            }
        });

    }

    private List<String> getCheckedAnswers(LinearLayout ll_checkgroup) {
        List<String> answers = new ArrayList<>();
        CheckBox checkBox;
        for (int i = 0; i < ll_checkgroup.getChildCount(); i++) {
            if (ll_checkgroup.getChildAt(i) instanceof CheckBox) {
                checkBox = (CheckBox) ll_checkgroup.getChildAt(i);
                if (checkBox.isChecked()) {
                    //answer=answer+","+checkBox.getText().toString();
                    answers.add(checkBox.getText().toString());
                }
            }
        }
        return answers;
    }

    public static String getcheckeddata(List<String> array) {
        String result = "";

        if (array.size() > 0) {
            StringBuilder sb = new StringBuilder();

            for (String s : array) {
                sb.append(s).append(",");
            }

            result = sb.deleteCharAt(sb.length() - 1).toString();
        }
        return result;
    }
}
