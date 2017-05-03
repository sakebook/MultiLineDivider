package com.sakebook.android.library.multilinedividersample.dash;

import android.content.Context;
import android.content.res.Resources;
import android.support.v4.util.Pair;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.sakebook.android.library.multilinedevider.divider.VerticalDivider;
import com.sakebook.android.library.multilinedividersample.R;

import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;

/**
 * Created by sakemotoshinya on 2017/05/02.
 */

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private LayoutInflater inflater;
    private ArrayList<Ticket> items;

    public RecyclerAdapter(Context context, ArrayList<Ticket> items) {
        this.inflater = LayoutInflater.from(context);
        this.items = items;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new TicketViewHolder(inflater.inflate(R.layout.item_ticket, parent, false));
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        ((TicketViewHolder)holder).setData(items.get(position));
    }

    @Override
    public int getItemCount() {
        return items.size();
    }


    class TicketViewHolder extends RecyclerView.ViewHolder implements VerticalDivider{

        private TextView textTitle;
        private TextView textDescription;
        private Resources resources;

        public TicketViewHolder(View itemView) {
            super(itemView);
            textTitle = (TextView) itemView.findViewById(R.id.text_title);
            textDescription = (TextView) itemView.findViewById(R.id.text_description);
            resources = itemView.getContext().getResources();
        }

        void setData(Ticket ticket) {
            textTitle.setText(ticket.getTitle());
            textDescription.setText(ticket.getDescription());
        }

        @Override
        public int getHeight() {
            return (int) resources.getDimension(R.dimen.dash_height);
        }

        @Override
        public int getDrawableRes() {
            return R.drawable.dashed_line_divider;
        }

        @Nullable
        @Override
        public Pair<Integer, Integer> getVerticalInset() {
            int inset = (int) resources.getDimension(R.dimen.list_padding);
            return Pair.create(inset, inset);
        }
    }
}
