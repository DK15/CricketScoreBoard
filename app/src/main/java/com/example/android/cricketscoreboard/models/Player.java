package com.example.android.cricketscoreboard.models;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by Magic_Buddha on 10/31/2017.
 */

public class Player implements Parcelable {
    private String name;

    public Player() {}

    protected Player(Parcel in) {
        name = in.readString();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(name);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<Player> CREATOR = new Creator<Player>() {
        @Override
        public Player createFromParcel(Parcel in) {
            return new Player(in);
        }

        @Override
        public Player[] newArray(int size) {
            return new Player[size];
        }
    };

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
