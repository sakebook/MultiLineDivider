package com.sakebook.android.library.multilinedividersample.grid;

import android.view.View;
import android.widget.ImageView;

import com.sakebook.android.library.multilinedevider.divider.GridDivider;
import com.sakebook.android.library.multilinedividersample.R;
import com.sakebook.android.library.multilinedividersample.multiline.Number;

/**
 * Created by sakemotoshinya on 2017/05/21.
 */

public class GridFullBleedImageViewHolder extends ViewHolder<Number> implements GridDivider {

    private ImageView imageView;
    public GridFullBleedImageViewHolder(View itemView) {
        super(itemView);
        imageView = (ImageView) itemView.findViewById(R.id.image);
    }

    @Override
    void setData(Number number) {
        switch (number) {
            case EVEN:
                imageView.setImageResource(R.drawable.cat2);
                break;
            case ODD:
                imageView.setImageResource(R.drawable.cat3);
                break;
            case PRIME:
                imageView.setImageResource(R.drawable.cat1);
                break;
        }
    }

    @Override
    public int getPadding() {
        return itemView.getContext().getResources().getDimensionPixelSize(R.dimen.grid_padding);
    }

    @Override
    public boolean getFullBleed() {
        return true;
    }
}
