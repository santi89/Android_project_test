package com.st.countries;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class adapter_listofdata extends ArrayAdapter<String> {
    String []name_com;
    String [] detail;
    int [] imgs;
    Context context;

    public adapter_listofdata(@NonNull Context context, int [] imgs,String [] name_com,String[]detail) {
        super(context, R.layout.listofdata);
        this.imgs=imgs;
        this.name_com=name_com;
        this.detail=detail;
        this.context=context;
    }

    @Override
    public int getCount() {
        return name_com.length;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View v, @NonNull ViewGroup parent) {
       hoder_listofdata hd=new hoder_listofdata();
       if (v==null){
           LayoutInflater inflater= (LayoutInflater)getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
           v=inflater.inflate(R.layout.listofdata,parent,false);
      hd.imgs=v.findViewById(R.id.im_com);
      hd.txtname=v.findViewById(R.id.txttitle);
      hd.txtdetail=v.findViewById(R.id.txtdetail1);
      v.setTag(hd);
       }else{
           hd=(hoder_listofdata) v.getTag();
       }
       hd.imgs.setImageResource(imgs[position]);
       hd.txtname.setText(name_com[position]);
       hd.txtdetail.setText(detail[position]);

        return v;
    }
}
