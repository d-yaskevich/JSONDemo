package com.myfirst.jsondemo;

import android.content.Context;
import android.util.Log;
import android.widget.Toast;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.myfirst.jsondemo.models.Info;
import com.myfirst.jsondemo.models.Member;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Locale;

public class JSONHelper {

    private static final String TAG = JSONHelper.class.getSimpleName();
    private static final String TAG_MEMBERS = "MEMBERS";

    private static final String DATE_FORMAT = "yyyy-MM-dd hh:mm:ss a";

    public static String getJsonString(Context context) {
        StringBuilder stringBuilder = new StringBuilder();

        try (InputStream inputStream = context.getResources().openRawResource(R.raw.json_example);
             InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
             BufferedReader reader = new BufferedReader(inputStreamReader)) {

            String line = reader.readLine();
            while (line != null) {
                stringBuilder.append(line);
                line = reader.readLine();
            }
        } catch (IOException e) {
            String message = e.getMessage();
            Log.e(TAG, "Json reading error: " + message);
            Toast.makeText(context, "Json reading error: " + message, Toast.LENGTH_LONG).show();
        }

        return stringBuilder.toString();
    }

    // Using internal library

    public static Info fromJson(String jsonStr) {
        Info info = new Info();

        if (jsonStr != null && !jsonStr.isEmpty()) {
            try {
                JSONObject jsonObj = new JSONObject(jsonStr);

                info.squadName = jsonObj.getString("squadName");
                info.homeTown = jsonObj.getString("homeTown");
                info.formed = jsonObj.getInt("formed");
                info.secretBase = jsonObj.getString("secretBase");
                info.active = jsonObj.getBoolean("active");

                String date = jsonObj.getString("date");
                SimpleDateFormat format = new SimpleDateFormat(DATE_FORMAT, Locale.getDefault());
                info.date = format.parse(date);

                JSONArray members = jsonObj.getJSONArray("members");
                for (int i = 0; i < members.length(); i++) {
                    Member member = new Member();
                    Log.e(TAG_MEMBERS, "members: " + members);
                    JSONObject jsonMember = members.getJSONObject(i);

                    member.name = jsonMember.getString("name");
                    member.age = jsonMember.getInt("age");
                    member.secretIdentity = jsonMember.getString("secretIdentity");

                    JSONArray powers = jsonMember.getJSONArray("powers");
                    for (int j = 0; j < powers.length(); j++) {
                        String power = powers.getString(j);
                        Log.e(TAG_MEMBERS, "power: " + powers.getString(j));
                        member.powers.add(power);
                    }

                    info.members.add(member);
                }

            } catch (final JSONException e) {
                String message = e.getMessage();
                Log.e(TAG, "Json parsing error: " + message);
//                Toast.makeText(context, "Json parsing error: " + message, Toast.LENGTH_LONG).show();
            } catch (final ParseException e) {
                String message = e.getMessage();
                Log.e(TAG, "Date parsing error: " + message);
//                Toast.makeText(context, "Date parsing error: " + message, Toast.LENGTH_LONG).show();
            }
        }

        return info;
    }

    public static String toJson(Info info) {
        JSONObject jsonObject = new JSONObject();

        try {
            jsonObject.put("squadName", info.squadName);
            jsonObject.put("homeTown", info.homeTown);
            jsonObject.put("formed", info.formed);
            jsonObject.put("secretBase", info.secretBase);
            jsonObject.put("active", info.active);

            SimpleDateFormat format = new SimpleDateFormat(DATE_FORMAT, Locale.getDefault());
            String date = format.format(info.date);
            jsonObject.put("date", date);

            JSONArray jsonMembers = new JSONArray();

            for (Member member : info.members){
                JSONObject jsonMember = new JSONObject();

                jsonMember.put("name", member.name);
                jsonMember.put("age", member.age);
                jsonMember.put("secretIdentity", member.secretIdentity);
                jsonMembers.put(jsonMember);

                JSONArray powers = new JSONArray();
                for (String power : member.powers) {
                    powers.put(power);
                }


                jsonMember.put("powers", powers);
            }
            jsonObject.put("members", jsonMembers);

        } catch (JSONException e) {
            String message = e.getMessage();
            Log.e(TAG, "Json parsing error: " + message);
//            Toast.makeText(context, "Json parsing error: " + message, Toast.LENGTH_LONG).show();
        }

        return jsonObject.toString();
    }

    // Using Gson library

    public static String toGson(Info info) {
        GsonBuilder builder = new GsonBuilder();
        builder.setDateFormat(DATE_FORMAT);

        Gson gson = builder.create();
        return gson.toJson(info);
    }

    public static Info fromGson(String jsonStr) {
        GsonBuilder builder = new GsonBuilder();
        builder.setDateFormat(DATE_FORMAT);

        Gson gson = builder.create();
        return gson.fromJson(jsonStr, Info.class);
    }
}
