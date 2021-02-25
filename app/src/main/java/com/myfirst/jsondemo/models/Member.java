package com.myfirst.jsondemo.models;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.Objects;

public class Member {

    @SerializedName(value = "name", alternate = "Name")
    public String name;
    @SerializedName("age")
    public int age;
    public String secretIdentity;
    public ArrayList<String> powers = new ArrayList<>();

    @Override
    public String toString() {
        return "{" + '\n' +
                "\"name\": " + "\"" + name + "\"" + "," + '\n' +
                "\"age\": " + age + "," + '\n' +
                "\"secretIdentity\": " + "\"" + secretIdentity + "\"" + "," + '\n' +
                "\"powers\": " + powers + "," + '\n' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Member member = (Member) o;
        return age == member.age &&
                Objects.equals(name, member.name) &&
                Objects.equals(secretIdentity, member.secretIdentity) &&
                Objects.equals(powers, member.powers);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age, secretIdentity, powers);
    }
}
