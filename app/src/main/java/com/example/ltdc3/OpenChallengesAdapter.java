package com.example.ltdc3;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.FrameLayout;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class OpenChallengesAdapter extends RecyclerView.Adapter<OpenChallengesAdapter.ViewHolder> {
    private ArrayList<OpenChallenge> localDataSet;
    private ArrayList<ViewHolder> allItems = new ArrayList<>();

    /**
     * Provide a reference to the type of views that you are using
     * (custom ViewHolder).
     */
    public static class ViewHolder extends RecyclerView.ViewHolder {
        private final TextView challengeName;
        private final TextView friendName;
        private boolean open = false;
        private ArrayList<ViewHolder> allItems;
        private View view;

        public ViewHolder(View view, ArrayList<ViewHolder> allItems) {
            super(view);
            // Define click listener for the ViewHolder's View

            this.view = view;
            this.allItems = allItems;
            challengeName = (TextView) view.findViewById(R.id.openChallengesItemName);
            friendName = (TextView) view.findViewById(R.id.openChallengesItemFriend);

            setupEvents(view);
        }

        public TextView getChallengeName() {
            return challengeName;
        }

        public TextView getFriendName() {
            return friendName;
        }

        private void setupEvents(View view) {
            View communityButton = view.findViewById(R.id.openChallengesButton);
            communityButton.setOnClickListener(new View.OnClickListener() {
                public void onClick(View clickedView) {
                    Context appContext = view.getContext();
                    FrameLayout hiddenPanel = view.findViewById(R.id.openChallengePanel);

                    if(!open) {
                        Animation bottomUp = AnimationUtils.loadAnimation(appContext,
                                R.anim.bottom_up);

                        closeAllOtherPanels();
                        hiddenPanel.startAnimation(bottomUp);
                        hiddenPanel.setVisibility(View.VISIBLE);

                        open = true;
                    } else {
                        hiddenPanel.setVisibility(View.GONE);
                        open = false;
                    }
                }
            });
        }

        private void closeAllOtherPanels() {
            for(ViewHolder item : allItems) {
                if(item != this) {
                    item.open = false;
                    item.view.findViewById(R.id.openChallengePanel).setVisibility(View.GONE);
                }
            }
        }
    }

    /**
     * Initialize the dataset of the Adapter.
     * @param dataSet
     */
    public OpenChallengesAdapter(ArrayList<OpenChallenge> dataSet) {
        localDataSet = dataSet;
    }

    // Create new views (invoked by the layout manager)
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        // Create a new view, which defines the UI of the list item
        View view = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.layout_open_challenges, viewGroup, false);

        ViewHolder item = new ViewHolder(view, allItems);
        allItems.add(item);
        return item;
    }

    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(ViewHolder viewHolder, final int position) {

        // Get element from your dataset at this position and replace the
        // contents of the view with that element
        viewHolder.getChallengeName().setText(localDataSet.get(position).challengeName);
        viewHolder.getFriendName().setText("By " + localDataSet.get(position).fromFriend);
    }

    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return localDataSet.size();
    }
}

