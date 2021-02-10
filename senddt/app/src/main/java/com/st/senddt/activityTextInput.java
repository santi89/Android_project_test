package com.st.senddt;

import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class activityTextInput extends AppCompatActivity {
EditText etid,etname,etphone;
RadioButton rbmale;
RadioGroup radioGroup;
Button btok,btcancel;
TextView tvid,tvname,tvsex,tvphone;
    @Override
    public void onCreate(@Nullable Bundle s) {
        super.onCreate(s);
            setContentView(R.layout.text_input);

        radioGroup =  findViewById(R.id.Rgroup);

        radioGroup=findViewById(R.id.Rgroup);
            btcancel=findViewById(R.id.btncancel);
            btok=findViewById(R.id.btnok);

            btok.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent obj =new Intent(activityTextInput.this,showdata.class);
                    int selectedId = radioGroup.getCheckedRadioButtonId();

                    etid=findViewById(R.id.etid);
                    etname=findViewById(R.id.etname);
                    etphone=findViewById(R.id.etphone);
                    rbmale=findViewById(selectedId);

                    obj.putExtra("id",etid.getText().toString());
                    obj.putExtra("name",etname.getText().toString());
                    obj.putExtra("sex",rbmale.getText().toString());
                    obj.putExtra("phone",etphone.getText().toString());
                    startActivity(obj);

                }
            });


    }
}
