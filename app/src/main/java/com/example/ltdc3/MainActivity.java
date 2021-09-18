package com.example.ltdc3;

import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button btn = (Button)findViewById(R.id.button2);
        btn.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent myIntent = new Intent(MainActivity.this, Login.class);
                MainActivity.this.startActivity(myIntent);
            }
        });
        setContentView(R.layout.activity_create_account);
        Button btn1 = (Button)findViewById(R.id.button3);
        btn1.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent myIntent1 = new Intent (MainActivity.this,CreateAccount.class);
                MainActivity.this.startActivity(myIntent1);
            }
        });
//        BottomNavigationView navView = findViewById(R.id.nav_view);
//        navView.setItemIconTintList(null);
//        // Passing each menu ID as a set of Ids because each
//        // menu should be considered as top level destinations.
//        AppBarConfiguration appBarConfiguration = new AppBarConfiguration.Builder(
//                R.id.homePage, R.id.challengeBoard, R.id.leaderboard, R.id.profile)
//                .build();
//        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
//        NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);
//        NavigationUI.setupWithNavController(navView, navController);
    }

}