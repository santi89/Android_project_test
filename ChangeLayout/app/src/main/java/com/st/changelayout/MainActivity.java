package com.st.changelayout;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    EditText txtid,txtname,txtsur,txtsalary,txtemail;
    Button btnok,btncancel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtid =findViewById(R.id.txtid);
        txtname =findViewById(R.id.txtname);
        txtsur =findViewById(R.id.txtsurname);
        txtsalary =findViewById(R.id.txtsalary);
        txtemail =findViewById(R.id.txtemail);
        btnok =findViewById(R.id.btnok);
        btncancel =findViewById(R.id.btncancel);

        btnok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent obj =new Intent(MainActivity.this,Activity.class);
                obj.putExtra("id",txtid.getText().toString());
                obj.putExtra("name",txtname.getText().toString());
                obj.putExtra("surname",txtsur.getText().toString());
                obj.putExtra("salary",txtsalary.getText().toString());
                obj.putExtra("email",txtemail.getText().toString());

                startActivity(obj);
            }
        });
    }
}
