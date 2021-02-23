package com.myfirst.jsondemo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private ImageView ivCompareStatusBegin;
    private TextView tvInfoStatusBegin;

    private MemberAdapter adapterBegin;

    private ImageView ivCompareStatusEnd;
    private TextView tvInfoStatusEnd;

    private MemberAdapter adapterEnd;

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
        // todo
    }

    public void onCompareWithSource(View view) {
        // todo
    }
}