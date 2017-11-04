package com.example.android.cricketscoreboard.database;

import android.support.annotation.Nullable;

import com.example.android.cricketscoreboard.models.Team;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Magic_Buddha on 10/31/2017.
 */

public class SoonToBeDatabase {

    private static SoonToBeDatabase database;

    private static List<Team> teams;

    public static synchronized SoonToBeDatabase getInstance() {
        if (database == null) {
            database = new SoonToBeDatabase();
            teams = new ArrayList<>();
        }

        return database;
    }

    private SoonToBeDatabase() {
        // hiding public constructor
    }

    public static void addTeam(Team team) {
        teams.add(team);
    }

    public static void addTeams(List<Team> teamList) {
        teams = teamList;
    }

    @Nullable
    public static Team getTeam(int position) {
        return position < teams.size() ? teams.get(position) : null;
    }

    public static List<Team> getTeams() {
        return teams;
    }

    public static void removeTeam(Team team) {
        if (teams.contains(team)) {
            teams.remove(team);
        }
    }
}
