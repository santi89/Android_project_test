package com.sd.lap_7_12;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText txtuser,txtoldpass,txtnewpass,txtnewcfpass;
    Button btnok;
    SQLiteDatabase db;
    DataBaseHelper mydb = new DataBaseHelper(this);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mydb.getWritableDatabase();
        initial();
        btnsearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String [] data = mydb.SelectData(txtsearch.getText().toString());
                if(data != null){
                    txtuser.setText(data[0]);
                    txtoldpass.setText(data[1]);
                    txtnewpass.setText(data[2]);
                    txtnewcfpass.setText(data[3]);

                }else{
                    Toast.makeText(getApplicationContext(), "No Data", Toast.LENGTH_LONG).show();
                }

            }
        });

        btnsave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                long r = mydb.insertData(txtname.getText().toString(),txtsur.getText().toString(),txtage.getText().toString(),txttel.getText().toString());
                if(r>0){
                    Toast.makeText(getApplicationContext(), "Insert Complete", Toast.LENGTH_LONG).show();
                    clearData();

                }else{
                    Toast.makeText(getApplicationContext(), "Insert Fail", Toast.LENGTH_LONG).show();
                }
            }
        });

        btnok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                long r = mydb.UpdateData(txtid.getText().toString(), txtname.getText().toString(), txtsur.getText().toString(), txtage.getText().toString(), txttel.getText().toString());
                if(r>0){
                    Toast.makeText(getApplicationContext(), "Edit Complete", Toast.LENGTH_LONG).show();
                    clearData();

                }else{
                    Toast.makeText(getApplicationContext(), "Edit Fail", Toast.LENGTH_LONG).show();
                }
            }
        });

    }



    public void clearData() {
        txtuser.setText("");
        txtnewcfpass.setText("");
        txtnewpass.setText("");
        txtoldpass.setText("");


}
    public void initial() {
        txtuser = findViewById(R.id.txtuser);
        txtoldpass = findViewById(R.id.txtoldpass);
        txtnewpass = findViewById(R.id.txtnewpass);
        txtnewcfpass = findViewById(R.id.txtcfpass);

    }
}