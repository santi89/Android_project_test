package com.st.countries;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;


public class spinneradapt extends ArrayAdapter<String> {
    String []str1;
    int []imgPath;
    Context context;


    public spinneradapt(Context context, String[] str1, int[] imgPath) {
        super(context,R.layout.spinner);
        this.str1 = str1;
        this.imgPath = imgPath;
        this.context = context;
    }

    @Override
    public  int getCount(){
        return  str1.length;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View vw, @NonNull ViewGroup parent) {
        spinneradapt.ControlList controlTextView=new spinneradapt.ControlList();
        View listItem=vw;

        listItem =LayoutInflater.from(context).inflate(R.layout.spinner,parent, false);
        listItem.setTag(controlTextView);

        controlTextView.imgFalg=listItem.findViewById(R.id.imgSpDevice);
        controlTextView.tvw1=listItem.findViewById(R.id.tvSpDeviceName);

        controlTextView.imgFalg.setImageResource(imgPath[position]);
        controlTextView.tvw1.setText(str1[position]);
        return listItem;
    }

    @Override
    public View getDropDownView(int position, @Nullable View vw, @NonNull ViewGroup parent) {
        spinneradapt.ControlList controlTextView=new spinneradapt.ControlList();
        View listItem=vw;

    listItem =LayoutInflater.from(context).inflate(R.layout.spinner,parent, false);
    listItem.setTag(controlTextView);

    controlTextView.imgFalg=listItem.findViewById(R.id.imgSpDevice);
    controlTextView.tvw1=listItem.findViewById(R.id.tvSpDeviceName);

    controlTextView.imgFalg.setImageResource(imgPath[position]);
    controlTextView.tvw1.setText(str1[position]);

        return listItem;
    }

    static  class  ControlList{
        TextView tvw1;
        ImageView imgFalg;
    }
}
