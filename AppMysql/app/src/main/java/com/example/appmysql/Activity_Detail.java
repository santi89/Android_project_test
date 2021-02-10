package com.example.appmysql;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.security.cert.Extension;
import java.sql.*;
public class Activity_Detail extends AppCompatActivity {
    TextView tvdetail;
    EditText txtid,txtname,txtsurname,txttel;
    Button btnedit,btndelete,btnback;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_detail);
        initail();
        new getData().execute("");

        btnback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Activity_Detail.this,Activity_showData.class);
                Activity_Detail.this.finish();
                startActivity(intent);
            }
        });
        btndelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new deletedata().execute("");
                Intent intent=new Intent(Activity_Detail.this,Activity_showData.class);
                Activity_Detail.this.finish();
                startActivity(intent);
            }
        });
        btnedit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new EditData().execute("");
                Intent intent=new Intent(Activity_Detail.this,Activity_showData.class);
                Activity_Detail.this.finish();
                startActivity(intent);
            }
        });

    }

    private void initail() {
        tvdetail =findViewById(R.id.tvdetailconnect);
        txtid =findViewById(R.id.txtdetailid);
        txtname =findViewById(R.id.txtdetailname);
        txtsurname =findViewById(R.id.txtdetaillastname);
        txttel =findViewById(R.id.txtdetailtel);
        btnedit =findViewById(R.id.btndetailempsave);
        btndelete =findViewById(R.id.btndetaildelete);
        btnback =findViewById(R.id.btndetailback);


    }
    private class deletedata extends AsyncTask<String,String,String>{
        String smg="";
        String id =txtid.getText().toString();

        @Override
        protected void onPreExecute() {
            tvdetail.setText("Connecting database....");
        }

        @Override
        protected String doInBackground(String... strings) {
            try {
                Connection c =DBConnect.getConnect();
                modelemployee emp =new modelemployee(c);
                emp.setEmpid(id);
                int r =emp.DeleteData();
                if(r>0){
                    smg="deleet data complete..";
                }else{
                    smg="Delete data fail...";
                }

            }catch (Exception ex){
                ex.printStackTrace();
                smg="Delete data fail...";
            }
            return smg;
        }

        @Override
        protected void onPostExecute(String s) {
            tvdetail.setText(s);
            txtid.setText("");
            txtname.setText("");
            txtsurname.setText("");
            txttel.setText("");
            txtid.requestFocus();
        }
    }
    private class EditData extends AsyncTask<String,String,String>{
        String smg="";
        String id =txtid.getText().toString();
        String name =txtname.getText().toString();
        String surname=txtsurname.getText().toString();
        String tel =txttel.getText().toString();
        @Override
        protected void onPreExecute() {
            tvdetail.setText("Connecting database....");

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
                int r =emp.UpdateData();
                if(r>0){
                    smg="Edit data complete...";
                }else{
                    smg="Edit data Fail...";
                }


            }catch (Exception ex){
                smg="Editing data fail...";
                ex.printStackTrace();
            }

            return smg;
        }

        @Override
        protected void onPostExecute(String s) {
            tvdetail.setText(s);
            txtid.setText("");
            txtname.setText("");
            txtsurname.setText("");
            txttel.setText("");
            txtid.requestFocus();
        }
    }

    private class getData extends AsyncTask<String,String,String>{
        String smg="";
        String id="";
        String name="";
        String surname="";
        String tel="";

        @Override
        protected void onPreExecute() {
           tvdetail.setText("Connecting database....");
        }

        @Override
        protected String doInBackground(String... strings) {
            try {
                Connection c =DBConnect.getConnect();
                modelemployee emp=new modelemployee(c);
                Bundle bun =getIntent().getExtras();
                id =bun.getString("empid");
                emp.setEmpid(id);
                ResultSet rs =emp.SelectDatabyVal();
                rs.next();
                name=rs.getString("Name");
                surname=rs.getString("LastName");
                tel =rs.getString("Tel");

                rs.close();
             smg="Loading data done...";
            }catch (Exception ex){
                smg="Editing fail...";
            }

            return smg;
        }

        @Override
        protected void onPostExecute(String s) {
            tvdetail.setText(s);
            txtid.setText(id);
            txtname.setText(name);
            txtsurname.setText(surname);
            txttel.setText(tel);

        }
    }
}
