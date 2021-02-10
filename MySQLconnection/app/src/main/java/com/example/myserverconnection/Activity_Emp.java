package com.example.myserverconnection;

import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.sql.Connection;

public class Activity_Emp extends AppCompatActivity {
    TextView tvconnect;
    EditText txtid,txtname,txtemail,txtsalary;
    Button btnempsave,btnback;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_employee);

        tvconnect=findViewById(R.id.tvconnect);
        txtid=findViewById(R.id.txtid);
        txtname=findViewById(R.id.txtname);
        txtemail=findViewById(R.id.txtemail);
        txtsalary=findViewById(R.id.txtsalary);
        btnempsave=findViewById(R.id.btnempsave);
        btnback=findViewById(R.id.btnback);

        btnempsave.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
           new saveData().execute("");
            }
        });
    }

    private class saveData extends AsyncTask<String, String,String>{
        String msg = "";
        String id=txtid.getText().toString();
        String name=txtname.getText().toString();
        String email=txtemail.getText().toString();
        String salary=txtsalary.getText().toString();

        @Override
        protected void onPreExecute() {tvconnect.setText("done");
            super.onPreExecute();
        }

        @Override
        protected void onPostExecute(String s) {
            tvconnect.setText("save done");
            super.onPostExecute(s);
        }

        @Override
        protected String doInBackground(String... strings) {
            try {
                Connection con =DBConnect.getConnection();
                ModelEmployee emp=new ModelEmployee(con);
                emp.setEmpid(id);
                emp.setEmpname(name);
                emp.setEmpemail(email);
                emp.setEmpsalary(salary);
                int r=emp.InsertData();
                if (r>0){
                    msg="save data done";

                }else{
                    msg="save data fail";
                }
            }catch (Exception e){
                msg="save fail";
                e.printStackTrace();

            }

            return null;
        }
    }

}
