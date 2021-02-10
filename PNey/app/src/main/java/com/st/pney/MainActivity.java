package com.st.pney;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Html;
import android.text.method.LinkMovementMethod;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TextView tvhello =( TextView)findViewById(R.id.tvhello);
        tvhello.setMovementMethod(LinkMovementMethod.getInstance());
        tvhello.setText(Html.fromHtml("<b>Hello</b> <a href=\"http://google.com\">google</a> <p>hhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhh</p>"));

    }
}