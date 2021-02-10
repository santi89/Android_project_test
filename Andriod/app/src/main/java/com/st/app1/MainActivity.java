package com.st.app1;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.content.DialogInterface;

import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
String [] arritem={"21","22","23","24","25","26"};
ArrayAdapter adpt;
Spinner spn;
    private Button bOK;
    private Button bcancle;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        spn=findViewById(R.id.spinage);
        Context context;
        adpt=new ArrayAdapter(getApplicationContext(), android.R.layout.simple_spinner_item,arritem);
        spn.setAdapter(adpt);

        bOK= (Button) findViewById(R.id.btnOK);
        bOK.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                showToast();

            }
        });
        bcancle=findViewById(R.id.btncancel);
        bcancle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               // OpenDialog();

                //this is call newapp to show on this layout by show alert
                AlertDialog.Builder al=new AlertDialog.Builder( MainActivity.this);
                String str="show your activity";
                LayoutInflater inflat=LayoutInflater.from(MainActivity.this);
                View view =inflat.inflate(R.layout.newapp,null);
                al.setView(view);
               // al.setTitle("show message");
                //al.setMessage(str);
                al.show();
            }
        });
     }
    public void showToast() {
        Toast.makeText(this,"this is you or not ", Toast.LENGTH_SHORT ).show();
    }
    public void OpenDialog(){
        ExampleDialog exampleDialog=new ExampleDialog();
        exampleDialog.show(getSupportFragmentManager(),"example");

     }
}
