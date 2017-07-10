package com.example.senturk.myapplication;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends Activity {

    EditText kullaniciAdi, kullaniciSifre;
    Button giris;
    int sayac = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        kullaniciAdi = (EditText)findViewById(R.id.editTextUsername);
        kullaniciSifre = (EditText)findViewById(R.id.editTextSifre);
        giris = (Button)findViewById(R.id.buttonGiris);

        final String kullanici_adi = "admin";
        final String kullanici_sifre = "123456";

        giris.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                sayac++;

                if(sayac < 3)
                {
                    if(kullaniciAdi.getText().toString().equals("") || kullaniciSifre.getText().toString().equals(""))
                    {
                        Toast.makeText(getApplicationContext(),"Bütün alanları doldurun!", Toast.LENGTH_LONG).show();
                    }
                    else
                    {
                        if(kullaniciAdi.getText().toString().equals(kullanici_adi) && kullaniciSifre.getText().toString().equals(kullanici_sifre))
                        {
                            Toast.makeText(getApplicationContext(),"Giriş Yapıldı!", Toast.LENGTH_LONG).show();
                            Intent intent = new Intent(MainActivity.this, Giris.class);
                            startActivity(intent);

                        }
                        else
                        {
                            Toast.makeText(getApplicationContext(),"Kullanici adı veya sifre yanlis!", Toast.LENGTH_LONG).show();
                        }
                    }
                }
                else
                {
                    Toast.makeText(getApplicationContext(),"Giriş hakkınız bitti. Kullanıcı bloke oldu!", Toast.LENGTH_LONG).show();
                }


            }
        });
    }
}
