package com.example.heath.myapplication;

import android.content.Intent;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class DisplayMessageActivity extends AppCompatActivity {

    public final static String EXTRA_MESSAGE = "com.heath.app.displayMessage.message";
    Intent intent = new Intent();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_message);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        Intent intent = getIntent();
        String message =  intent.getStringExtra(EXTRA_MESSAGE);
        TextView textView = new TextView(this);
        textView.setText(message);
        textView.setTextSize(40);
        ConstraintLayout layout = (ConstraintLayout) findViewById(R.id.content);
        layout.addView(textView);
    }

    /**
     * 开始加载
     */
    @Override
    protected void onStart() {
        super.onStart();
    }

    /**
     * 重新开始
     */
    @Override
    protected void onPause() {
        super.onPause();
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void onStop() {
        super.onStop();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }
}
