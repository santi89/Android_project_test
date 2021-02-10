package com.example.toolbar;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;


import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Toolbar tb_view;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

      tb_view=findViewById(R.id.tb_view);
      tb_view.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener() {
          @Override
          public boolean onMenuItemClick(MenuItem item) {
              switch(item.getItemId())
              { case R.id.menu_search:{
                  Toast.makeText(getApplicationContext(),"you click search menu",Toast.LENGTH_SHORT).show();
                  break;
              }
                  case R.id.menu_setting:{
                      Toast.makeText(getApplicationContext(),"you click srtting menu",Toast.LENGTH_SHORT).show();
                      break;

                  }case R.id.menu_about:{
                  Toast.makeText(getApplicationContext(),"you click about menu",Toast.LENGTH_SHORT).show();
                  break;

              }
                  case R.id.menu_exit: {
                      Toast.makeText(getApplicationContext(), "you click exit menu", Toast.LENGTH_SHORT).show();
                      break;

                  }
              }
              return true;
          }
      });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.layout_menu,menu);

        return true;
    }


}