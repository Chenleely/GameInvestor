package Model;

import java.io.Serializable;

public class Club implements Serializable {
    private String ClubId;
    private int ClubOrder;
    private String ClubName;
    private Float ClubGoal;
    public Club(int order){ClubOrder=order;}

    public String getClubId() {
        return ClubId;
    }

    public int  getClubOrder() {
        return ClubOrder;
    }

    public Float getClubGoal() {
        return ClubGoal;
    }

    public String getClubName() {
        return ClubName;
    }

    public void setClubOrder(int  clubOrder) {
        ClubOrder = clubOrder;
    }

    public void setClubGoal(Float clubGoal) {
        ClubGoal = clubGoal;
    }

    public void setClubName(String clubName) {
        ClubName = clubName;
    }

    public void setClubId(String clubId) {
        ClubId = clubId;
    }
}
