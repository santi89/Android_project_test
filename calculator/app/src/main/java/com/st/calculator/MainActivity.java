package com.st.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {
    Button btncal,btnexit,btnPlus,btnMul,btnSub,btnDivide;
   EditText num1,num2;
    TextView txtshow;
    DecimalFormat form=new DecimalFormat("#,##0.00");
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.display);


        btncal =findViewById(R.id.btncal);
        btnexit =findViewById(R.id.btnexit);
        txtshow=findViewById(R.id.txtshow);


        btncal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

             Context context;
             AlertDialog.Builder builder =new AlertDialog.Builder(MainActivity.this);
                     View view=getLayoutInflater().inflate(R.layout.activity_main,null);
                     builder.create();
                     builder.setView(view);
                     builder.show();
                num1=findViewById(R.id.txtnum1);
                num2=findViewById(R.id.txtnum2);
                btnPlus =findViewById(R.id.btnPlus);
                btnMul =findViewById(R.id.btnmulti);
                btnSub =findViewById(R.id.btnminut);
                btnDivide =findViewById(R.id.btndivide);


                btnPlus.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                      int nu1= Integer.parseInt(num1.getText().toString());
                      int nu2= Integer.parseInt(num2.getText().toString());
                        txtshow.setText(num1.getText()+"+"+num2.getText()+"="+form.format(nu1+nu2));
                    }
                });

                btnSub.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        int nu1= Integer.parseInt(num1.getText().toString());
                        int nu2= Integer.parseInt(num2.getText().toString());
                        txtshow.setText(num1.getText()+"-"+num2.getText()+"="+form.format(nu1-nu2));
                    }
                });
                btnDivide.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        int nu1= Integer.parseInt(num1.getText().toString());
                        int nu2= Integer.parseInt(num2.getText().toString());
                        txtshow.setText(num1.getText()+"/"+num2.getText()+"="+form.format(nu1/nu2));


                        double dx=Double.parseDouble(num1.getText().toString());
                        double dy=Double.parseDouble(num2.getText().toString());
                        if(dy==0) {
                            Toast.makeText(getApplicationContext(), "Don't divisible whit zero",Toast.LENGTH_LONG).show();
                        }else{
                            double dsum=dx/dy;
                            txtshow.setText(num1.getText()+"/"+ num2.getText()+"="+form.format(dsum));
                        }
                    }


                });
                btnMul.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        int nu1= Integer.parseInt(num1.getText().toString());
                        int nu2= Integer.parseInt(num2.getText().toString());
                        txtshow.setText(num1.getText()+"x"+num2.getText()+"="+form.format(nu1*nu2));
                    }
                });
            }
        });


    }
}
