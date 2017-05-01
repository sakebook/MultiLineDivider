package com.sakebook.android.library.multilinedividersample;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.LinearLayout;

import com.sakebook.android.library.multilinedevider.MultiLineDivider;
import com.sakebook.android.library.multilinedividersample.dash.RecyclerAdapter;
import com.sakebook.android.library.multilinedividersample.dash.Ticket;
import com.sakebook.android.library.multilinedividersample.inset.Contact;

import java.util.ArrayList;

public class TicketActivity extends AppCompatActivity {

    public static Intent createIntent(Context context) {
        Intent intent = new Intent(context, TicketActivity.class);
        return intent;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ticket);
        initList();
    }

    private void initList() {
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this, LinearLayout.VERTICAL, false);
        recyclerView.setLayoutManager(layoutManager);
        MultiLineDivider multiLineDivider = new MultiLineDivider(this, LinearLayout.VERTICAL);
        recyclerView.addItemDecoration(multiLineDivider);
        RecyclerAdapter recyclerAdapter = new RecyclerAdapter(this, createTicket());
        recyclerView.setAdapter(recyclerAdapter);
    }

    private ArrayList<Ticket> createTicket() {
        ArrayList<Ticket> arrayList = new ArrayList<>();
        String[] titles = getResources().getStringArray(R.array.ticket_titles);
        String[] descriptions = getResources().getStringArray(R.array.ticket_descriptions);
        int length = titles.length;
        for (int i = 0; i < length; i++) {
            arrayList.add(new Ticket(titles[i], descriptions[i], 0));
        }
        return arrayList;
    }

}
