package com.example.bottomtab;

import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        BottomNavigationView bottomNav = findViewById(R.id.bottom_nav);
        bottomNav.setOnNavigationItemSelectedListener(navListener);

        getSupportFragmentManager().beginTransaction().replace(R.id.frag_container,
                new EntriesFrag()).commit();
    }

    private BottomNavigationView.OnNavigationItemSelectedListener navListener =
            new BottomNavigationView.OnNavigationItemSelectedListener() {
                @Override
                public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                    Fragment selectedFragment = null;

                    switch (menuItem.getItemId()) {
                        case R.id.nav_entries:
                            selectedFragment = new EntriesFrag();
                            break;
                        case R.id.nav_tracker:
                            selectedFragment = new TrackerFrag();
                            break;
                        case R.id.nav_add:
                            selectedFragment = new NewEntry();
                            break;
                    }

                    getSupportFragmentManager().beginTransaction().replace(R.id.frag_container,selectedFragment).commit();

                return true;
                }

            };
}
