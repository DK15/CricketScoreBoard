package com.example.android.cricketscoreboard.models;

import android.os.Parcel;
import android.os.Parcelable;
import android.support.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Magic_Buddha on 10/31/2017.
 */

public class Team implements Parcelable {

    private String teamName;

    private List<Player> team;

    public Team() {
        team = new ArrayList<>(11);
        teamName = "default name son, y u no choose name?";
    }

    protected Team(Parcel in) {
        teamName = in.readString();
        team = in.createTypedArrayList(Player.CREATOR);
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(teamName);
        dest.writeTypedList(team);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<Team> CREATOR = new Creator<Team>() {
        @Override
        public Team createFromParcel(Parcel in) {
            return new Team(in);
        }

        @Override
        public Team[] newArray(int size) {
            return new Team[size];
        }
    };

    public void addPlayer(Player player) {
        if (player != null) {
            team.add(player);
        }
    }

    public void removePlayer(Player player) {
        if (player != null) {
            team.remove(player);
        }
    }

    public int getTeamSize() {
        return team.size();
    }

    @Nullable
    public Player getPlayerAt(int position) {
        return position < team.size() ? team.get(position) : null;
    }

    public String getTeamName() {
        return teamName;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

    public List<Player> getPlayers() {
        return team;
    }
}
