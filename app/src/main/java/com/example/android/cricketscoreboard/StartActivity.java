package com.example.android.cricketscoreboard;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;

public class StartActivity extends AppCompatActivity {
    EditText firstGuyName;
    EditText secondGuyName;
    EditText teamName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        teamName = (EditText) findViewById(R.id.enterTeamEditView);
        firstGuyName = (EditText) findViewById(R.id.bat1EditView);
        secondGuyName = (EditText) findViewById(R.id.bat2EditView);
    }

    public void startGame(View v){
        Intent intent = new Intent(this, MainActivity.class);
        intent.putExtra("teamname",teamName.getText().toString());
        intent.putExtra("batsman1",firstGuyName.getText().toString());
        intent.putExtra("batsman2", secondGuyName.getText().toString());
        startActivity(intent);
    }

}
