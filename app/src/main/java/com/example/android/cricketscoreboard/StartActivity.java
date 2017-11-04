package com.example.android.cricketscoreboard;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.android.cricketscoreboard.teamselection.TeamSelectionView;

public class StartActivity extends AppCompatActivity {
    EditText firstGuyName;
    EditText secondGuyName;
    EditText teamName;

    private Button startDemoButton;
    private Button updatedVersionButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        teamName = (EditText) findViewById(R.id.enterTeamEditView);
        firstGuyName = (EditText) findViewById(R.id.bat1EditView);
        secondGuyName = (EditText) findViewById(R.id.bat2EditView);

        startDemoButton = (Button) findViewById(R.id.start_demo_button);
        updatedVersionButton = (Button) findViewById(R.id.start_updated_version_button);

        View.OnClickListener updatedClicklistener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(StartActivity.this, TeamSelectionView.class);
                startActivity(intent);
                Toast.makeText(StartActivity.this, "Starting updated version...", Toast.LENGTH_SHORT).show();
            }
        };

        updatedVersionButton.setOnClickListener(updatedClicklistener);

        View.OnClickListener clickListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(StartActivity.this, BatsmanScoreList.class);
                startActivity(intent);
                Toast.makeText(StartActivity.this, "HELLO FROM CLICK LISTENER", Toast.LENGTH_SHORT).show();
            }
        };

        startDemoButton.setOnClickListener(clickListener);
    }

    public void startGame(View v){
        Intent intent = new Intent(this, MainActivity.class);
        intent.putExtra("teamname",teamName.getText().toString());
        intent.putExtra("batsman1",firstGuyName.getText().toString());
        intent.putExtra("batsman2", secondGuyName.getText().toString());
        startActivity(intent);
    }

}
