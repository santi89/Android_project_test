package com.aln.appalert;

import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.view.View;
import android.widget.Button;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class Activity_Edit extends AppCompatActivity {
    Button btnback;
    @Override
    protected void onCreate(@Nullable Bundle s) {
        super.onCreate(s);
        setContentView(R.layout.layout_edit);
        btnback =findViewById(R.id.btneditback);
        btnback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =new Intent(Activity_Edit.this,MainActivity.class);
                startActivity(intent);
                Activity_Edit.this.finish();
            }
        });
    }
}
