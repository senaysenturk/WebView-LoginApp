package com.example.senturk.myapplication;

import android.app.Activity;
import android.content.Intent;

import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class Giris extends Activity {

    ListView liste;
    final List<Kisi> kisiler=new ArrayList<Kisi>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_giris);

        kisiler.add(new Kisi("Hakan","Aydın","19",false));
        kisiler.add(new Kisi("Şenay","Şentürk","25",true));
        kisiler.add(new Kisi("Kaan","Özen","23",false));


        liste=(ListView)findViewById(R.id.listViewKisiler);
        CustomAdapter mAdapter= new CustomAdapter(this, kisiler);
        
        liste.setAdapter(mAdapter);

        liste.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                Toast.makeText(Giris.this, kisiler.get(position).getIsim(), Toast.LENGTH_SHORT).show();

                String kucukyas="www.meb.gov.tr/";
                String buyukyas="osym.gov.tr/";


                if (Integer.parseInt(kisiler.get(position).getYas())> 18){

                    Intent intent=new Intent(getApplicationContext(),WebView.class);
                    intent.putExtra("gonder", buyukyas);
                    startActivity(intent);
                }
                else
                {
                    Intent intent=new Intent(getApplicationContext(),WebView.class);
                    intent.putExtra("gonder",kucukyas);
                    startActivity(intent);
                }
            }
        });
    }
}
