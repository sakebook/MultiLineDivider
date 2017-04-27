package com.sakebook.android.library.multilinedividersample;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initLayout();
    }

    private void initLayout() {
        Button verticalButton = (Button) findViewById(R.id.button_vertical);
        verticalButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = ListActivity.createIntent(MainActivity.this, LinearLayout.VERTICAL);
                startActivity(intent);
            }
        });
        Button horizontalButton = (Button) findViewById(R.id.button_horizontal);
        horizontalButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = ListActivity.createIntent(MainActivity.this, LinearLayout.HORIZONTAL);
                startActivity(intent);
            }
        });
    }
}
