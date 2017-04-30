package com.sakebook.android.library.multilinedividersample.multiline;

import android.view.View;
import android.widget.TextView;

import com.sakebook.android.library.multilinedevider.divider.HorizontalDivider;
import com.sakebook.android.library.multilinedevider.divider.VerticalDivider;
import com.sakebook.android.library.multilinedividersample.R;

/**
 * Created by sakemotoshinya on 2017/04/25.
 */

public class OddViewHolder extends ViewHolder<String> implements VerticalDivider, HorizontalDivider{

    private TextView textView;
    public OddViewHolder(View itemView) {
        super(itemView);
        textView = (TextView) itemView.findViewById(R.id.text);
    }

    @Override
    void setData(String str) {
        textView.setText("Odd: " + str);
   }

    @Override
    public int getHeight() {
        return this.itemView.getContext().getResources().getDimensionPixelSize(R.dimen.small_margin);
    }

    @Override
    public int getDrawableRes() {
        return R.drawable.custom_divider;
    }

    @Override
    public int getWidth() {
        return this.itemView.getContext().getResources().getDimensionPixelSize(R.dimen.small_margin);
    }
}
