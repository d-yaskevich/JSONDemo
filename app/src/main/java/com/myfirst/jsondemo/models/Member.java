package com.myfirst.jsondemo.models;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class Member {

    @SerializedName(value = "name", alternate = "Name")
    public String name;
    @SerializedName("age")
    public int age;
    public String secretIdentity;
    public ArrayList<String> powers = new ArrayList<>();

}
