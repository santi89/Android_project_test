package com.example.appmysql;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.sql.*;
import java.util.ArrayList;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class Activity_showData extends AppCompatActivity {
    ListView lstv;
    TextView tvstate;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_showdata);


        lstv=findViewById(R.id.lstv);
        tvstate =findViewById(R.id.tvshowloaddata);
      new showdata().execute("");

    }
    private class showdata extends AsyncTask<String,String,String>{
        String msg="";
        ArrayList<String> arrid =new ArrayList<String>();
        ArrayList<String> arrname =new ArrayList<String>();
        ArrayAdapter adpt =null;

        @Override
        protected void onPreExecute() {
            tvstate.setText("Loading data.....");
        }

        @Override
        protected String doInBackground(String... strings) {
            try {
                Connection c =DBConnect.getConnect();
                modelemployee emp =new modelemployee(c);
                ResultSet rs =emp.SelectData();

                arrid.clear();
                arrname.clear();
                while(rs.next()){
                    arrid.add(rs.getString("empid"));
                    arrname.add(rs.getString("empname"));
                }
                rs.close();


            }catch (Exception ex){
                msg="Loading data fail...";
                ex.printStackTrace();
            }

            return msg;
        }

        @Override
        protected void onPostExecute(String s) {
            tvstate.setText("Loading done.....");
            adpt =new ArrayAdapter(getApplicationContext(),R.layout.layout_showtext,arrname);
            lstv.setAdapter(adpt);
//            if click data on listview
            lstv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    String str=arrid.get(position).toString();
                    Intent obj =new Intent(Activity_showData.this,Activity_Detail.class);
                    obj.putExtra("empid",str);
                    Activity_showData.this.finish();
                    startActivity(obj);

                   // tvstate.setText(str);
                }
            });
        }
    }

}
