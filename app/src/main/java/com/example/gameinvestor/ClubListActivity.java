package com.example.gameinvestor;

import androidx.fragment.app.Fragment;

public class ClubListActivity extends SingleFramentActivity {


    @Override
    protected Fragment createFragment() {
        //getSupportActionBar().hide();
        return new ClubListFragment();
    }
}