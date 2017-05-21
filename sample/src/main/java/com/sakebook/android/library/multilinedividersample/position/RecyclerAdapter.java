package com.sakebook.android.library.multilinedividersample.position;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.sakebook.android.library.multilinedividersample.R;

import java.util.ArrayList;

/**
 * Created by sakemotoshinya on 2017/05/21.
 */

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private LayoutInflater inflater;
    private ArrayList<Integer> items;
    private boolean inverted;
    private int orientation;

    public RecyclerAdapter(Context context, ArrayList<Integer> arrayList, boolean inverted, int orientation) {
        this.inflater = LayoutInflater.from(context);
        this.items = arrayList;
        this.inverted = inverted;
        this.orientation = orientation;
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        ViewHolder<Integer> holder;
        int layoutId = (orientation == LinearLayout.VERTICAL) ? R.layout.item_vertical: R.layout.item_horizontal;
        if (inverted) {
            holder = new PositionInvertedViewHolder(inflater.inflate(layoutId, parent, false));
        } else {
            holder = new PositionViewHolder(inflater.inflate(layoutId, parent, false));
        }
        return holder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        ((ViewHolder<Integer>)holder).setData(position);
    }
}
