package com.sakebook.android.library.multilinedividersample.inset;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.sakebook.android.library.multilinedevider.divider.NoDivider;
import com.sakebook.android.library.multilinedividersample.R;

/**
 * Created by sakemotoshinya on 2017/04/30.
 */

public class FirstViewHolder extends ViewHolder<Contact> implements NoDivider{

    private ImageView imageView;
    private TextView textView;

    public FirstViewHolder(View itemView) {
        super(itemView);
        imageView = (ImageView) itemView.findViewById(R.id.image);
        textView = (TextView) itemView.findViewById(R.id.text);
    }

    @Override
    void setData(Contact contact) {
        if (contact.isFavorite()) {
            imageView.setImageResource(R.drawable.ic_star_24dp);
        } else {
            imageView.setImageResource(R.drawable.ic_account_circle_24dp);
        }
        textView.setText(contact.getName());
    }
}
