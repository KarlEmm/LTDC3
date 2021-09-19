package com.example.ltdc3;

import android.content.Context;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.text.Editable;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.EditText;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link FriendChallenges#newInstance} factory method to
 * create an instance of this fragment.
 */
public class FriendChallenges extends Fragment {
    View mView;

    public FriendChallenges() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     * @return A new instance of fragment FriendChallenges.
     */
    // TODO: Rename and change types and number of parameters
    public static FriendChallenges newInstance() {
        FriendChallenges fragment = new FriendChallenges();

        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        mView = inflater.inflate(R.layout.fragment_friend_challenges, container, false);
        setupSuggestions();

        return mView;
    }

    private void setupSuggestions() {
        AutoCompleteTextView nameInput = mView.findViewById(R.id.challengeNameInput);
        String[] suggestions = new String[2];
        Context appContext = getActivity();

        ArrayList<String> suggestedNames = new ArrayList<String>();
        Database db = (Database)appContext.getApplicationContext();

        for(User user : db.getUsers()) {
            suggestedNames.add(user.firstname + " " + user.name);
        }

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_dropdown_item_1line, suggestedNames);
        nameInput.setAdapter(adapter);
    }
}