package com.st.senddt;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class showdata extends AppCompatActivity {

    TextView tvid,tvname,tvsex,tvphone;

    @Override
    public void onCreate(@Nullable Bundle s) {
        super.onCreate(s);
        setContentView(R.layout.showdata);

        tvid=findViewById(R.id.tvid);
        tvname=findViewById(R.id.tvname);
        tvsex=findViewById(R.id.rbmale);
        tvphone=findViewById(R.id.tvphone);

        Bundle bun=getIntent().getExtras();
        tvid.setText(bun.getString("id"));
        tvname.setText(bun.getString("name"));
        tvsex.setText(bun.getString("sex"));
        tvphone.setText(bun.getString("phone"));


    }
}
