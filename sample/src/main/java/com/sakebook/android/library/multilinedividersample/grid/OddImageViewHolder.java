package com.sakebook.android.library.multilinedividersample.grid;


import android.view.View;
import android.widget.ImageView;

import com.sakebook.android.library.multilinedevider.divider.GridDivider;
import com.sakebook.android.library.multilinedividersample.R;

/**
 * Created by sakemotoshinya on 2017/05/16.
 */

public class OddImageViewHolder extends ViewHolder<String> implements GridDivider{

    private ImageView imageView;
    public OddImageViewHolder(View itemView) {
        super(itemView);
        imageView = (ImageView) itemView.findViewById(R.id.image);
    }

    @Override
    void setData(String s) {
        imageView.setImageResource(R.drawable.cat3);
    }

    @Override
    public int getPadding() {
        return itemView.getContext().getResources().getDimensionPixelSize(R.dimen.small_margin);
    }

    @Override
    public int getColor() {
        return R.color.colorAccent;
    }

    @Override
    public boolean getFullBleed() {
        return false;
    }

}
