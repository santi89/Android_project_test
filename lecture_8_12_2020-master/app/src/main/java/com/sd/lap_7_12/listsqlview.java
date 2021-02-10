package com.sd.lap_7_12;

import android.database.Cursor;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

import androidx.appcompat.app.AppCompatActivity;

public class listsqlview extends AppCompatActivity {
    ArrayList<String> arrname = new ArrayList<String>();
    ArrayList<String> arrid = new ArrayList<String>();
    ListView listViewsql;
    ArrayAdapter arrayAdapter;

    protected void onCreate(Bundle savedInstanceStateBundle) {

        super.onCreate(savedInstanceStateBundle);
        setContentView(R.layout.listview);


        listViewsql = findViewById(R.id.listsql);

        DataBaseHelper mydb = new DataBaseHelper(this);
        Cursor cursor = mydb.viewdata();
        arrname.clear();
        arrid.clear();

        if (cursor != null) {
            if (cursor.moveToFirst()) {
                do {
                    arrid.add(cursor.getString(0));
                    arrname.add(cursor.getString(1));
                } while (cursor.moveToNext());
            }
        }
        cursor.close();
        arrayAdapter=new ArrayAdapter(getApplicationContext(),android.R.layout.simple_list_item_1,arrname);
        listViewsql.setAdapter(arrayAdapter);
    }
}
