package com.example.gameinvestor;

import android.content.Context;
import android.content.Intent;

import androidx.fragment.app.Fragment;

import Model.Club;

public class ClubFragmentActivity extends SingleFramentActivity {
    private static final String EXTRA_CLUB_ID="com\\example\\gameinvestor\\LeagueFragmentActivity.java";
    public static Intent newIntent(Context packageContext, Club club){
        Intent intent=new Intent(packageContext, ClubFragmentActivity.class);
        intent.putExtra(EXTRA_CLUB_ID,club);
        return intent;
    }
    @Override
    protected Fragment createFragment() {
        Club club=(Club) getIntent().getSerializableExtra(EXTRA_CLUB_ID);
        return ClubFragment.newInstance(club);
    }
}
