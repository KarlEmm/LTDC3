package com.example.ltdc3;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class RecyclerViewAdapterChallengeUser extends RecyclerView.Adapter<RecyclerViewAdapterChallengeUser.ViewHolder> {

    private ArrayList<Challenge> challengeList;
    private Context context;

    public RecyclerViewAdapterChallengeUser(ArrayList<Challenge> challenge, Context context) {
        challengeList = challenge;
        this.context = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
        .inflate(R.layout.fragment_challenge, parent, false);
        return new RecyclerViewAdapterChallengeUser.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerViewAdapterChallengeUser.ViewHolder holder, int position) {
        Challenge itemData = challengeList.get(position);
        holder.challengeDate.setText(itemData.getCompletionDate());
        holder.challengePoints.setText(String.valueOf(itemData.getPoints()));
        holder.challengeName.setText(itemData.getChallengeName());
    }

    @Override
    public int getItemCount() {
        return challengeList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView challengeName;
        TextView challengePoints;
        TextView challengeDate;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            challengeName = itemView.findViewById(R.id.challenge_name_id);
            challengePoints = itemView.findViewById(R.id.challenge_points_id);
            challengeDate = itemView.findViewById(R.id.challenge_completion_id);
        }
    }
}
