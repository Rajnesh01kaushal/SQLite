package com.example.hp.solite;

import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class SecondActivity extends AppCompatActivity {

    private ListView listView;
    private DBClass dbClass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        listView = findViewById(R.id.listView);
        dbClass = new DBClass(this);
        Cursor cursor = dbClass.getData();

        getAllUser();

        final ArrayList<String>arrayList = new ArrayList<>();

        if(cursor.moveToFirst()) {
            do {
                String name = cursor.getString(cursor.getColumnIndex("Name"));
                String password = cursor.getString(cursor.getColumnIndex("Password"));
                String nunber = cursor.getString(cursor.getColumnIndex("Number"));
                String type = cursor.getString(cursor.getColumnIndex("Type"));

                String totalData = name + "\n" + password + "\n" + nunber + "\n" + type;
                arrayList.add(totalData);

            } while (cursor.moveToFirst());
        }

        ArrayAdapter arrayAdapter = new ArrayAdapter(this,android.R.layout.simple_dropdown_item_1line,arrayList);
        listView.setAdapter(arrayAdapter);


        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {

        String data = arrayList.get(position);
        String[] arr = data.split("\n");
        String name = arr[0];

        dbClass.onDelete(name);
        getAllUser();

    }
});


    }
    private  void getAllUser(){
        Cursor cursor = dbClass.getData();
    }
}
