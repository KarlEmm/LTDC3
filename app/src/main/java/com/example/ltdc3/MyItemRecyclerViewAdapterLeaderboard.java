package com.example.ltdc3;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.facebook.share.model.ShareLinkContent;
import com.facebook.share.widget.ShareDialog;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class MyItemRecyclerViewAdapterLeaderboard extends RecyclerView.Adapter<MyItemRecyclerViewAdapterLeaderboard.ViewHolder> {

    private ArrayList<User> leaderboardData;
    private Context context;
    private Fragment delegate;

    public MyItemRecyclerViewAdapterLeaderboard(ArrayList<User> users, Context context, Fragment delegate) {

        // We sort users by their points
        Collections.sort(users, new Comparator<User>() {
            @Override
            public int compare(User o1, User o2) {
                return o2.getPoints() - o1.getPoints();
            }
        });
        this.delegate = delegate;
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

        holder.linearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                UserChallenge fragChallenge = new UserChallenge();
                delegate.getParentFragment().getParentFragmentManager().beginTransaction().
                    replace(R.id.nav_host_fragment, fragChallenge, null).
                    commit();
            }
        });
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
        private LinearLayout linearLayout;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            rankTV = itemView.findViewById(R.id.idrankTV);
            profilPicIV = itemView.findViewById(R.id.idprofilPicIV);
            nameTV = itemView.findViewById(R.id.nomProfil);
            pointsTV = itemView.findViewById(R.id.idpointsTV);
            linearLayout = itemView.findViewById(R.id.user_challenge_id);
        }

    }
}