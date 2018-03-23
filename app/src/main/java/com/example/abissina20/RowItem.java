package com.example.abissina20;

/**
 * Created by BelA on 6/28/2017.
 */

public class RowItem {
    private String leaderName;
    private int profielPicId;
    public RowItem(String leaderName, int profielPicId){
        this.leaderName = leaderName;
        this.profielPicId=profielPicId;
    }
    public String getLeaderName(){
        return leaderName;
    }
    public void setLeaderName(String leaderName){
        this.leaderName=leaderName;
    }
    public int getProfielPicId(){
        return profielPicId;
    }
    public void setProfielPicId(){
        this.profielPicId=profielPicId;
    }
}
