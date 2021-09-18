package com.example.ltdc3;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link ChallengeBoard#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ChallengeBoard extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private View mView;

    public ChallengeBoard() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment ChallengeBoard.
     */
    // TODO: Rename and change types and number of parameters
    public static ChallengeBoard newInstance(String param1, String param2) {
        ChallengeBoard fragment = new ChallengeBoard();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        mView = inflater.inflate(R.layout.fragment_challenge_board, container, false);
        setClickEvents(container);

        return mView;
    }

    private void setClickEvents(ViewGroup container) {
        View communityButton = mView.findViewById(R.id.communityChallengesText);
        communityButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                getParentFragmentManager().beginTransaction().
                        replace(container.getId(), new CommunityChallenge(), "communityChallenges").
                        commit();
            }
        });

        View friendButton = mView.findViewById(R.id.challengeAFriendText);
        friendButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                getParentFragmentManager().beginTransaction().
                        replace(container.getId(), new FriendChallenges(), "friendChallenges").
                        commit();
            }
        });

        View openButton = mView.findViewById(R.id.yourOpenChallengesText);
        openButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                getParentFragmentManager().beginTransaction().
                        replace(container.getId(), new OpenChallenges(), "openChallenges").
                        commit();
            }
        });
    }
}