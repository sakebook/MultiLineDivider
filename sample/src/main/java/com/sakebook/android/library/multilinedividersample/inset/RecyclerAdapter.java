package com.sakebook.android.library.multilinedividersample.inset;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;


import com.sakebook.android.library.multilinedividersample.R;

import java.util.ArrayList;

import static com.sakebook.android.library.multilinedividersample.inset.RecyclerAdapter.ITEM_TYPE.First;
import static com.sakebook.android.library.multilinedividersample.inset.RecyclerAdapter.ITEM_TYPE.Last;
import static com.sakebook.android.library.multilinedividersample.inset.RecyclerAdapter.ITEM_TYPE.Other;

/**
 * Created by sakemotoshinya on 2017/04/30.
 */

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private LayoutInflater inflater;
    private ArrayList<Contact> favoriteItems;
    private ArrayList<Contact> items;

    enum ITEM_TYPE {
        First(0),
        Last(1),
        Other(2),
        ;

        ITEM_TYPE(int i) {}
    }

    public RecyclerAdapter(Context context, ArrayList<Contact> favoriteItems, ArrayList<Contact> items) {
        this.inflater = LayoutInflater.from(context);
        this.favoriteItems = favoriteItems;
        this.items = items;
    }

    @Override
    public int getItemViewType(int position) {
        Contact contact = getContact(position);
        return getType(contact).ordinal();
    }

    @Override
    public int getItemCount() {
        return favoriteItems.size() + items.size();
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        ViewHolder<Contact> holder = null;
        switch (viewType) {
            case 0:
                holder = new FirstViewHolder(inflater.inflate(R.layout.item_contact, parent, false));
                break;
            case 1:
                holder = new LastViewHolder(inflater.inflate(R.layout.item_contact, parent, false));
                break;
            default:
                holder = new OtherViewHolder(inflater.inflate(R.layout.item_contact, parent, false));
                break;
        }
        return holder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        ViewHolder<Contact> viewHolder = (ViewHolder<Contact>) holder;
        viewHolder.setData(getContact(position));
    }

    private Contact getContact(int position) {
        Contact contact;
        if (favoriteItems.size() > position) {
            contact = favoriteItems.get(position);
        } else {
            contact = items.get(position - favoriteItems.size());
        }
        return contact;
    }

    private ITEM_TYPE getType(Contact contact) {
        ArrayList<Contact> targetList;
        if (contact.isFavorite()) {
            targetList = favoriteItems;
        } else {
            targetList = items;
        }

        int index = targetList.indexOf(contact);
        if (index == 0) {
            // first
            return First;
        } else if (index == targetList.size() - 1) {
            // last
            return Last;
        } else {
            return Other;
        }
    }
}
