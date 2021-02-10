package com.example.testlab;

import androidx.appcompat.app.AppCompatActivity;


import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    EditText txtuser, txtoldpass, txtnewpass, txtnewcfpass;
    TextView tt;
    Button btnok,btnsave;
    SQLiteDatabase db;
    DataBaseHelper mydb = new DataBaseHelper(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mydb.getWritableDatabase();
        txtuser = findViewById(R.id.txtuser);
        txtoldpass = findViewById(R.id.txtoldpass);
        tt=findViewById(R.id.register);
        btnok = findViewById(R.id.btnok);
        btnsave = findViewById(R.id.btnsave);
        btnsave.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
//                long r = mydb.insertData(txtuser.getText().toString(),txtnewpass.getText().toString());
//                if (r > 0) {
////                        Toast.makeText(getApplicationContext(), "update Complete", Toast.LENGTH_LONG).show();
//                    tt.setText("complete");
//
//                } else {
////                        Toast.makeText(getApplicationContext(), "update Fail", Toast.LENGTH_LONG).show();
//                    tt.setText("fail");
//
//                }

                String [] data = mydb.SelectData(txtuser.getText().toString());
                if(data != null){
                    txtuser.setText(data[0]);
                    txtoldpass.setText(data[1]);
            }
            }
        });

        btnok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                txtnewpass = findViewById(R.id.txtnewpass);
                txtnewcfpass = findViewById(R.id.txtcfpass);
                if (txtnewpass.getText().toString().equals(txtnewcfpass.getText().toString()))
                {
                    long r = mydb.UpdateData(txtuser.getText().toString(), txtnewpass.getText().toString());
                    if (r>0) {
                        tt.setText("fail");
                    } else {
                        tt.setText("complete");
                    }
                } else {
                    tt.setText("new password doesn't match");

                }
            }
        });

    }

}