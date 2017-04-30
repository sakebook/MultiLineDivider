package com.sakebook.android.library.multilinedividersample.inset;

import android.support.v7.widget.RecyclerView;
import android.view.View;

/**
 * Created by sakemotoshinya on 2017/04/30.
 */

public abstract class ViewHolder<T> extends RecyclerView.ViewHolder {
    public ViewHolder(View itemView) {
        super(itemView);
    }

    abstract void setData(T t);
}
