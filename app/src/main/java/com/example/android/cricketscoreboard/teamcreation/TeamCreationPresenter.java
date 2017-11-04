package com.example.android.cricketscoreboard.teamcreation;

import com.example.android.cricketscoreboard.database.SoonToBeDatabase;
import com.example.android.cricketscoreboard.models.Player;
import com.example.android.cricketscoreboard.models.Team;

/**
 * Created by Magic_Buddha on 11/1/2017.
 */

public class TeamCreationPresenter implements TeamCreationContract.Presenter {

    private TeamCreationContract.View mView;
    private Team team;

    public TeamCreationPresenter(TeamCreationContract.View view) {
        this.mView = view;
        team = new Team();
    }

    @Override
    public void setTeamName(String teamName) {
        team.setTeamName(teamName);
        mView.setTeamName(teamName);
    }

    @Override
    public void addPlayer(Player player) {
        team.addPlayer(player);
        mView.updatePlayerList(team.getPlayers());
    }

    @Override
    public void createTeam() {
        SoonToBeDatabase.addTeam(team);
        mView.done();
    }
}
