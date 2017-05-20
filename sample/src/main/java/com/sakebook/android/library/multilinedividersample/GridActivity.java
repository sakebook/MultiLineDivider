package com.sakebook.android.library.multilinedividersample;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.LinearLayout;

import com.sakebook.android.library.multilinedevider.MultiLineDivider;
import com.sakebook.android.library.multilinedividersample.grid.RecyclerAdapter;

import java.util.ArrayList;

/**
 * Created by sakemotoshinya on 2017/05/15.
 */

public class GridActivity extends AppCompatActivity {

    private final static String ORIENTATION = "orientation";
    private final static String FULL_BLEED = "full_bleed";

    public static Intent createIntent(Context context, boolean isFullBleed, int orientation) {
        Intent intent = new Intent(context, GridActivity.class);
        intent.putExtra(ORIENTATION, orientation);
        intent.putExtra(FULL_BLEED, isFullBleed);
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
        boolean isFullBleed = (getIntent() != null) && getIntent().getBooleanExtra(FULL_BLEED, false);
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        int spanCount = 2;
        if (orientation == LinearLayout.HORIZONTAL) {
            spanCount = 3;
        }
        if (isFullBleed) {
            recyclerView.setBackgroundColor(Color.BLACK);
        }
        RecyclerView.LayoutManager layoutManager = new GridLayoutManager(this, spanCount, orientation, false);
        recyclerView.setLayoutManager(layoutManager);
        MultiLineDivider multiLineDivider = new MultiLineDivider(this, orientation);
        recyclerView.addItemDecoration(multiLineDivider);
        RecyclerAdapter recyclerAdapter = new RecyclerAdapter(this, createData(), isFullBleed, orientation);
        recyclerView.setAdapter(recyclerAdapter);
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
