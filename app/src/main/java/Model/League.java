package Model;

import java.util.ArrayList;
import java.util.List;

public class League {
    private static List<Club> LPLclubList;
    private static List<Club> LCKclubList;
    private static List<Club> LCSclubList;
    private static List<Club> LEUclubList;


    private List<Club> clubList;
    private String leagueName;

    public League(String name){
        this.leagueName=name;
    }

    public String getLeagueName() {
        return leagueName;
    }
    public List<Club> getClubList() {
        return clubList;
    }
    public void setClubList(List<Club> clubList) {
        this.clubList = clubList;
    }
    public void setLeagueName(String leagueName) {
        this.leagueName = leagueName;
    }

    private static void init(){
        LPLclubList=new ArrayList<>();
        LCSclubList=new ArrayList<>();
        LCKclubList=new ArrayList<>();
        LEUclubList=new ArrayList<>();
        for(int i=1;i<100;i++){
            Club club=new Club(i);
            club.setClubName("RNG " +i);
            club.setClubOrder(i);
            LPLclubList.add(club);
        }
        for(int i=1;i<100;i++){
            Club club=new Club(i);
            club.setClubName("SKT "+i);
            club.setClubOrder(i);
            LCKclubList.add(club);
        }
        for(int i=1;i<50;i++){
            Club club=new Club(i);
            club.setClubName("G2 "+i);
            club.setClubOrder(i);
            LCSclubList.add(club);
        }
        for(int i=1;i<30;i++){
            Club club=new Club(i);
            club.setClubName("TL"+i);
            club.setClubOrder(i);
            LEUclubList.add(club);
        }
    }

    public static List<Club> getClubList(String leagueName) {
        init();
        switch (leagueName){
            case "LPL":
                return LPLclubList;
            case "LCK":
                return LCKclubList;
            case "LEU":
                return LEUclubList;
            case "LCS":
                return LCSclubList;
            default:
                break;
        }
        return null;
    }
}
