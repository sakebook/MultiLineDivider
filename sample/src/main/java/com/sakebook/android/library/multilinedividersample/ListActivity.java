package com.sakebook.android.library.multilinedividersample;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.sakebook.android.library.multilinedevider.MultiLineDivider;

import java.util.ArrayList;
import java.util.List;

public class ListActivity extends AppCompatActivity {

    public static Intent createIntent(Context context) {
        Intent intent = new Intent(context, ListActivity.class);
        return intent;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setLayout(getIntent());
        initList();
    }

    private void setLayout(@Nullable Intent intent) {
        if (intent == null) {
            setContentView(R.layout.activity_list);
            return;
        }
        setContentView(R.layout.activity_list);
    }

    private void initList() {
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(layoutManager);
        MultiLineDivider multiLineDivider = new MultiLineDivider(this, LinearLayoutManager.VERTICAL);
        recyclerView.addItemDecoration(multiLineDivider);
        RecyclerAdapter recyclerAdapter = new RecyclerAdapter(this, createData());
        recyclerView.setAdapter(recyclerAdapter);
    }

    private ArrayList<String> createData() {
        ArrayList<String> arrayList = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            arrayList.add("title: " + i);
        }
        return arrayList;
    }


}
