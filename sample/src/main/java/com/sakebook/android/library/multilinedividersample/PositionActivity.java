package com.sakebook.android.library.multilinedividersample;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.LinearLayout;

import com.sakebook.android.library.multilinedevider.MultiLineDivider;
import com.sakebook.android.library.multilinedividersample.position.RecyclerAdapter;

import java.util.ArrayList;

public class PositionActivity extends AppCompatActivity {

    private final static String ORIENTATION = "orientation";
    private final static String INVERTED = "inverted";

    public static Intent createIntent(Context context, boolean inverted, int orientation) {
        Intent intent = new Intent(context, PositionActivity.class);
        intent.putExtra(ORIENTATION, orientation);
        intent.putExtra(INVERTED, inverted);
        return intent;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_position);
        initList();
    }

    private void initList() {
        int orientation = (getIntent() != null) ? getIntent().getIntExtra(ORIENTATION, LinearLayout.VERTICAL) : LinearLayout.VERTICAL;
        boolean inverted = (getIntent() != null) && getIntent().getBooleanExtra(INVERTED, false);
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recycler_view);

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this, orientation, false);
        recyclerView.setLayoutManager(layoutManager);
        MultiLineDivider multiLineDivider = new MultiLineDivider(this, orientation);
        recyclerView.addItemDecoration(multiLineDivider);
        RecyclerAdapter recyclerAdapter = new RecyclerAdapter(this, createData(), inverted, orientation);
        recyclerView.setAdapter(recyclerAdapter);
    }

    private ArrayList<Integer> createData() {
        ArrayList<Integer> arrayList = new ArrayList<>();
        for (int i = 0; i < 50; i++) {
            arrayList.add(i);
        }
        return arrayList;
    }
}
