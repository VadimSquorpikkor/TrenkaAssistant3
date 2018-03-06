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
import android.widget.TextView;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class _HomeActivity extends AppCompatActivity {

    private static final String COUNT_PREF_NAME = "countPrefName";
    private static final String STR_LIST_PREF_NAME = "strListPrefName";
    private static final String TRENKA_LIST_PREF_NAME = "trenkaListPrefName";
    /**
     * Возможно нет необходимости создавать в клвссе Trenka метод load()
     * загрузка будет происходить так -- в методе HomeActivity из списка тренкаЛист будут браться стринги,
     * которые в активити тренька будут использоваться как имена для SharedPref
     ****/

    ArrayList<String> trenkaList = new ArrayList<>();
    ArrayList<String> strList = new ArrayList<>();
    Button button;
    //String nameForNew;
    ArrayAdapter<String> adapter;
    int count;//счетчик для преференсов, нужно будет сохранять значение
    SaveLoad saveLoad;
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        saveLoad = new SaveLoad(this);

        ListView trenkaListView = (ListView) findViewById(R.id.trenkaListView);

        adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, strList);

        trenkaListView.setAdapter(adapter);

        button = (Button) findViewById(R.id.addItem);
        textView = (TextView)findViewById(R.id.textForCount);

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
        trenkaListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View v, int position, long id) {
                //openTrenkaActivity(trenkaList.get(position));

                ///**Имя для ShPref создается по имени порядкового номера элемента --
                // * это нужно для того, чтобы исключить одинаковые имена.
                 //* Изначально я сделал имя как имя элемента плюс позицию -- так тоже исключаются одинаковые имена,
                 ///* но при этом нужно придумывать механизм удаления ненужных элементов,
                 //* так элементы будут ***/
                /***Нужно давать имена по счетчику (счетчик придется тоже сохранять, и еще нужно придумывать,
                 * как удалять ненужные элементы -- файлы , которые остались после удаленных элементов лист вью)
                 *
                 * ***/
                //openTrenkaActivity(strList.get(position) + "_" + position);

                //openTrenkaActivity(count + "_" + "prefName");
                //openTrenkaActivity(strList.get(position));
                openTrenkaActivity(trenkaList.get(position));

            }
        });


        loadStrList();
        loadCount();
        loadTrenkaList();

        textView.setText("eee");


    }

    void saveCount() {
        saveLoad.saveInteger(count, COUNT_PREF_NAME);
    }

    private void loadCount() {
        count = saveLoad.loadInteger(COUNT_PREF_NAME);
    }

    void saveStrList() {
        saveLoad.saveStringArray(strList, STR_LIST_PREF_NAME);
    }

    private void loadStrList() {
        //strList.addAll(saveLoad.loadStringArray(STR_LIST_PREF_NAME));
        strList.add("delete");
        //strList = saveLoad.loadStringArray(STR_LIST_PREF_NAME);
        adapter.notifyDataSetChanged();
    }

    void saveTrenkaList() {
        saveLoad.saveStringArray(trenkaList, TRENKA_LIST_PREF_NAME);
    }

    private void loadTrenkaList() {
        trenkaList.addAll(saveLoad.loadStringArray(TRENKA_LIST_PREF_NAME));
        adapter.notifyDataSetChanged();
    }

    private void openTrenkaActivity(String SharePrefName) {
        /** Открыть активити "Тренька и передать в параметре Стринг -- имя для SharedPref,
         * по которому будут загружены данныю для Тренька активити" ***/
        Intent intent = new Intent(this, _TrenkaActivity.class);
        intent.putExtra("value", SharePrefName);
        startActivity(intent);


    }

    /**Надо будет попеределать нормально метод***/
    String newDate() {
        Calendar cal = Calendar.getInstance();
        Date currentDate = cal.getTime();

        DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        DateFormat formatter2 = DateFormat.getDateInstance();

        //String formattedDateString = formatter.format(currentDate);
        String formattedDateString = formatter2.format(currentDate);
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
                //nameForNew = input.getText().toString().trim();

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
        count++;
        strList.add(count + ":" + date);
        trenkaList.add(String.valueOf(count));
        adapter.notifyDataSetChanged();

        saveStrList();
        saveCount();
        saveTrenkaList();

    }
}
