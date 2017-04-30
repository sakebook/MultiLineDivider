package com.sakebook.android.library.multilinedividersample;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.LinearLayout;

import com.sakebook.android.library.multilinedevider.MultiLineDivider;
import com.sakebook.android.library.multilinedividersample.inset.Contact;
import com.sakebook.android.library.multilinedividersample.inset.RecyclerAdapter;

import java.util.ArrayList;

public class ContactActivity extends AppCompatActivity {

    public static Intent createIntent(Context context) {
        Intent intent = new Intent(context, ContactActivity.class);
        return intent;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact);
        initList();
    }

    private void initList() {
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this, LinearLayout.VERTICAL, false);
        recyclerView.setLayoutManager(layoutManager);
        MultiLineDivider multiLineDivider = new MultiLineDivider(this, LinearLayout.VERTICAL);
        recyclerView.addItemDecoration(multiLineDivider);
        RecyclerAdapter recyclerAdapter = new RecyclerAdapter(this, createFavoriteData(), createData());
        recyclerView.setAdapter(recyclerAdapter);
    }

    private ArrayList<Contact> createFavoriteData() {
        ArrayList<Contact> arrayList = new ArrayList<>();
        String[] names = getResources().getStringArray(R.array.favorite_contact_names);
        for (String name: names) {
            arrayList.add(new Contact(name, true));
        }
        return arrayList;
    }

    private ArrayList<Contact> createData() {
        ArrayList<Contact> arrayList = new ArrayList<>();
        String[] names = getResources().getStringArray(R.array.contact_names);
        for (String name: names) {
            arrayList.add(new Contact(name, false));
        }
        return arrayList;
    }
}
