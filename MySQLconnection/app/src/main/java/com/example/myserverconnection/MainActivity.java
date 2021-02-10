package com.example.myserverconnection;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;


public class MainActivity extends AppCompatActivity {
Button btselect,btinsert,btdelete,btupdate;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initail();
        btselect.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
           Intent intent=new Intent(MainActivity.this,activity_showdata.class);
           startActivity(intent);
            }
        });

    }
    
    public void initail(){
        btselect= (Button)findViewById(R.id.btselect);
        btdelete= (Button)findViewById(R.id.btdelete);
        btinsert= (Button)findViewById(R.id.btinsert);
        btupdate= (Button)findViewById(R.id.btupdate);
    }
}