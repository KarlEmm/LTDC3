package com.example.ltdc3;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import de.hdodenhof.circleimageview.CircleImageView;

public class MyItemRecyclerViewAdapterFeed extends RecyclerView.Adapter<MyItemRecyclerViewAdapterFeed.ViewHolder> {

    private ArrayList<FeedData> feedDataArrayList;
    private Context context;
    private Fragment delegate;

    public MyItemRecyclerViewAdapterFeed(ArrayList<FeedData> items, Context context, Fragment delegate) {
        feedDataArrayList = items;
        this.context = context;
        this.delegate = delegate;
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
                delegate.getParentFragmentManager().beginTransaction().
                        replace(R.id.nav_host_fragment, fragComments, null).
                        commit();
            }
        });
        holder.buttonLike.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                itemData.incrementLikes();
                notifyItemChanged(holder.getAbsoluteAdapterPosition());
                holder.buttonLike.setBackgroundColor(Color.parseColor("#ff3399"));
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
        private ImageButton buttonLike;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            authorIV = itemView.findViewById(R.id.idCVAuthorComment);
            authorTV = itemView.findViewById(R.id.idTVAuthorNameComment);
            postIV = itemView.findViewById(R.id.idIVPost);
            likeTV = itemView.findViewById(R.id.idTVLikes);
            commentTV = itemView.findViewById(R.id.idTVComments);
            buttonLike = itemView.findViewById(R.id.likeBtn);
        }
    }
}