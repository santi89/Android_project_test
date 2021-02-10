package com.example.appfragment;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {
    BottomNavigationView btm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btm = findViewById(R.id.tb_view);
        getSupportFragmentManager().beginTransaction()
                .add(R.id.contentMain, new activityHome())
                .addToBackStack(null)
                .commit();

        btm.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                Fragment fragselect = null;
                switch (item.getItemId()) {
                    case R.id.menu_home:
                        fragselect = new activityHome();
                        break;
                    case R.id.menu_register:
                        fragselect = new Fragment_Register();
                        break;
                    case R.id.menu_setting: {
                        fragselect = new Fragment_Setting();
                        break;

                    }
                }
                getSupportFragmentManager()
                        .beginTransaction()
                        .replace(R.id.contentMain, fragselect)
                        .addToBackStack(null)
                        .commit();

                return false;
            }
        });

    }
}