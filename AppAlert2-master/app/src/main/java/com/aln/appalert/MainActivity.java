package com.aln.appalert;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
     Button btnsave,btnedit;
     EditText txtid,txtname,txtsur;
     RadioButton rbmale,rbfemale;
     Button btnalok,btnalcancel,btnexit;
     
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnsave =findViewById(R.id.btnsave);
        btnedit =findViewById(R.id.btnEdit);
        btnexit =findViewById(R.id.btnExit);
        btnexit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(),"exited app",Toast.LENGTH_LONG).show();


            }
        });
        btnedit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent objint = new Intent(MainActivity.this,Activity_Edit.class);
                startActivity(objint);
                MainActivity.this.finish();
            }
        });
        btnsave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                AlertDialog.Builder al =new AlertDialog.Builder(MainActivity.this);
                LayoutInflater objinflat =LayoutInflater.from(MainActivity.this);
                View view =objinflat.inflate(R.layout.layout_save,null);
                al.setView(view);
                al.show();
                txtid =view.findViewById(R.id.txtid);
                txtname =view.findViewById(R.id.txtname);
                txtsur =view.findViewById(R.id.txtsur);
                rbmale =view.findViewById(R.id.rbmale);
                rbfemale =view.findViewById(R.id.rbfemale);
                btnalok=view.findViewById(R.id.btnalok);
                btnalcancel =view .findViewById(R.id.btnalcancel);
                btnalcancel.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        txtid.setText("");
                        txtname.setText("");
                        txtsur.setText("");
                        txtid.requestFocus();


                    }
                });
                btnalok.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        String id =txtid.getText().toString();
                        String name =txtname.getText().toString();
                        String sur =txtsur.getText().toString();
                        String sex="";
                        if(rbmale.isChecked()){
                            sex =rbmale.getText().toString();

                        }else if(rbfemale.isChecked()){
                            sex =rbfemale.getText().toString();
                        }
                        String str ="ID : "+id+"\n";
                        str +="Name : "+name+"\n";
                        str +="Surname : "+sur+"\n";
                        str +="Gender : "+sex;
                        Toast.makeText(MainActivity.this, str, Toast.LENGTH_SHORT).show();

                    }
                });

            }
        });
    }
}
