package com.example.android.cricketscoreboard;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
   // int runScored1;
    TextView firstGuyHighlighter;
    TextView secondGuyHighlighter;

    TextView firstGuyScore;
    TextView secondGuyScore;

    TextView firstPlayer;
    TextView secondPlayer;
    TextView teamName;



    Button oneRun;
    Button twoRun;
    Button threeRun;
    Button fourRun;
    Button sixRun;
    Button out;
    Button reset;
    ListView batList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        firstGuyHighlighter = (TextView) findViewById(R.id.batsmen1_high);
        secondGuyHighlighter = (TextView) findViewById(R.id.batsmen2_high);

        firstGuyScore = (TextView) findViewById(R.id.bat1_init_txt);
        secondGuyScore = (TextView) findViewById(R.id.bat2_init_txt);

        firstPlayer = (TextView) findViewById(R.id.batsmen1_txt_view);
        secondPlayer = (TextView) findViewById(R.id.batsmen2_txt_view);
        teamName = (TextView) findViewById(R.id.teamNameTxtView);

        Intent i = getIntent();
        String displayFirstGuy = i.getStringExtra("batsman1");
        firstPlayer.setText(displayFirstGuy);

        String displaySecondGuy = i.getStringExtra("batsman2");
        secondPlayer.setText(displaySecondGuy);

        String displayTeamName = i.getStringExtra("teamname");
        teamName.setText(displayTeamName);





      //  String displayFirstGuy = firstGuyName.getText().toString();
      //  firstPlayer.setText(displayFirstGuy);

      //  String displaySecondGuy = secondGuyName.getText().toString();
      //  secondPlayer.setText(displaySecondGuy);

//        batList = (ListView) findViewById(R.id.batsmen_list_view);
//
//        String [] values = new String[] {"Batsman1","Batsman2","Batsman3","Batsman4","Batsman5","Batsman6","Batsman7","Batsman8",
//            "Batsman9","Batsman10","Batsman11"};
//        final ArrayList<String> list = new ArrayList<>();
//
//        for (int i = 0; i< values.length; i++) {
//            list.add(values[i]);
//        }
//
//        ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, values);
//        batList.setAdapter(adapter);

        oneRun = (Button) findViewById(R.id.one_run_btn);
        twoRun = (Button) findViewById(R.id.two_run_btn);
        threeRun = (Button) findViewById(R.id.three_run_btn);
        fourRun = (Button) findViewById(R.id.four_run_btn);
        sixRun = (Button) findViewById(R.id.six_run_btn);
        reset = (Button) findViewById(R.id.reset_btn);
        reset.setEnabled(false);
    }



    public void oneRunScored(View v) {
        if (firstGuyHighlighter.getVisibility() == View.VISIBLE) {
            //first
         //   firstPlayer.setTypeface(Typeface.DEFAULT_BOLD);
            int score = Integer.parseInt(firstGuyScore.getText().toString());
            score++;
            firstGuyScore.setText(Integer.toString(score));

            firstGuyHighlighter.setVisibility(View.INVISIBLE);
            secondGuyHighlighter.setVisibility(View.VISIBLE);
            secondPlayer.setTypeface(Typeface.DEFAULT_BOLD);
            firstPlayer.setTypeface(Typeface.DEFAULT);

        } else if (secondGuyHighlighter.getVisibility() == View.VISIBLE) {
            //second
            int score = Integer.parseInt(secondGuyScore.getText().toString());
            score++;
            secondGuyScore.setText(Integer.toString(score));

            secondGuyHighlighter.setVisibility(View.INVISIBLE);
            firstGuyHighlighter.setVisibility(View.VISIBLE);
            firstPlayer.setTypeface(Typeface.DEFAULT_BOLD);
            secondPlayer.setTypeface(Typeface.DEFAULT);
        }

//        runScored1 = runScored1 + 1;
//
//        firstGuyScore.setText(String.valueOf(runScored1));
//        firstGuyHighlighter.setVisibility(View.INVISIBLE);
//        secondGuyHighlighter.setVisibility(View.VISIBLE);
//
//        int test = firstGuyHighlighter.getVisibility();
//        int test1 = secondGuyHighlighter.getVisibility();

        /*        if (test == View.VISIBLE)
                {
                 //   oneRun_txt.setText(String.valueOf(runScored1));
                }
                else if (test1 == View.VISIBLE)
                {
                 //   runScored1 = runScored1 + 1;

                    oneRun_txt1.setText(String.valueOf(runScored1));

                  //  TextView oneRun_high_txt2 = (TextView) findViewById(R.id.batsmen2_high);
                    oneRun_high_txt1.setVisibility(View.INVISIBLE);

                 //   TextView oneRun_high_txt3 = (TextView) findViewById(R.id.batsmen1_high);
                    oneRun_high_txt.setVisibility(View.VISIBLE);
                }

        } */
    }

    public void twoRunScored(View v) {

        if (firstGuyHighlighter.getVisibility() == View.VISIBLE) {
            //first
            int score = Integer.parseInt(firstGuyScore.getText().toString());
            score=score+2;
            firstGuyScore.setText(Integer.toString(score));

            firstGuyHighlighter.setVisibility(View.VISIBLE);
            secondGuyHighlighter.setVisibility(View.INVISIBLE);
            firstPlayer.setTypeface(Typeface.DEFAULT_BOLD);
        } else if (secondGuyHighlighter.getVisibility() == View.VISIBLE) {
            //second
            int score = Integer.parseInt(secondGuyScore.getText().toString());
            score=score+2;
            secondGuyScore.setText(Integer.toString(score));

            secondGuyHighlighter.setVisibility(View.VISIBLE);
            firstGuyHighlighter.setVisibility(View.INVISIBLE);
            secondPlayer.setTypeface(Typeface.DEFAULT_BOLD);
        }

    }

    public void threeRunScored(View v) {

        if (firstGuyHighlighter.getVisibility() == View.VISIBLE) {
            //first
            int score = Integer.parseInt(firstGuyScore.getText().toString());
            score=score+3;
            firstGuyScore.setText(Integer.toString(score));

            firstGuyHighlighter.setVisibility(View.INVISIBLE);
            secondGuyHighlighter.setVisibility(View.VISIBLE);
            secondPlayer.setTypeface(Typeface.DEFAULT_BOLD);
            firstPlayer.setTypeface(Typeface.DEFAULT);
        } else if (secondGuyHighlighter.getVisibility() == View.VISIBLE) {
            //second
            int score = Integer.parseInt(secondGuyScore.getText().toString());
            score=score+3;
            secondGuyScore.setText(Integer.toString(score));

            secondGuyHighlighter.setVisibility(View.INVISIBLE);
            firstGuyHighlighter.setVisibility(View.VISIBLE);
            firstPlayer.setTypeface(Typeface.DEFAULT_BOLD);
            secondPlayer.setTypeface(Typeface.DEFAULT);
        }

    }

    public void fourRunScored(View v) {

        if (firstGuyHighlighter.getVisibility() == View.VISIBLE) {
            //first
            int score = Integer.parseInt(firstGuyScore.getText().toString());
            score=score+4;
            firstGuyScore.setText(Integer.toString(score));

            firstGuyHighlighter.setVisibility(View.VISIBLE);
            secondGuyHighlighter.setVisibility(View.INVISIBLE);
            firstPlayer.setTypeface(Typeface.DEFAULT_BOLD);
        } else if (secondGuyHighlighter.getVisibility() == View.VISIBLE) {
            //second
            int score = Integer.parseInt(secondGuyScore.getText().toString());
            score=score+4;
            secondGuyScore.setText(Integer.toString(score));

            secondGuyHighlighter.setVisibility(View.VISIBLE);
            firstGuyHighlighter.setVisibility(View.INVISIBLE);
            secondPlayer.setTypeface(Typeface.DEFAULT_BOLD);
        }

    }

    public void sixRunScored(View v) {

        if (firstGuyHighlighter.getVisibility() == View.VISIBLE) {
            //first
            int score = Integer.parseInt(firstGuyScore.getText().toString());
            score=score+6;
            firstGuyScore.setText(Integer.toString(score));

            firstGuyHighlighter.setVisibility(View.VISIBLE);
            secondGuyHighlighter.setVisibility(View.INVISIBLE);
            firstPlayer.setTypeface(Typeface.DEFAULT_BOLD);
        } else if (secondGuyHighlighter.getVisibility() == View.VISIBLE) {
            //second
            int score = Integer.parseInt(secondGuyScore.getText().toString());
            score=score+6;
            secondGuyScore.setText(Integer.toString(score));

            secondGuyHighlighter.setVisibility(View.VISIBLE);
            firstGuyHighlighter.setVisibility(View.INVISIBLE);
            secondPlayer.setTypeface(Typeface.DEFAULT_BOLD);
        }

    }

    public void out(View v) {

        if (firstGuyHighlighter.getVisibility() == View.VISIBLE) {
            firstPlayer.setTextColor(Color.RED);
            firstGuyScore.setTextColor(Color.RED);
            oneRun.setEnabled(false);
            twoRun.setEnabled(false);
            threeRun.setEnabled(false);
            fourRun.setEnabled(false);
            sixRun.setEnabled(false);
            reset.setEnabled(true);

        }
        else if(secondGuyHighlighter.getVisibility() == View.VISIBLE) {
            secondPlayer.setTextColor(Color.RED);
            secondGuyScore.setTextColor(Color.RED);
            oneRun.setEnabled(false);
            twoRun.setEnabled(false);
            threeRun.setEnabled(false);
            fourRun.setEnabled(false);
            sixRun.setEnabled(false);
            reset.setEnabled(true);
        }
    }

    public void reset(View v) {
        firstGuyScore.setText("0");
        secondGuyScore.setText("0");
        firstPlayer.setTextColor(Color.BLACK);
        firstGuyScore.setTextColor(Color.BLACK);

        secondPlayer.setTextColor(Color.BLACK);
        secondGuyScore.setTextColor(Color.BLACK);

        oneRun.setEnabled(true);
        twoRun.setEnabled(true);
        threeRun.setEnabled(true);
        fourRun.setEnabled(true);
        sixRun.setEnabled(true);

    }

    public void next(View v) {
        int getCurrentColor = firstPlayer.getCurrentTextColor();
        if(getCurrentColor == 1){

        }
    }

}
