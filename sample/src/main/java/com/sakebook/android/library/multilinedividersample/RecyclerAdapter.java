package com.sakebook.android.library.multilinedividersample;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import java.util.ArrayList;

/**
 * Created by sakemotoshinya on 2017/04/25.
 */

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private LayoutInflater inflater;
    private ArrayList<String> items;

    public RecyclerAdapter(Context context, ArrayList<String> arrayList) {
        this.inflater = LayoutInflater.from(context);
        this.items = arrayList;
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        OddViewHolder holder = new OddViewHolder(inflater.inflate(R.layout.item_odd_vertical, parent, false));
        return holder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        ViewHolder<String> viewHolder = (ViewHolder<String>) holder;
        viewHolder.setData(items.get(position));
    }

}
