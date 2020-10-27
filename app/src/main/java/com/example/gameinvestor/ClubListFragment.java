package com.example.gameinvestor;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import Model.Club;
import Model.League;

public class ClubListFragment extends Fragment {
    private List<Club> clubs;
    private RecyclerView clubRecycler;
    private ClubAdapter clubAdapter;
    private TextView clubName;
    private TextView clubOrder;
    private TextView clubScore;
    private Spinner gameSpinner;
    private Spinner leagueSpinner;
    private ArrayAdapter<String> gameSpinnerAdapter;
    private ArrayAdapter<String> leagueSpinnerAdapter;
    private List<String> gameLise;
    private List<String> leagueList;


    private void initData(){
        gameLise=new ArrayList<String>();
        gameLise.add("游戏类别");
        gameLise.add("英雄联盟");
        gameLise.add("DOTA2");
        leagueList=new ArrayList<String>();
        leagueList.add("赛区");
        clubs=new ArrayList<Club>();
    }
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        initData();
        View view=inflater.inflate(R.layout.club_fragment,container,false);
        clubRecycler=(RecyclerView) view.findViewById(R.id.club_recycler_view);
        clubRecycler.setLayoutManager(new LinearLayoutManager(getActivity()));
        clubName=(TextView) view.findViewById(R.id.title_club_name);
        clubOrder=(TextView) view.findViewById(R.id.title_club_order);
        clubScore=(TextView) view.findViewById(R.id.title_club_score);
        gameSpinner=(Spinner) view.findViewById(R.id.game_spinner);
        gameSpinnerAdapter=new ArrayAdapter<String>(getActivity(),
                android.R.layout.simple_list_item_1,gameLise);
        gameSpinner.setAdapter(gameSpinnerAdapter);
        gameSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String game= (String) gameSpinner.getSelectedItem();
                if(game.equals("英雄联盟")){
                    leagueList.clear();
                    leagueList.add("赛区");
                    leagueList.add("LPL");
                    leagueList.add("LCK");
                    leagueList.add("LCS");
                    leagueList.add("LEU");
                    leagueSpinnerAdapter.notifyDataSetChanged();
                }else if (game.equals("DOTA2")){
                    leagueList.clear();
                    leagueList.add("赛区");
                    leagueList.add("ASIA");
                    leagueList.add("EU");
                    leagueSpinnerAdapter.notifyDataSetChanged();
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        leagueSpinner=(Spinner) view.findViewById(R.id.league_spinner);
        leagueSpinnerAdapter=new ArrayAdapter<String>(getActivity(),
                android.R.layout.simple_list_item_1,leagueList);
        leagueSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String league=(String) leagueSpinner.getSelectedItem();
                if(!league.equals("赛区")){
                    clubs=League.getClubList(league);
                    clubAdapter.notifyDataSetChanged();
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        leagueSpinner.setAdapter(leagueSpinnerAdapter);
        Intilize();
        return view;
    }

    private class ClubHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        private TextView clubOrderText;
        private TextView clubNameText;
        private TextView clubInvestmentGoalText;
        private Club mClub;

        public ClubHolder(@NonNull View itemView) {
            super(itemView);
            itemView.setOnClickListener(this);
            clubNameText=(TextView) itemView.findViewById(R.id.club_name);
            clubOrderText=(TextView) itemView.findViewById(R.id.club_order);
            clubInvestmentGoalText=(TextView)itemView.findViewById(R.id.club_investment_goal);
        }
        public void bindClub(Club club){
            mClub=club;
            clubOrderText.setText(""+mClub.getClubOrder());
            clubNameText.setText(mClub.getClubName());
        }
        @Override
        public void onClick(View v) {
            Intent intent=ClubFragmentActivity.newIntent(getActivity(),mClub);
            startActivity(intent);
        }
    }
    private class ClubAdapter extends RecyclerView.Adapter<ClubHolder>{

        public ClubAdapter(List<Club> clubList){clubs=clubList;}

        @NonNull
        @Override
        public ClubHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            LayoutInflater inflater=LayoutInflater.from(getActivity());
            View view=inflater.inflate(R.layout.club_item,parent,false);
            return new ClubHolder(view);
        }

        @Override
        public void onBindViewHolder(@NonNull ClubHolder holder, int position) {
            Club club=clubs.get(position);
            holder.bindClub(club);
        }

        @Override
        public int getItemCount() {
            return clubs.size();
        }
        private void setClubs(List<Club> clubList){clubs=clubList;}

    }

    private void Intilize(){
        if(clubAdapter==null){
            clubAdapter=new ClubAdapter(clubs);
            clubRecycler.setAdapter(clubAdapter);
        }else{
            clubAdapter.setClubs(clubs);
            clubAdapter.notifyDataSetChanged();
        }
    }
}
