package com.st.countries;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class sql_main extends AppCompatActivity {
    EditText edid,edname,edsur,edage,edtel;
    Button btnsave,btnedit,btndelete,btnsearch;
    mydatabase mydb=new mydatabase(this);

   protected void onCreate(@Nullable Bundle savedInstanceState) {
       super.onCreate(savedInstanceState);
       btnsave.setOnClickListener(new View.OnClickListener() {

           @Override
           public void onClick(View v) {

           }
       });

   }

       private void initialize(){
       edid=findViewById(R.id.edid);
       edname=findViewById(R.id.edname);
       edsur=findViewById(R.id.edsurname);
       edage=findViewById(R.id.edage);
       edtel=findViewById(R.id.edtel);
       btnsave=findViewById(R.id.btnsave);
       btnedit=findViewById(R.id.btnedit);

       }

}
