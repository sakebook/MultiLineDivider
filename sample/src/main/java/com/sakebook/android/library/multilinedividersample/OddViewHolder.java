package com.sakebook.android.library.multilinedividersample;

import android.view.View;
import android.widget.TextView;

import com.sakebook.android.library.multilinedevider.divider.NoDivider;

/**
 * Created by sakemotoshinya on 2017/04/25.
 */

public class OddViewHolder extends ViewHolder<String> {

    private TextView textView;
    public OddViewHolder(View itemView) {
        super(itemView);
        textView = (TextView) itemView.findViewById(R.id.text);
    }

    @Override
    void setData(String str) {
        textView.setText(str);
   }
}
