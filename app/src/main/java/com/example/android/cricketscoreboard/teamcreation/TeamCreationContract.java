package com.example.android.cricketscoreboard.teamcreation;

import com.example.android.cricketscoreboard.models.Player;

import java.util.List;

/**
 * Created by Magic_Buddha on 10/31/2017.
 */

public interface TeamCreationContract {

    interface View {
        void setTeamName(String teamName);
        void updatePlayerList(List<Player> players);
        void done();
    }

    interface Presenter {
        void setTeamName(String teamName);
        void addPlayer(Player player);
        void createTeam();
    }
}
