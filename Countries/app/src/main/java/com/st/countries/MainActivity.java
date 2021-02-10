package com.st.countries;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.session.PlaybackState;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    Spinner spiner;
    ListView lst;
    spinneradapt adaterArray;
    listitem_arrayadapter deviceAdater;
    int index;
    String[] device={"Computer", "Moblie","Camera"};
    int[] img = { R.drawable.computer, R.drawable.phone, R.drawable.camera};
    int [][] itemImg={
            new int[]{R.drawable.a,R.drawable.as,R.drawable.d,R.drawable.computer},
            new int[]{R.drawable.iphone,R.drawable.vivo, R.drawable.samsung,R.drawable.phone,R.drawable.samsung},
            new int[]{R.drawable.mirrorless,R.drawable.canon, R.drawable.mirrorless,R.drawable.fuji,R.drawable.canon, R.drawable.fuji, R.drawable.canon}
    };
    String[][][] deviceItem = {
            new String[][] {
                    {
                            "Dell  ",
                            "Windows 10 Home 64-bit",
                            "11th Generation Intel® Core™ i5-1135G7 Processor",
                            "Intel®Iris® Xe Graphics with shared graphics memory",
                            "8 GB,1 x8GB,DDR4,3200 MHz",
                            "512GB M.2 PCIe NVMe Solid State Drive",
                            "14.0-in.touch display",
                            "$ 799.99"
                    },
                    {
                            "Acer ",
                            "Windows 10 Home",
                            "Intel® Core™ i5-1135 G7 processor",
                            "Intel®Iris® Xe Graphics",
                            "14 Full HD (1920 x 1080) 16:9 IPS Touchscreen",
                            "8 GB,LPDDR4X 512 GB SSD",
                            "$ 1,399.99"
                    },
                    {
                            "ASUS ZenBook ",
                            "Windows 10 Pro", "Up to Corei7 8th Gen Intel® CPU",
                            "Up to 4.6GHz Turbo Boost",
                            "Up to 2 X faster than 7th Gen CPU",
                            "Up to MX250 NVIDIA® GPU", "Up to 16GB memory",
                            "Up to 1TB PCIe®SSD storage",
                            "$1,199.99"
                    },
                    {
                            "Lenovo",
                            "11th Gen Intel® powered business laptop",
                            "Secure & durable",
                            "Enhanced with Dolby Audio™",
                            "$ 694.99"
                    }},
            new String[][] {
                    {
                            "Iphone pro",
                            "6.7 inches, 1284 x 2778 pixels",
                            "128GB NVMe 6GB RAM",
                            "$ 1,099.00"
                    },
                    {
                            "vivo ",
                            "6.51 inches, 720 x 1600 pixels",
                            "32GB 3GB RAM, 32GB 4GB RAM",
                            "120 EUR"
                    },
                    {
                            "Oppo",
                            "6.5 inches, 1080 x 2400 pixels",
                            "128GB 8GB RAM",
                            "300 EUR"
                    },
                    {
                            "Samsung",
                            "6.5 inches, 720 x 1560 pixels",
                            "128GB 6GB RAM eMMC 5.1",
                            "180 EUR"
                    },
                    {
                            "Huawei",
                            "6.76 inches, 1344 x 2772 pixels",
                            "256GB 12GB RAM",
                            "$1,599.99"
                    } },

            new String[][] {
                    { "GoPro Hero9 Black", "Video 5K, 20MP Photo with SuperPhoto","$ 450.00" },
                    { "Nikon Z5", "4K UHD 2160p","$ 1,954.96" },
                    { "Leica M10-R","New 40MP full frame color sensor","$ 8,295.00" },
                    { "Canon EOS R6","4K UHD 2160p","$ 2,499.00" },
                    { "Canon EOS R5","30.3 Megapixel Full frame CMOS","$ 3,899.00" },
                    { "Fujifilm Instax Mini 11", "4.24 x 4.77 x 2.65 inches","$ 68.95" },
                    { "Nikon D6", "6.30 x 3.62 x 6.42 inches", "$ 6,499.95"},
                    {"Sony A6600", "24.3 MP Higth Image Quality","$ 519.995" } } };


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.spinner_main);

        spiner=findViewById(R.id.spDevice);
        lst=findViewById(R.id.lstDevice);

        adaterArray=new spinneradapt(MainActivity.this,device, img);
        spiner.setAdapter(adaterArray);

        //TODO: Selected item in spiner
        spiner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener(){
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                deviceAdater = new listitem_arrayadapter(MainActivity.this, deviceItem[position], deviceItem[position], deviceItem[position], itemImg[position]);
                lst.setAdapter(deviceAdater);
                index=position;
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        //TODO: Selected item in list viewm
        lst.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent device_item=new Intent(MainActivity.this, activity_device_detail.class);
                device_item.putExtra("image",itemImg[index][position]);
                device_item.putExtra("detail",deviceItem[index][position]);
                startActivity(device_item);
            }
        });
    }
}

