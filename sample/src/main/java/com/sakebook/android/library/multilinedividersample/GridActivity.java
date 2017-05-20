package com.sakebook.android.library.multilinedividersample;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.widget.LinearLayout;

import com.sakebook.android.library.multilinedevider.MultiLineDivider;
import com.sakebook.android.library.multilinedividersample.grid.RecyclerAdapter;
import com.sakebook.android.library.multilinedividersample.multiline.LayoutType;

import java.util.ArrayList;

/**
 * Created by sakemotoshinya on 2017/05/15.
 */

public class GridActivity extends AppCompatActivity {

    private final static String ORIENTATION = "orientation";
    private final static String LAYOUT_TYPE = "layout_type";

    public static Intent createIntent(Context context, LayoutType layoutType, int orientation) {
        Intent intent = new Intent(context, GridActivity.class);
        intent.putExtra(ORIENTATION, orientation);
        intent.putExtra(LAYOUT_TYPE, layoutType);
        return intent;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grid);
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
        RecyclerAdapter recyclerAdapter = new RecyclerAdapter(this, createData(), layoutType, orientation);
        recyclerView.setAdapter(recyclerAdapter);
    }

    private RecyclerView.LayoutManager createLayoutManager(LayoutType layoutType, int orientation) {
        switch (layoutType) {
            case LINEAR:
                return new LinearLayoutManager(this, orientation, false);
            case GRID:
                return new GridLayoutManager(this, 3, orientation, false);
            case STAGGERED:
                return new StaggeredGridLayoutManager(3, orientation);
        }
        throw new InternalError();
    }

    private ArrayList<Integer> createData() {
        String pie = "1415926535897932384626433832795028841971693993751058209749445923078164062862089986280348253421170679";
        String[] pieList = pie.split("");
        ArrayList<Integer> arrayList = new ArrayList<>();
        for (String s: pieList) {
            if ("".equals(s)) {
                continue;
            }
            arrayList.add(Integer.parseInt(s));
        }
        return arrayList;
    }
}
