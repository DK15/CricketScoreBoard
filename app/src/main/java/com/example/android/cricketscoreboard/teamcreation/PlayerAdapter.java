package com.example.android.cricketscoreboard.teamcreation;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.android.cricketscoreboard.R;
import com.example.android.cricketscoreboard.models.Player;

import java.util.ArrayList;

/**
 * Created by Magic_Buddha on 10/31/2017.
 */

public class PlayerAdapter extends ArrayAdapter<Player> {

    private ArrayList<Player> playerList;

    // required constructor to make this work. Google is a blessing
    public PlayerAdapter(Context context, ArrayList<Player> players) {
        super(context, 0, players);
        this.playerList = players;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        final Player player = playerList.get(position);
        // if no cache, inflate
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.item_player, parent, false);
        }

        TextView teamNameView = (TextView) convertView.findViewById(R.id.player_name);
        teamNameView.setText(player.getName());

        return convertView;
    }


    public void setData(ArrayList<Player> players) {

        this.playerList = players;
        notifyDataSetChanged();
    }

    @Override
    public int getCount() {
        return playerList == null ? 0 : playerList.size();
    }
}
