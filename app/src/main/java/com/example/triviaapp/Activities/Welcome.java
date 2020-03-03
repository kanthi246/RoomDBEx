package com.example.triviaapp.Activities;


import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.triviaapp.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class Welcome extends BaseActivity {

    @BindView(R.id.et_username)
    EditText et_name;
    @BindView(R.id.bt_launch)
    Button Bt_launch;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);
        ButterKnife.bind(this);
    }

    @Override
    protected void onStart() {
        super.onStart();
        init();
    }

    private void init() {
        Bt_launch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (et_name.length() == 0) {
                    Toast.makeText(Welcome.this, R.string.plz_enter_name, Toast.LENGTH_SHORT).show();
                } else {
                    startActivity(new Intent(Welcome.this, QuestionOne.class).
                            putExtra("username", et_name.getText().toString().trim()));
                }
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.menu_item, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {
            case R.id.menu_history:
                startActivity(new Intent(Welcome.this,History.class));
                //Toast.makeText(this, "done", Toast.LENGTH_SHORT).show();
                break;
        }
        return true;
    }
}
