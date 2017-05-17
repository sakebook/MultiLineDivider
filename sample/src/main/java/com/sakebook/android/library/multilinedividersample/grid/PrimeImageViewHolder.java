package com.sakebook.android.library.multilinedividersample.grid;

import android.view.View;

import com.sakebook.android.library.multilinedevider.divider.GridDivider;
import com.sakebook.android.library.multilinedividersample.R;

/**
 * Created by sakemotoshinya on 2017/05/16.
 */

public class PrimeImageViewHolder extends ViewHolder<String> implements GridDivider{

    public PrimeImageViewHolder(View itemView) {
        super(itemView);
    }

    @Override
    void setData(String s) {

    }

    @Override
    public int getPadding() {
        return itemView.getContext().getResources().getDimensionPixelSize(R.dimen.small_margin);
    }

    @Override
    public int getColor() {
        return R.color.colorPrimaryDark;
    }

    @Override
    public boolean getFullBleed() {
        return false;
    }
}
