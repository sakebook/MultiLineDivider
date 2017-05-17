package com.sakebook.android.library.multilinedividersample;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

import com.sakebook.android.library.multilinedividersample.multiline.LayoutType;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initLayout();
    }

    private void initLayout() {
        Button verticalLinearButton = (Button) findViewById(R.id.button_linear_vertical);
        verticalLinearButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = ListActivity.createIntent(MainActivity.this, LinearLayout.VERTICAL);
                startActivity(intent);
            }
        });
        Button horizontalLinearButton = (Button) findViewById(R.id.button_linear_horizontal);
        horizontalLinearButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = ListActivity.createIntent(MainActivity.this, LinearLayout.HORIZONTAL);
                startActivity(intent);
            }
        });
        Button verticalGridButton = (Button) findViewById(R.id.button_grid_vertical);
        verticalGridButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = GridActivity.createIntent(MainActivity.this, LayoutType.GRID, LinearLayout.VERTICAL);
                startActivity(intent);
            }
        });
        Button horizontalGridButton = (Button) findViewById(R.id.button_grid_horizontal);
        horizontalGridButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = GridActivity.createIntent(MainActivity.this, LayoutType.GRID, LinearLayout.HORIZONTAL);
                startActivity(intent);
            }
        });
        Button verticalStaggeredButton = (Button) findViewById(R.id.button_staggered_vertical);
        verticalStaggeredButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = GridActivity.createIntent(MainActivity.this, LayoutType.STAGGERED, LinearLayout.VERTICAL);
                startActivity(intent);
            }
        });
        Button horizontalStaggeredButton = (Button) findViewById(R.id.button_staggered_horizontal);
        horizontalStaggeredButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = GridActivity.createIntent(MainActivity.this, LayoutType.STAGGERED, LinearLayout.HORIZONTAL);
                startActivity(intent);
            }
        });
        Button contactButton = (Button) findViewById(R.id.button_contact);
        contactButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = ContactActivity.createIntent(MainActivity.this);
                startActivity(intent);
            }
        });
        Button ticketButton = (Button) findViewById(R.id.button_ticket);
        ticketButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = TicketActivity.createIntent(MainActivity.this);
                startActivity(intent);
            }
        });
    }
}
