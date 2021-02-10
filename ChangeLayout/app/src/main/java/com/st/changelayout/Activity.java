package com.st.changelayout;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class Activity extends AppCompatActivity {

    TextView tvid,tvname,tvsurname,tvsalary,tvemail;
    @Override
    public void onCreate(@Nullable Bundle s) {
        super.onCreate(s);
        setContentView(R.layout.layout_info);

        tvid=findViewById(R.id.tvid);
        tvname=findViewById(R.id.tvname);
        tvsurname=findViewById(R.id.tvsurname);
        tvsalary=findViewById(R.id.tvsalary);
        tvemail=findViewById(R.id.tvemail);

        Bundle bun=getIntent().getExtras();
        tvid.setText(bun.getString("id"));
        tvname.setText(bun.getString("name"));
        tvsurname.setText(bun.getString("surname"));
        tvsalary.setText(bun.getString("salary"));
        tvemail.setText(bun.getString("email"));




    }
}
