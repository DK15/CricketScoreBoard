package com.example.android.cricketscoreboard.teamcreation;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import com.example.android.cricketscoreboard.R;
import com.example.android.cricketscoreboard.models.Player;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Magic_Buddha on 11/1/2017.
 */

public class TeamCreationView extends AppCompatActivity implements TeamCreationContract.View {
    // views
    private EditText newTeamName;
    private EditText newPlayerView;
    private Button teamNameButton;
    private Button newPlayerButton;
    private ListView playerListView;
    private TextView createTeamButton;

    // presenter
    private TeamCreationPresenter presenter;

    // adapter for list view
    private PlayerAdapter adapter;

    @SuppressLint("RestrictedApi")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.team_creation_view_activity);

        // allow up button
        getSupportActionBar().setDefaultDisplayHomeAsUpEnabled(true);


        // init presenter
        presenter = new TeamCreationPresenter(this);

        // bind views... should use butterknife
        newTeamName = (EditText) findViewById(R.id.team_name_input);
        teamNameButton = (Button) findViewById(R.id.set_team_name_button);

        newPlayerView = (EditText) findViewById(R.id.player_name_input);
        newPlayerButton = (Button) findViewById(R.id.add_player_button);

        playerListView = (ListView) findViewById(R.id.team_creation_player_list_view);

        createTeamButton = (TextView) findViewById(R.id.create_new_team_button);

        // add on-click listeners
        createTeamButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.createTeam();
            }
        });

        teamNameButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String teamName = newTeamName.getText().toString();
                presenter.setTeamName(teamName);
                newPlayerView.requestFocus();
            }
        });

        newPlayerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String playerName = newPlayerView.getText().toString();
                if (!TextUtils.isEmpty(playerName)) {
                    Player player = new Player();
                    player.setName(playerName);
                    presenter.addPlayer(player);
                    clearPlayerInput();

                }
            }
        });

        // init adapter
        adapter = new PlayerAdapter(this, null);

        playerListView.setAdapter(adapter);
    }

    @Override
    public void setTeamName(String teamName) {

    }

    @Override
    public void updatePlayerList(List<Player> players) {
        adapter.setData(new ArrayList<Player>(players));
    }

    public void clearPlayerInput() {
        newPlayerView.setText("");
    }

    @Override
    public void done() {
        finish();
    }
}
