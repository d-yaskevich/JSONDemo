package com.myfirst.jsondemo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.myfirst.jsondemo.models.Info;

public class MainActivity extends AppCompatActivity {

    private ImageView ivCompareStatusBegin;
    private TextView tvInfoStatusBegin;

    private MemberAdapter adapterBegin;
    private Info infoBegin;

    private ImageView ivCompareStatusEnd;
    private TextView tvInfoStatusEnd;

    private MemberAdapter adapterEnd;
    private Info infoEnd;

    private static final String TAG = "MISTAKE";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ivCompareStatusBegin = findViewById(R.id.iv_compare_status_begin);
        tvInfoStatusBegin = findViewById(R.id.tv_info_begin);

        adapterBegin = new MemberAdapter(this);
        RecyclerView rvInfoListBegin = findViewById(R.id.rv_info_list_begin);
        rvInfoListBegin.setLayoutManager(new LinearLayoutManager(this));
        rvInfoListBegin.setAdapter(adapterBegin);

        ivCompareStatusEnd = findViewById(R.id.iv_compare_status_end);
        tvInfoStatusEnd = findViewById(R.id.tv_info_end);

        adapterEnd = new MemberAdapter(this);
        RecyclerView rvInfoListEnd = findViewById(R.id.rv_info_list_end);
        rvInfoListEnd.setLayoutManager(new LinearLayoutManager(this));
        rvInfoListEnd.setAdapter(adapterEnd);
    }

    public void onReadJson(View view) {

        // todo - 1 - достать строку, 2 - из строки получить Info, 3 - Info запихнуть в адаптер

        infoBegin = JSONHelper.fromJson(JSONHelper.getJsonString(this));
        //Log.e(TAG, "infoBegin: " + infoBegin);
        tvInfoStatusBegin.setText(infoBegin.toString());
        //tvInfoStatusBegin.setText(JSONHelper.getJsonString(this));
        adapterBegin.resetData(infoBegin.members);
        //Log.e(TAG, "Begin members: " + infoBegin.members);

        infoEnd = JSONHelper.fromGson(JSONHelper.getJsonString(this));

        tvInfoStatusEnd.setText(infoEnd.toString());

        adapterEnd.resetData(infoEnd.members);
        //Log.e(TAG, "End members: " + infoEnd.members);

    }

    public void onCompareWithSource(View view) {
        // todo

        if ((JSONHelper.getJsonString(this).replaceAll("\\s+","")).equals(JSONHelper.toJson(infoBegin).replaceAll("\\s+",""))){
            ivCompareStatusBegin.setBackgroundColor(Color.GREEN);
        } else {
            ivCompareStatusBegin.setBackgroundColor(Color.RED);
        }

        Log.e(TAG, "JSONHelper.getJsonString(this): " + JSONHelper.getJsonString(this).replaceAll("\\s+",""));
        Log.e(TAG, "JSONHelper.toJson(infoBegin): " + JSONHelper.toJson(infoBegin).replaceAll("\\s+",""));

        if (!(JSONHelper.getJsonString(this)).equals(JSONHelper.toGson(infoEnd))){
            ivCompareStatusEnd.setBackgroundColor(Color.RED);
        } else {
            ivCompareStatusEnd.setBackgroundColor(Color.GREEN);
        }

        Log.e(TAG, "JSONHelper.getJsonString(this): " + JSONHelper.getJsonString(this));
        Log.e(TAG, "JSONHelper.toGson(infoEnd): " + JSONHelper.toGson(infoEnd));

    }
}