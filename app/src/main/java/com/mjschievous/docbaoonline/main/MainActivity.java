package com.mjschievous.docbaoonline.main;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.mjschievous.docbaoonline.R;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void btn_24h(View view) {
        startActivity(new Intent(this,Bao24h.class));
    }

    public void btn_vnexpress(View view) {
        startActivity(new Intent(this, VNExpress.class));
    }

    public void btn_dantri(View view) {
        startActivity(new Intent(this, DanTri.class));
    }
}
