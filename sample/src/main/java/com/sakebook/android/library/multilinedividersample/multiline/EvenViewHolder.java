package com.sakebook.android.library.multilinedividersample.multiline;

import android.view.View;
import android.widget.TextView;

import com.sakebook.android.library.multilinedevider.divider.NoDivider;
import com.sakebook.android.library.multilinedividersample.R;

/**
 * Created by sakemotoshinya on 2017/04/26.
 */

public class EvenViewHolder extends ViewHolder<String> implements NoDivider {

    private TextView textView;
    public EvenViewHolder(View itemView) {
        super(itemView);
        textView = (TextView) itemView.findViewById(R.id.text);
    }

    @Override
    void setData(String str) {
        textView.setText("Even: " + str);
    }
}
