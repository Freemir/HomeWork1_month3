package com.homeworks.homework1_month3;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MainAdapter extends RecyclerView.Adapter<MainAdapter.MainViewHolder> {
    public ArrayList<String> list;

    public MainAdapter() {
        list = new ArrayList<>();
    }

    public void addText(String s) {
        list.add(s);
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public MainViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.view_holder, parent, false);
        return new MainViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MainViewHolder holder, int position) {
        holder.onBind(list.get(position));
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class MainViewHolder extends RecyclerView.ViewHolder {
        TextView vh;

        public MainViewHolder(@NonNull View itemView) {
            super(itemView);
            vh = itemView.findViewById(R.id.text_view_holder);
        }

        public void onBind(String s) {
            vh.setText(s);
        }
    }
}
