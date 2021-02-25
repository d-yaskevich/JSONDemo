package com.myfirst.jsondemo.models;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.Date;
import java.util.Objects;

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

    @Override
    public String toString() {
        return "{" + '\n' +
                "\"squadName\": " + "\"" + squadName + "\"" + "," + '\n' +
                "\"homeTown\": " + "\"" + homeTown + "\"" + "," + '\n' +
                "\"formed\": " + formed + "," + '\n' +
                "\"secretBase\": " + "\"" + secretBase + "\"" + "," + '\n' +
                "\"active\": " + active + "," + '\n' +
                "\"date\": " + "\"" + date + "\"" + "," + '\n' +
                "\"members\": " + '\n' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Info info = (Info) o;
        return formed == info.formed &&
                active == info.active &&
                Objects.equals(squadName, info.squadName) &&
                Objects.equals(homeTown, info.homeTown) &&
                Objects.equals(secretBase, info.secretBase) &&
                Objects.equals(date, info.date) &&
                Objects.equals(members, info.members);
    }

    @Override
    public int hashCode() {
        return Objects.hash(squadName, homeTown, formed, secretBase, active, date, members);
    }
}
