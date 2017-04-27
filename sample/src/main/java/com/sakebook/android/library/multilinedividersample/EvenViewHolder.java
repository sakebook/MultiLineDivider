package com.sakebook.android.library.multilinedividersample;

import android.view.View;
import android.widget.TextView;

/**
 * Created by sakemotoshinya on 2017/04/26.
 */

public class EvenViewHolder extends ViewHolder<String> {

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
