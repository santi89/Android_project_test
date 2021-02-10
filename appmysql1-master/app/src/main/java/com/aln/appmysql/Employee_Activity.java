package com.aln.appmysql;

import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.sql.*;

public class Employee_Activity extends AppCompatActivity {
    TextView tvconn;
    EditText txtid, txtname, txtemail, txtsalary;
    Button btnempsave, btnback;
    Connection c = DBConnect.getConnect();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_employee);


        initial();
        final modelemployee emp = new modelemployee(c);
        new myData().execute("");
        btnempsave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {

                    emp.setEmpid(txtid.getText().toString());
                    emp.setEmpname(txtname.getText().toString());
                    emp.setEmpemail(txtemail.getText().toString());
                    emp.setSalary(Integer.parseInt(txtsalary.getText().toString()));
                } catch (Exception e) {
                    e.printStackTrace();
                }

            }
        });
    }

    private void initial() {
        tvconn = findViewById(R.id.tvconnect);
        txtid = findViewById(R.id.txtempid);
        txtname = findViewById(R.id.txtempname);
        txtemail = findViewById(R.id.txtempemail);
        txtsalary = findViewById(R.id.txtempsalary);
        btnempsave = findViewById(R.id.btnempsave);
        btnback = findViewById(R.id.btback);
    }

    private class myData extends AsyncTask<String, String, String> {
        String smg = "";

        @Override
        protected void onPreExecute() {
            tvconn.setText("Please wait connecting.....");
        }

        @Override
        protected String doInBackground(String... strings) {
            try {
                Connection c = DBConnect.getConnect();
                if (c == null) {
                    smg = "fail.......";
                } else {
                    smg = "done......";
                }


            } catch (Exception ex) {
                smg = "Connection Fail...";
                ex.printStackTrace();
            }

            return smg;
        }

        private class savedata extends AsyncTask<String, String, String> {
            String msg = "";
            String empid = txtid.getText().toString();
            String empname = txtname.getText().toString();
            String salary = txtsalary.getText().toString();
            String empemail = txtemail.getText().toString();

            protected void onPostExecute() {
                tvconn.setText("please wait for save data");
            }

            @Override
            protected String doInBackground(String... strings) {
                try {
                    Connection c = DBConnect.getConnect();
                    modelemployee emp = new modelemployee(c);
                    emp.setEmpid(empid);
                    emp.setEmpname(empname);
                    emp.setEmpemail(empemail);
                    emp.setSalary(Integer.parseInt(salary));

                } catch (Exception ex) {

                }
                return null;
            }
        }

        @Override
        protected void onPostExecute(String s) {
            tvconn.setText(s);
        }
    }
}
