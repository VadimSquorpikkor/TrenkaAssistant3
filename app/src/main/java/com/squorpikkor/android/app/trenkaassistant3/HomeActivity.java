package com.squorpikkor.android.app.trenkaassistant3;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.QuickContactBadge;

import java.util.ArrayList;

public class HomeActivity extends AppCompatActivity {

    ArrayList<String> trenkaList = new ArrayList<>();
    ArrayList<String> strList = new ArrayList<>();
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        ListView trenkaListView = (ListView)findViewById(R.id.trenkaListView);

        final ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, strList);

        trenkaListView.setAdapter(adapter);

        button = (Button)findViewById(R.id.addItem);

        View.OnClickListener listener = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switch (view.getId()) {
                    case R.id.addItem:
                        strList.add("newItem");
                        adapter.notifyDataSetChanged();
                        break;
                }
            }
        };

        button.setOnClickListener(listener);

    }
}
