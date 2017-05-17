package com.sakebook.android.library.multilinedividersample.grid;

import android.support.v7.widget.RecyclerView;
import android.view.View;

/**
 * Created by sakemotoshinya on 2017/05/16.
 */

public abstract class ViewHolder<T> extends RecyclerView.ViewHolder {
    public ViewHolder(View itemView) {
        super(itemView);
    }

    abstract void setData(T t);
}

