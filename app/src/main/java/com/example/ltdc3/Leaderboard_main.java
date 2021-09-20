package com.example.ltdc3;

import android.graphics.Color;
import android.graphics.Paint;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.fragment.app.Fragment;


public class Leaderboard_main extends Fragment {

    Button button_friends;
    Button button_school;
    public Leaderboard_main() {

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_leaderboard_main, container, false);

        button_friends = view.findViewById(R.id.button4);
        button_school = view.findViewById(R.id.button5);

        button_friends.setTextColor(Color.parseColor("#4d51b7"));
        button_friends.setPaintFlags(button_friends.getPaintFlags() | Paint.UNDERLINE_TEXT_FLAG);

        button_friends.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                button_friends.setTextColor(Color.parseColor("#4d51b7"));
                button_friends.setPaintFlags(button_friends.getPaintFlags() | Paint.UNDERLINE_TEXT_FLAG);

                button_school.setTextColor(Color.parseColor("#000000"));
                button_school.setPaintFlags(button_friends.getPaintFlags() & 0);
            }
        });

        button_school.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                button_school.setTextColor(Color.parseColor("#4d51b7"));
                button_school.setPaintFlags(button_friends.getPaintFlags() | Paint.UNDERLINE_TEXT_FLAG);

                button_friends.setTextColor(Color.parseColor("#000000"));
                button_friends.setPaintFlags(button_friends.getPaintFlags() & 0);
            }
        });

        return view;
    }
}
