package com.example.android.cricketscoreboard.teamselection;

import com.example.android.cricketscoreboard.database.SoonToBeDatabase;
import com.example.android.cricketscoreboard.models.Team;

import java.util.List;

/**
 * Created by Magic_Buddha on 10/31/2017.
 */

public class TeamSelectionPresenter implements TeamSelectionContract.Presenter {

    private TeamSelectionContract.View mView;
    //database

    public TeamSelectionPresenter(TeamSelectionContract.View teamSelectionView) {
        this.mView = teamSelectionView;
    }

    @Override
    public void createNewTeam() {
        mView.startTeamCreation();
    }

    @Override
    public void selectTeam(Team team) {
        mView.startGame(team);
    }

    @Override
    public List<Team> getTeams() {
        return SoonToBeDatabase.getInstance().getTeams();
    }

    @Override
    public void removeTeam(Team team) {
        SoonToBeDatabase.removeTeam(team);
        mView.removeTeam(team);
    }
}
