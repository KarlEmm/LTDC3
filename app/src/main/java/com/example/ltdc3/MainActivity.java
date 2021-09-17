package com.example.ltdc3;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener {

    BottomNavigationView bottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bottomNavigationView = findViewById(R.id.bottomNavigationView);

        bottomNavigationView.setOnNavigationItemSelectedListener(this);
        bottomNavigationView.setSelectedItemId(R.id.home);

    }
    Home homeFrag = new Home();
    Challenge challengeFrag = new Challenge();
    Leaderboard leaderboardFrag = new Leaderboard();
    Chef chefFrag = new Chef();




    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {

        switch (item.getItemId()) {
            case R.id.home:
                getSupportFragmentManager().beginTransaction().replace(R.id.content, homeFrag).commit();
                return true;

            case R.id.challenges:
                getSupportFragmentManager().beginTransaction().replace(R.id.content, challengeFrag).commit();
                return true;

            case R.id.leaderboard:
                getSupportFragmentManager().beginTransaction().replace(R.id.content, leaderboardFrag).commit();
                return true;

            case R.id.chef:
                getSupportFragmentManager().beginTransaction().replace(R.id.content, chefFrag).commit();
                return true;
        }
        return false;
    }
}