package com.example.ltdc3;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link Profile#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Profile extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    private User user;

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public Profile() {
        // Required empty public constructor
        this.user = new User("etiennelazure@gmail.com", "Lazure", "Etienne", "Polytechnique", "testetes", R.drawable.chef, 500);

    }

    public Profile(User user) {
        // Required empty public constructor
        if(user.name != null) {
            this.user = user;
        } else {
            this.user = new User("etiennelazure@gmail.com", "Lazure", "Etienne", "Polytechnique", "testetes", R.drawable.chef, 500);

        }

    }


    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment Profile.
     */
    // TODO: Rename and change types and number of parameters
    public static Profile newInstance(String param1, String param2) {
        Profile fragment = new Profile();
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

        View view = inflater.inflate(R.layout.fragment_profile, container, false);
        TextView name = view.findViewById(R.id.nomProfil);
        name.setText(user.getCompleteName());

        TextView school = view.findViewById(R.id.nomEcole);
        school.setText(user.getSchool());

        TextView friends = view.findViewById(R.id.nombreAmis);
        friends.setText("4 friends");

        ImageView img = view.findViewById(R.id.idprofilPicIV);
        img.setImageResource(user.getProfilePic());

        return view;
    }

}