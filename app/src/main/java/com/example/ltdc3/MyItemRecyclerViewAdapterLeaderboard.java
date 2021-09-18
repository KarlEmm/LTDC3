package com.example.ltdc3;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;


import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class MyItemRecyclerViewAdapterLeaderboard extends RecyclerView.Adapter<MyItemRecyclerViewAdapterLeaderboard.ViewHolder> {

    private ArrayList<User> leaderboardData;
    private Context context;

    public MyItemRecyclerViewAdapterLeaderboard(ArrayList<User> users, Context context) {

        // We sort users by their points
        Collections.sort(users, new Comparator<User>() {
            @Override
            public int compare(User o1, User o2) {
                return o2.getPoints() - o1.getPoints();
            }
        });

        leaderboardData = users;
        this.context = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.fragment_leaderboard, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final MyItemRecyclerViewAdapterLeaderboard.ViewHolder holder, int position) {
        User user = leaderboardData.get(position);
        holder.rankTV.setText(String.valueOf(position + 1));
        holder.profilPicIV.setImageResource(user.getProfilePic());
        holder.nameTV.setText(user.getCompleteName());
        holder.pointsTV.setText(String.valueOf((user.getPoints())) + " points");
    }

    @Override
    public int getItemCount() {
        return leaderboardData.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView rankTV;
        private ImageView profilPicIV;
        private TextView nameTV;
        private TextView pointsTV;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            rankTV = itemView.findViewById(R.id.idrankTV);
            profilPicIV = itemView.findViewById(R.id.idprofilPicIV);
            nameTV = itemView.findViewById(R.id.idnameTV);
            pointsTV = itemView.findViewById(R.id.idpointsTV);

        }

    }
}