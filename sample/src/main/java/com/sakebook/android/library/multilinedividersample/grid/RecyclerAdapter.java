package com.sakebook.android.library.multilinedividersample.grid;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.sakebook.android.library.multilinedividersample.R;
import com.sakebook.android.library.multilinedividersample.multiline.Number;

import java.util.ArrayList;

/**
 * Created by sakemotoshinya on 2017/05/15.
 */

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private LayoutInflater inflater;
    private ArrayList<Integer> items;
    private int orientation;

    public RecyclerAdapter(Context context, ArrayList<Integer> arrayList, int orientation) {
        this.inflater = LayoutInflater.from(context);
        this.items = arrayList;
        this.orientation = orientation;
    }

    @Override
    public int getItemViewType(int position) {
        Number number = Number.id(items.get(position));
        switch (number) {
            case EVEN:
                break;
            case ODD:
                break;
            case PRIME:
                break;
        }
        return number.type();
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        ViewHolder<String> holder = null;
        int layoutId;
        Number number = Number.id(viewType);
        switch (number) {
            case EVEN:
                layoutId = (orientation == LinearLayout.VERTICAL) ? R.layout.item_even_grid_vertical: R.layout.item_even_grid_horizontal;
                holder = new EvenImageViewHolder(inflater.inflate(layoutId, parent, false));
                break;
            case ODD:
                layoutId = (orientation == LinearLayout.VERTICAL) ? R.layout.item_odd_grid_vertical: R.layout.item_odd_grid_horizontal;
                holder = new OddImageViewHolder(inflater.inflate(layoutId, parent, false));
                break;
            case PRIME:
                layoutId = (orientation == LinearLayout.VERTICAL) ? R.layout.item_prime_grid_vertical: R.layout.item_prime_grid_horizontal;
                holder = new PrimeImageViewHolder(inflater.inflate(layoutId, parent, false));
                break;
        }
        return holder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
    }
}
