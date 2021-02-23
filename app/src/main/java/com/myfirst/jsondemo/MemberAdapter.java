package com.myfirst.jsondemo;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.myfirst.jsondemo.models.Member;

import java.util.ArrayList;

public class MemberAdapter extends RecyclerView.Adapter<MemberAdapter.MemberViewHolder> {

    private final LayoutInflater inflater;
    private final ArrayList<Member> data = new ArrayList<>();

    public MemberAdapter(Context context) {
        this.inflater = LayoutInflater.from(context);
    }

    public void resetData(ArrayList<Member> data) {
        this.data.clear();
        this.data.addAll(data);
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public MemberViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = inflater.inflate(android.R.layout.simple_list_item_1, parent, false);
        return new MemberViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MemberViewHolder holder, int position) {
        Member item = data.get(position);
        holder.onBind(item);
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    static class MemberViewHolder extends RecyclerView.ViewHolder {

        private final TextView tvInfo;

        public MemberViewHolder(@NonNull View itemView) {
            super(itemView);
            tvInfo = itemView.findViewById(android.R.id.text1);
        }

        public void onBind(Member item) {
            //todo
        }
    }
}
