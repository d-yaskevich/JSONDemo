package com.myfirst.jsondemo.models;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.Date;

public class Info {

    @SerializedName(value = "squadName", alternate = "SquadName")
    public String squadName;
    @SerializedName("homeTown")
    public String homeTown;
    public int formed;
    public String secretBase;
    public boolean active;
    public Date date;
    public ArrayList<Member> members = new ArrayList<>();

}
