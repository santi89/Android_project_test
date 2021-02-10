package com.example.myserverconnection;

import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.snackbar.Snackbar;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collections;

public class activity_showdata extends AppCompatActivity {
    EditText edtname;
    TextView errortext;
    Button btnshow;
    ListView liss;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_showdata);


        errortext = findViewById(R.id.errortext);
        btnshow = findViewById(R.id.btsearch);
        edtname = findViewById(R.id.edtsearch);
        liss = findViewById(R.id.listsearch);


        btnshow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new Task().execute();
            }
        });
    }

    class Task extends AsyncTask<String, String, String> {

        ArrayAdapter adt=null;
        ArrayList<String> record = new ArrayList<String>();
        ArrayList<String> recordid = new ArrayList<String>();
        String error = "";
        String sql = "select * from employee";

        @Override
        protected String doInBackground(String... Strings) {
            try {
                Connection con = DBConnect.getConnection();
                Statement stm = con.createStatement();
                ResultSet rs = stm.executeQuery(sql);

//                if (con == null) {
//                    error = "can not connect..";
//                } else {
//                    error = "connect done";
//                }
                recordid.clear();
                record.clear();
                while (rs.next()) {
                    recordid.add(rs.getString("empid"));
                    record.add(rs.getString("empname"));

                    //record += rs.getString(1) + " " + rs.getString(2) + "\n";
                }
                rs.close();

            } catch (Exception e) {
                error = "Connection Fail";
                e.printStackTrace();
            }
            return error;
        }

        @Override
        protected void onPreExecute() {
            errortext.setText("loading");

        }

        @Override
        protected void onPostExecute(String s) {
            errortext.setText("loading connect");
            adt = new ArrayAdapter(getApplicationContext(), R.layout.activity_showlist, record);
            liss.setAdapter(adt);


        }
    }
}
