package com.st.senddt;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
Button btnsend,btnlistview;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnsend=findViewById(R.id.btnsend);
        btnlistview=findViewById(R.id.btnlistview);

        btnsend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent obj =new Intent(MainActivity.this,activityTextInput.class);
                startActivity(obj);

            }
        });

    }
}
