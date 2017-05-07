package com.sakebook.android.library.multilinedividersample.inset;

import android.content.res.Resources;
import android.support.v4.util.Pair;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.sakebook.android.library.multilinedevider.divider.VerticalDivider;
import com.sakebook.android.library.multilinedividersample.R;

import org.jetbrains.annotations.Nullable;

/**
 * Created by sakemotoshinya on 2017/04/30.
 */

public class LastViewHolder extends ViewHolder<Contact> implements VerticalDivider{

    private ImageView imageView;
    private TextView textView;
    private Resources resources;

    public LastViewHolder(View itemView) {
        super(itemView);
        imageView = (ImageView) itemView.findViewById(R.id.image);
        textView = (TextView) itemView.findViewById(R.id.text);
        resources = itemView.getContext().getResources();
    }

    @Override
    void setData(Contact contact) {
        textView.setText(contact.getName());
    }

    @Override
    public int getHeight() {
        return (int) resources.getDimension(R.dimen.tiny_margin);
    }

    @Override
    public int getDrawableRes() {
        return R.drawable.simple_divider;
    }

    @Nullable
    @Override
    public Pair<Integer, Integer> getVerticalInset() {
        int inset = (int) resources.getDimension(R.dimen.list_padding);
        return Pair.create(inset, 0);
    }
}
