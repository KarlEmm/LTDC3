package com.example.ltdc3;

import androidx.annotation.NonNull;
        import androidx.recyclerview.widget.RecyclerView;

        import android.content.Context;
        import android.view.LayoutInflater;
        import android.view.View;
        import android.view.ViewGroup;
        import android.widget.TextView;

        import java.util.ArrayList;

        import de.hdodenhof.circleimageview.CircleImageView;

public class RecyclerViewAdapterComment extends RecyclerView.Adapter<RecyclerViewAdapterComment.ViewHolder> {

    private ArrayList<Comment> commentDataArrayList;
    private Context context;

    public RecyclerViewAdapterComment(ArrayList<Comment> items, Context context) {
        commentDataArrayList = items;
        this.context = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.fragment_comments, parent, false);
        return new RecyclerViewAdapterComment.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerViewAdapterComment.ViewHolder holder, int position) {
        Comment itemData = commentDataArrayList.get(position);
        holder.authorTV.setText(context.getString(R.string.username, itemData.getUser().getFirstname(), itemData.getUser().getName()));
        holder.commentTV.setText(itemData.getCommentText());
        holder.timeElapsedTV.setText(itemData.getTimeElapsed());
        holder.authorIV.setImageResource(itemData.getUser().getProfilePic());
    }

    @Override
    public int getItemCount() {
        return commentDataArrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        CircleImageView authorIV;
        TextView authorTV;
        TextView commentTV;
        TextView timeElapsedTV;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            authorIV = itemView.findViewById(R.id.idCVAuthorComment);
            authorTV = itemView.findViewById(R.id.idTVAuthorNameComment);
            commentTV = itemView.findViewById(R.id.commentTV);
            timeElapsedTV = itemView.findViewById(R.id.timeElapsedComment);
        }
    }
}
