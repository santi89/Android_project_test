package com.example.appmysql;
import  java.sql.*;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import org.w3c.dom.Text;

public class Employee_Activity extends AppCompatActivity {
    TextView tvconnect;
    EditText txtid,txtname,txtlastname,txttel;
    Button btnempsave,btnempback;
    Connection c=DBConnect.getConnect();
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_employee);

        initial();
        new myData().execute("");

        btnempsave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new saveData().execute("");
            }
        });
    }
   
    private void initial() {
        tvconnect=findViewById(R.id.tvconnect);
        txtid=findViewById(R.id.txtid);
        txtname=findViewById(R.id.txtname);
        txtlastname=findViewById(R.id.txtlastname);
        txttel=findViewById(R.id.txttel);
        btnempsave=findViewById(R.id.btnempsave);
        btnempback=findViewById(R.id.btnback);
    }
    private class saveData extends AsyncTask<String,String,String>{
        String msg="";
        String id =txtid.getText().toString();
        String name =txtname.getText().toString();
        String surname=txtlastname.getText().toString();
        String tel=txttel.getText().toString();

        @Override
        protected void onPreExecute() {
            tvconnect.setText("please wait connect...");
        }

        @Override
        protected String doInBackground(String... strings) {
            try {
                Connection c =DBConnect.getConnect();
                modelemployee emp =new modelemployee(c);
                emp.setEmpid(id);
                emp.setEmpName(name);
                emp.setLastname(surname);
                emp.setTel(tel);
                int r =emp.InsertData();
                if(r>0){
                    msg="Save data done....";

                }else{
                    msg="Save data fail...";
                }


            }catch (Exception ex){
                msg="Save data fail...";
                ex.printStackTrace();
            }
            return msg;
        }

        @Override
        protected void onPostExecute(String s) {
            tvconnect.setText("Save data done....");
            }
        }

    private class myData extends AsyncTask<String,String,String>{
        String smg="";
        @Override
        protected void onPreExecute() {
            tvconnect.setText("Please Wait Connecting");
        }

        @Override
        protected void onPostExecute(String s) {
            tvconnect.setText(s);
        }

        @Override
        protected String doInBackground(String... strings) {
            try {
                Connection c= DBConnect.getConnect();
                if(c==null){
                    smg="Connection Fail";
                }else{
                    smg="Connection Done";
                }

            }catch (Exception ex){
                smg="Connection Fail";
                ex.printStackTrace();
            }
            return  smg;
        }
    }
}

