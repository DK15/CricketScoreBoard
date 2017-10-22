package com.example.android.cricketscoreboard;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

import com.example.android.cricketscoreboard.customViews.ScoreRowView;

import java.util.ArrayList;
import java.util.List;

public class BatsmanScoreList extends AppCompatActivity {

    private LinearLayout container;

    private List<ScoreRowView> rows;

    private Button button;

    private int currentIndex;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_batsman_score_list);

        container = (LinearLayout) findViewById(R.id.content_container);
        button = (Button) findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                nextPlayer();
            }
        });

        rows = new ArrayList<>();

        currentIndex = 0;

        setupUI();
    }

    private void setupUI() {
        for (int i = 0; i < 11; i++) {
            ScoreRowView view = new ScoreRowView(this);
            view.setPrimaryText("Darshan " + i);
            view.setSecondaryText(String.valueOf(1 + i));
            rows.add(view);
            container.addView(view);

            if (i == 0) {
                view.setBackgroundColor(Color.RED);
            }
        }
    }

    private void nextPlayer() {
        if (currentIndex == rows.size() - 1) {
            rows.get(currentIndex).setBackgroundColor(Color.WHITE);
            currentIndex = 0;
            rows.get(currentIndex).setBackgroundColor(Color.RED);
        } else {
            rows.get(currentIndex).setBackgroundColor(Color.WHITE);
            rows.get(++currentIndex).setBackgroundColor(Color.RED);
        }
    }
}
