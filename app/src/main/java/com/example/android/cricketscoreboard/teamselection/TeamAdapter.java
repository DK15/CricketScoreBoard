package com.example.android.cricketscoreboard.teamselection;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.android.cricketscoreboard.R;
import com.example.android.cricketscoreboard.models.Team;

import java.util.ArrayList;

/**
 * Created by Magic_Buddha on 10/31/2017.
 */

public class TeamAdapter extends ArrayAdapter<Team> {

    TeamSelectionContract.TeamSelectedCallback callback;

    private ArrayList<Team> teamList;

    // required constructor to make this work. Google is a blessing
    public TeamAdapter(@NonNull TeamSelectionContract.TeamSelectedCallback callback, Context context, ArrayList<Team> teams) {
        super(context, 0, teams);
        this.callback = callback;
        this.teamList = teams;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        final Team team = teamList.get(position);
        // if no cache, inflate
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.item_team, parent, false);
        }

        TextView teamNameView = (TextView) convertView.findViewById(R.id.team_name);
        teamNameView.setText(team.getTeamName());

        convertView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                callback.onTeamSelected(team);
            }
        });

        return convertView;
    }


    public void setData(ArrayList<Team> teams) {

        this.teamList = teams;
        notifyDataSetChanged();
    }

    @Override
    public int getCount() {
        return teamList == null ? 0 : teamList.size();
    }
}
