package com.example.gameinvestor;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import Model.Club;

public class ClubFragment extends Fragment {
    private static final String CLUB_ID="club_id";

    private Club mClub;
    private TextView ClubNameTextView;
    private TextView ClubOrderTextView;

    public static ClubFragment newInstance(Club club){
        Bundle args=new Bundle();
        args.putSerializable(CLUB_ID,club);
        ClubFragment fragment=new ClubFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mClub=(Club) getArguments().getSerializable(CLUB_ID);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.club_info_fragment,container,false);
        ClubNameTextView=(TextView) view.findViewById(R.id.ClubnameText);
        ClubOrderTextView=(TextView) view.findViewById(R.id.ClubOrderText);
        ClubOrderTextView.setText(""+mClub.getClubOrder());
        ClubNameTextView.setText(mClub.getClubName());
        return view;
    }
}
