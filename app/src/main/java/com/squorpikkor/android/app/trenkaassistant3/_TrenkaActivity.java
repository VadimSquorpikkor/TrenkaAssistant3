package com.squorpikkor.android.app.trenkaassistant3;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class _TrenkaActivity extends AppCompatActivity {

    public static final String EXTRA_MESSAGE = "value";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_trenka);


        TextView text = (TextView) findViewById(R.id.text);
        text.setText(getIntent().getStringExtra(EXTRA_MESSAGE));
    }
}
