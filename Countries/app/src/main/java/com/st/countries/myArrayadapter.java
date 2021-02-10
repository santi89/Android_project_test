package com.st.countries;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class myArrayadapter extends ArrayAdapter<String> {
    String [] country;
    String [] cap;
    int [] arrpic;
    Context context;

    public myArrayadapter(@NonNull Context context, int [] _arrpic,String[] _country,String [] _cap) {
        super(context, R.layout.layout_listdata);
        country =_country;
        cap=_cap;
        arrpic=_arrpic;
        this.context=context;
    }

    @Override
    public int getCount() {
        return country.length;
    }
    @NonNull
    @Override
    public View getView(int position, @Nullable View v, @NonNull ViewGroup parent) {
        controlHoder ho=new controlHoder();
        if (v==null){
            LayoutInflater inflat = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            v=inflat.inflate(R.layout.layout_listdata,parent,false);
            ho.imgview=v.findViewById(R.id.imgflag);
            ho.tvcountry=v.findViewById(R.id.countries);
            ho.tvcap=v.findViewById(R.id.capital);
            v.setTag(ho);
        }else{
            ho=(controlHoder) v.getTag();
        }
        ho.imgview.setImageResource(arrpic[position]);
        ho.tvcountry.setText(country[position]);
        ho.tvcap.setText(cap[position]);
        return v;
    }
}
