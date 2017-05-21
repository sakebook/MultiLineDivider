package com.sakebook.android.library.multilinedividersample;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.LinearLayout;

import com.sakebook.android.library.multilinedevider.MultiLineDivider;
import com.sakebook.android.library.multilinedividersample.multiline.RecyclerAdapter;

import java.util.ArrayList;

public class ListActivity extends AppCompatActivity {

    private final static String ORIENTATION = "orientation";

    public static Intent createIntent(Context context, int orientation) {
        Intent intent = new Intent(context, ListActivity.class);
        intent.putExtra(ORIENTATION, orientation);
        return intent;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);
        initList();
    }

    private void initList() {
        int orientation = (getIntent() != null) ? getIntent().getIntExtra(ORIENTATION, LinearLayout.VERTICAL) : LinearLayout.VERTICAL;
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recycler_view);

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this, orientation, false);
        recyclerView.setLayoutManager(layoutManager);
        MultiLineDivider multiLineDivider = new MultiLineDivider(this, orientation);
        recyclerView.addItemDecoration(multiLineDivider);
        RecyclerAdapter recyclerAdapter = new RecyclerAdapter(this, createData(), orientation);
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
