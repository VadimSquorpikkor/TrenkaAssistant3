package com.squorpikkor.android.app.trenkaassistant3;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.InputType;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.QuickContactBadge;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class _HomeActivity extends AppCompatActivity {

    ArrayList<String> trenkaList = new ArrayList<>();
    ArrayList<String> strList = new ArrayList<>();
    Button button;
    String nameForNew;
    ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        ListView trenkaListView = (ListView)findViewById(R.id.trenkaListView);

        adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, strList);

        trenkaListView.setAdapter(adapter);

        button = (Button)findViewById(R.id.addItem);

        View.OnClickListener listener = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switch (view.getId()) {
                    case R.id.addItem:
                        addNewAlert();
                        break;
                }
            }
        };

        button.setOnClickListener(listener);

        /** Лисенер для элементов лист вью ***/
        trenkaListView.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?> parent, View v, int position, long id)
            {
                openTrenkaActivity(trenkaList.get(position));
            }
        });

    }

    private void openTrenkaActivity(String SharePrefName) {
        /** Открыть активити "Тренька и передать в параметре Стринг -- имя для SharedPref,
         * по которому будут загружены данныю для Тренька активити" ***/
            Intent intent = new Intent(this, _TrenkaActivity.class);
            intent.putExtra("value", SharePrefName);
            startActivity(intent);


    }

    String newDate() {
        Calendar cal = Calendar.getInstance();
        Date currentDate = cal.getTime();

        DateFormat formatter = new SimpleDateFormat("MM/dd/yyyy");
        String formattedDateString = formatter.format(currentDate);
        return formattedDateString;
    }

    void addNewAlert() {
        final AlertDialog.Builder alert = new AlertDialog.Builder(this);
        final EditText input = new EditText(this);
        alert.setMessage("Новая тренировка");
        input.setText(newDate());

        alert.setView(input);
        alert.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int whichButton) {
                nameForNew = input.getText().toString().trim();

                createNewTrenka(input.getText().toString());
            }
        });

        alert.setNegativeButton(R.string.cancel, new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int whichButton) {
                dialog.cancel();
            }
        });

        alert.show();
    }

    private void createNewTrenka(String date) {
        strList.add(date);
        adapter.notifyDataSetChanged();
        trenkaList.add(date+"trenka");

    }
}
