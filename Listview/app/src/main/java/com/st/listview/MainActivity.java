package com.st.listview;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
String [] arr={"Laos","Brunei Darusalam"," Cambodia","Indonesia","Malasia","Myanmar","Philippines","Singapore","Thailand","Vientnam","TiMorlestay"};
ListView lst;
ArrayAdapter adpt=null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        lst=findViewById(R.id.lstitem);
        Context context;
//        adpt=new ArrayAdapter(this,android.R.layout.simple_list_item_1,arr);
       // adpt=new ArrayAdapter(this,R.layout.layoutlist,R.id.tv1,arr);

        myAdapter myadpt=new myAdapter(MainActivity.this,arr,arr,arr);
        lst.setAdapter(myadpt);
        lst.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String str =arr[position].toString();
                Toast.makeText(getApplicationContext(),str,Toast.LENGTH_SHORT).show();
            }
        });
    }
}
