package com.example.ltdc3;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import de.hdodenhof.circleimageview.CircleImageView;

public class MyItemRecyclerViewAdapterFeed extends RecyclerView.Adapter<MyItemRecyclerViewAdapterFeed.ViewHolder> {

    private ArrayList<FeedData> feedDataArrayList;
    private Context context;

    public MyItemRecyclerViewAdapterFeed(ArrayList<FeedData> items, Context context) {
        feedDataArrayList = items;
        this.context = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.fragment_home_page, parent, false);
        return new MyItemRecyclerViewAdapterFeed.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyItemRecyclerViewAdapterFeed.ViewHolder holder, int position) {
        FeedData itemData = feedDataArrayList.get(position);
        holder.authorTV.setText(context.getString(R.string.username, itemData.getUser().getFirstname(), itemData.getUser().getName()));
        holder.postIV.setImageResource(itemData.getImagePost());
        holder.likeTV.setText("" + itemData.getLikesCount() + " likes");
        int commentsSz = itemData.getComments().size();
        if (commentsSz == 0) {
            holder.commentTV.setVisibility(View.GONE);
        } else if (commentsSz == 1) {
            holder.commentTV.setText(context.getString(R.string.comments, commentsSz, "comment"));
        } else {
            holder.commentTV.setText(context.getString(R.string.comments, commentsSz, "comments"));
        }
        holder.commentTV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle args = new Bundle();
                args.putInt("feedID", itemData.getId());
                Comments fragComments = new Comments();
                fragComments.setArguments(args);
                FragmentManager fm = ((AppCompatActivity) context).getSupportFragmentManager();
                FragmentTransaction ft = fm.beginTransaction();
                ft.remove(fm.findFragmentById(R.id.nav_host_fragment));
                ((AppCompatActivity) context).getSupportFragmentManager().beginTransaction().
                        replace(R.id.nav_host_fragment, fragComments, null).commit();
            }
        });
        holder.authorIV.setImageResource(itemData.getUser().getProfilePic());
    }

    @Override
    public int getItemCount() {
        return feedDataArrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        CircleImageView authorIV;
        private TextView authorTV;
        private ImageView postIV;
        private TextView likeTV;
        private TextView commentTV;

        public ViewHolder(@NonNull View itemView) {
                super(itemView);
                authorIV = itemView.findViewById(R.id.idCVAuthorComment);
                authorTV = itemView.findViewById(R.id.idTVAuthorNameComment);
                postIV = itemView.findViewById(R.id.idIVPost);
                likeTV = itemView.findViewById(R.id.idTVLikes);
                commentTV = itemView.findViewById(R.id.idTVComments);
        }
    }
}