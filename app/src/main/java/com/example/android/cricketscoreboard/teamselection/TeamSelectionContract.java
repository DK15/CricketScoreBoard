package com.example.android.cricketscoreboard.teamselection;

import com.example.android.cricketscoreboard.models.Team;

import java.util.List;

/**
 * Created by Magic_Buddha on 10/31/2017.
 */

public interface TeamSelectionContract {
    interface View {
        void startTeamCreation();
        void startGame(Team team);
        void removeTeam(Team team);
    }

    interface Presenter {
        void createNewTeam();
        void selectTeam(Team team);
        List<Team> getTeams();
        void removeTeam(Team team);
    }

    interface TeamSelectedCallback {

        void onTeamSelected(Team team);
    }
}
