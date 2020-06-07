package com.mjschievous.docbaoonline.main;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.mjschievous.docbaoonline.R;
import com.mjschievous.docbaoonline.adapter.Bao24hAdapter;
import com.mjschievous.docbaoonline.listener.OnItemClick;
import com.mjschievous.docbaoonline.listener.OnParseComplate;
import com.mjschievous.docbaoonline.model.Item;
import com.mjschievous.docbaoonline.parser.VNExpressPullParser;

import java.util.ArrayList;
import java.util.List;

public class VNExpress extends AppCompatActivity implements OnItemClick, OnParseComplate {
    private RecyclerView recyclerView;
    private Bao24hAdapter adapter;
    private List<Item> itemList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vnexpress);
        recyclerView = findViewById(R.id.rcv_24h);
        itemList = new ArrayList<>();
        adapter = new Bao24hAdapter(itemList, VNExpress.this, this);
        LinearLayoutManager manager = new LinearLayoutManager(this);
        manager.setOrientation(RecyclerView.VERTICAL);
        recyclerView.setLayoutManager(manager);
        recyclerView.setAdapter(adapter);
        new VNExpressPullParser(this).execute("https://vnexpress.net/rss/tin-moi-nhat.rss");
    }

    @Override
    public void onComplate(List<Item> items) {
        itemList.clear();
        itemList.addAll(items);
        adapter.notifyDataSetChanged();
    }

    @Override
    public void onFailure(String error) {
        Toast.makeText(this, "Loi", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onClickItem(String url) {
        Intent intent = new Intent(this, WebViewActivity.class);
        intent.putExtra("link",url);
        startActivity(intent);
    }

}
