package com.sakebook.android.library.multilinedividersample.inset;

import android.content.res.Resources;
import android.support.v4.util.Pair;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.sakebook.android.library.multilinedevider.divider.PositionDivider;
import com.sakebook.android.library.multilinedevider.divider.VerticalDivider;
import com.sakebook.android.library.multilinedividersample.R;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.Arrays;
import java.util.List;

/**
 * Created by sakemotoshinya on 2017/04/30.
 */

public class OtherViewHolder extends ViewHolder<Contact> implements VerticalDivider, PositionDivider{

    private ImageView imageView;
    private TextView textView;
    private Resources resources;

    public OtherViewHolder(View itemView) {
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

    @NotNull
    @Override
    public List<Integer> getPositions() {
        return Arrays.asList(3, 8);
    }

    @Override
    public boolean getInverted() {
        return false;
    }
}
