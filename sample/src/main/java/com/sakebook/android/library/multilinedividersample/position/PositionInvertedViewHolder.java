package com.sakebook.android.library.multilinedividersample.position;

import android.view.View;
import android.widget.TextView;

import com.sakebook.android.library.multilinedevider.divider.PositionDivider;
import com.sakebook.android.library.multilinedividersample.R;

import org.jetbrains.annotations.NotNull;

import java.util.Arrays;
import java.util.List;

/**
 * Created by sakemotoshinya on 2017/05/21.
 */

public class PositionInvertedViewHolder extends ViewHolder<Integer> implements PositionDivider {

    private TextView textView;
    public PositionInvertedViewHolder(View itemView) {
        super(itemView);
        textView = (TextView) itemView.findViewById(R.id.text);
    }

    @Override
    void setData(Integer integer) {
        textView.setText("Position: " + integer);
    }

    @NotNull
    @Override
    public List<Integer> getPositions() {
        return Arrays.asList(3, 4, 6, 9);
    }

    @Override
    public boolean getInverted() {
        return true;
    }
}
