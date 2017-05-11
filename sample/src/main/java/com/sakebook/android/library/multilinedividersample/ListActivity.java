package com.sakebook.android.library.multilinedividersample;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.widget.LinearLayout;

import com.sakebook.android.library.multilinedevider.MultiLineDivider;
import com.sakebook.android.library.multilinedividersample.multiline.LayoutType;
import com.sakebook.android.library.multilinedividersample.multiline.RecyclerAdapter;

import java.util.ArrayList;

public class ListActivity extends AppCompatActivity {

    private final static String ORIENTATION = "orientation";
    private final static String LAYOUT_TYPE = "layout_type";
    public static Intent createIntent(Context context, LayoutType layoutType, int orientation) {
        Intent intent = new Intent(context, ListActivity.class);
        intent.putExtra(ORIENTATION, orientation);
        intent.putExtra(LAYOUT_TYPE, layoutType);
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
        LayoutType layoutType = (getIntent() != null) ? (LayoutType) getIntent().getSerializableExtra(LAYOUT_TYPE) : LayoutType.LINEAR;
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recycler_view);

        RecyclerView.LayoutManager layoutManager = createLayoutManager(layoutType, orientation);
        recyclerView.setLayoutManager(layoutManager);
        MultiLineDivider multiLineDivider = new MultiLineDivider(this, orientation);
        recyclerView.addItemDecoration(multiLineDivider);
        RecyclerAdapter recyclerAdapter = new RecyclerAdapter(this, createData(), orientation);
        recyclerView.setAdapter(recyclerAdapter);
    }

    private RecyclerView.LayoutManager createLayoutManager(LayoutType layoutType, int orientation) {
        switch (layoutType) {
            case LINEAR:
                return new LinearLayoutManager(this, orientation, false);
            case GRID:
                return new GridLayoutManager(this, 5, orientation, false);
            case STAGGERED:
                return new StaggeredGridLayoutManager(5, orientation);
        }
        throw new InternalError();
    }

    private ArrayList<String> createData() {
        ArrayList<String> arrayList = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            arrayList.add("title: " + i);
        }
        return arrayList;
    }
}
