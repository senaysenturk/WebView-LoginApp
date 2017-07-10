package com.example.senturk.myapplication;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Senturk on 17.6.2017.
 */

public class CustomAdapter extends BaseAdapter {

    private LayoutInflater mInflate; //Arayüz ile adapteri birleştirmek için
    private List<Kisi> kisilistemiz;

    public CustomAdapter(Activity activity,List<Kisi> kisiler){
        mInflate=(LayoutInflater)activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        kisilistemiz=kisiler;
    }

    //Kişi sayısını döndürür
    @Override
    public int getCount() {
        return kisilistemiz.size();
    }

    //O pozisyon içerisindeki object değerini döndürür
    @Override
    public Object getItem(int position) {
        return kisilistemiz.get(position);
    }

    //Genelde veritabanı için kullanılır. Long değer döndürür. ID döndürür.
    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parentGroup) {
        //View ile oluşturduğumuz layout dosyasını bağladık
        convertView= mInflate.inflate(R.layout.line_layout,null);

        TextView isim=(TextView)convertView.findViewById(R.id.textViewIsim);
        TextView soyisim=(TextView)convertView.findViewById(R.id.textViewSoyad);
        TextView yas=(TextView)convertView.findViewById(R.id.textViewYas);

        Kisi kisi=kisilistemiz.get(position);

        isim.setText(kisi.getIsim());
        soyisim.setText(kisi.getSoyisim());
        yas.setText(kisi.getYas());

        ImageView resim=(ImageView)convertView.findViewById(R.id.imageView);

       if (kisi.isKadinMi()==true){
           resim.setImageResource(R.drawable.girl);
       }
        else{
           resim.setImageResource(R.drawable.boy);
       }

        return convertView;
    }
}
