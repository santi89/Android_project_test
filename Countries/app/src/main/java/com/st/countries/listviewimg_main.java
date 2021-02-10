package com.st.countries;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class listviewimg_main extends AppCompatActivity {
        ListView listView1;
    String [] country ={"Laos","Cambodia","Thailand","Vietnam","Singapore","Malaysia","Myanmar","Indonesia","Phillipines","Brunei"
    };
    String [] cap ={"Vientiane","parnormpen","Thailand","Vietnam","Singapore","Malaysia","Naypyidaw ","Indonesia","Phillipines","Bandar Seri Begawan"
    };
    int [] pic={R.drawable.download,R.drawable.laos_flag,
            R.drawable.download,R.drawable.laos_flag,
            R.drawable.singapore_flag,R.drawable.laos_flag,
            R.drawable.download,R.drawable.singapore_flag,
            R.drawable.download,R.drawable.laos_flag};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    listView1=findViewById(R.id.listview1);
        myArrayadapter myadapter =new myArrayadapter(listviewimg_main.this,pic,country,cap);
    listView1.setAdapter(myadapter);
    listView1.setOnItemClickListener(new AdapterView.OnItemClickListener(){
    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        String str =country[position];
        Toast.makeText(listviewimg_main.this,str,Toast.LENGTH_LONG).show();
    }
});
}
}
