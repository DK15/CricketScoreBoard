package com.example.android.cricketscoreboard.teamselection;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.android.cricketscoreboard.R;
import com.example.android.cricketscoreboard.database.SoonToBeDatabase;
import com.example.android.cricketscoreboard.models.Player;
import com.example.android.cricketscoreboard.models.Team;
import com.example.android.cricketscoreboard.teamcreation.TeamCreationView;

import java.util.ArrayList;
import java.util.List;

public class TeamSelectionView extends AppCompatActivity implements TeamSelectionContract.View, TeamSelectionContract.TeamSelectedCallback {
    // views
    private CardView createNewTeamButtonContainer;
    private TextView chooseTeamView;
    private ListView teamListView;

    // presenter. it will present data and actions to this view/activity
    private TeamSelectionPresenter presenter;

    // adapter
    private TeamAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.team_selection_view_activity);

        // init presenter
        presenter = new TeamSelectionPresenter(this);

        createNewTeamButtonContainer = (CardView) findViewById(R.id.create_new_team_button_container);
        createNewTeamButtonContainer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.createNewTeam();
            }
        });


        teamListView = (ListView) findViewById(R.id.team_selection_list);

        // init adapter
        adapter = new TeamAdapter(this, this, null);

        // attach adapter to the list view
        teamListView.setAdapter(adapter);

        //SoonToBeDatabase.addTeams(generateTeams());

        // temporary
        adapter.setData(new ArrayList<>(presenter.getTeams()));

        chooseTeamView = (TextView) findViewById(R.id.choose_team_title);
        chooseTeamView.setText(adapter.getCount() == 0 ? R.string.choose_team_title_no_teams : R.string.choose_team_title);
    }

    @Override
    protected void onResume() {
        super.onResume();
        // refresh with new list of teams here
        if (adapter.getCount() != presenter.getTeams().size()) {
            adapter.setData(new ArrayList<>(presenter.getTeams()));
        }
    }


    @Override
    public void startTeamCreation() {
        // for now toast
        Intent intent = new Intent(this, TeamCreationView.class);
        startActivity(intent);
    }

    @Override
    public void startGame(Team team) {
        // for now toast
        Toast.makeText(this, "Starting a new game with " + team.getTeamName() , Toast.LENGTH_SHORT).show();
    }

    @Override
    public void removeTeam(Team team) {

    }

    @Override
    public void onTeamSelected(Team team) {
        presenter.selectTeam(team);
    }

    // temporary
    private List<Team> generateTeams() {
        List<Team> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            Team team = new Team();
            team.setTeamName("Team " + Integer.toString(i));
            for (int j = 0; j < 11; j++) {
                Player player = new Player();
                player.setName("Player " + Integer.toString(j));
                team.addPlayer(player);
            }
            list.add(team);
        }

        return list;
    }
}
