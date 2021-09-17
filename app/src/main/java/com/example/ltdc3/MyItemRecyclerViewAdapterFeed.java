package com.example.ltdc3;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Activity;
import android.content.Context;
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
        holder.authorTV.setText(itemData.getUser().getFirstname() + " " + itemData.getUser().getName());
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
                authorIV = itemView.findViewById(R.id.idCVAuthor);
                authorTV = itemView.findViewById(R.id.idTVAuthorName);
                postIV = itemView.findViewById(R.id.idIVPost);
                likeTV = itemView.findViewById(R.id.idTVLikes);
                commentTV = itemView.findViewById(R.id.idTVComments);
        }
    }
}