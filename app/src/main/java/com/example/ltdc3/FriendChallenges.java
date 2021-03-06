package com.example.ltdc3;

import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;

import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.Fragment;

import android.text.Editable;
import android.text.Html;
import android.text.TextWatcher;
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

        setupNameSuggestions();
        setupRecipeSuggestions();
        setupEvents();

        return mView;
    }

    private void setupNameSuggestions() {
        AutoCompleteTextView nameInput = mView.findViewById(R.id.friendNameInput);
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

    private void setupRecipeSuggestions() {
        AutoCompleteTextView recipeInput = mView.findViewById(R.id.challengeRecipeInput);
        recipeInput.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                updateRecipeSuggestions();
            }
        });
    }

    private void updateRecipeSuggestions() {
        Context appContext = getActivity();
        ArrayList<String> suggestedRecipes = new ArrayList<String>();
        Database db = (Database)appContext.getApplicationContext();
        AutoCompleteTextView input = mView.findViewById(R.id.challengeRecipeInput);

        db.getRecipeSuggestions(input.getText().toString(), new RecipeSuggestion() {
            @Override
            public void suggestionsReceived(ArrayList<String> suggestions) {
                for(String recipe : suggestions) {
                    suggestedRecipes.add(recipe);
                }

                ArrayAdapter<String> adapter = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_dropdown_item_1line, suggestedRecipes);
                input.setAdapter(adapter);
                input.showDropDown();
            }
        });
    }

    private void setupEvents() {
        View communityButton = mView.findViewById(R.id.sendChallengeButton);
        communityButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                uploadChallenge();
            }
        });
    }

    private void uploadChallenge() {
        String friendToChallenge = ((EditText)mView.findViewById(R.id.friendNameInput)).getText().toString();
        String challengeName = ((EditText)mView.findViewById(R.id.friendChallengeNameInput)).getText().toString();
        String recipe = ((EditText)mView.findViewById(R.id.challengeRecipeInput)).getText().toString();

        Context appContext = getActivity();
        Database db = (Database)appContext.getApplicationContext();

        SentChallenge challenge = new SentChallenge(friendToChallenge, challengeName, recipe);
        db.sentChallenges.add(challenge);

        showPopup(friendToChallenge, recipe);
    }

    private void showPopup(String friendName, String recipe) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());

        builder.setTitle("Challenge sent!");

        String dialogMessage = "You have challenged <b>" + friendName + "</b> to cook <b>" + recipe + "</b>.";
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.N) {
            builder.setMessage(Html.fromHtml(dialogMessage, Html.FROM_HTML_MODE_LEGACY));
        } else {
            builder.setMessage(Html.fromHtml(dialogMessage));
        }

        builder.setPositiveButton("Continue", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
                getParentFragmentManager().popBackStackImmediate();
            }
        });

        AlertDialog dialog = builder.create();
        dialog.setCancelable(false);
        dialog.setCanceledOnTouchOutside(false);
        dialog.show();
    }
}