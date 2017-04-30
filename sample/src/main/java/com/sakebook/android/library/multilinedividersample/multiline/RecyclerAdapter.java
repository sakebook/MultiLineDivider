package com.sakebook.android.library.multilinedividersample.multiline;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.sakebook.android.library.multilinedividersample.R;

import java.util.ArrayList;

/**
 * Created by sakemotoshinya on 2017/04/25.
 */

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private LayoutInflater inflater;
    private ArrayList<String> items;
    private int orientation;

    public RecyclerAdapter(Context context, ArrayList<String> arrayList, int orientation) {
        this.inflater = LayoutInflater.from(context);
        this.items = arrayList;
        this.orientation = orientation;
    }

    @Override
    public int getItemViewType(int position) {
        Number number = Number.id(position);
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
                layoutId = (orientation == LinearLayout.VERTICAL) ? R.layout.item_even_vertical: R.layout.item_even_horizontal;
                holder = new EvenViewHolder(inflater.inflate(layoutId, parent, false));
                break;
            case ODD:
                layoutId = (orientation == LinearLayout.VERTICAL) ? R.layout.item_odd_vertical: R.layout.item_odd_horizontal;
                holder = new OddViewHolder(inflater.inflate(layoutId, parent, false));
                break;
            case PRIME:
                layoutId = (orientation == LinearLayout.VERTICAL) ? R.layout.item_prime_vertical: R.layout.item_prime_horizontal;
                holder = new PrimeViewHolder(inflater.inflate(layoutId, parent, false));
                break;
        }
        return holder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        ViewHolder<String> viewHolder = (ViewHolder<String>) holder;
        viewHolder.setData(items.get(position));
    }

}
