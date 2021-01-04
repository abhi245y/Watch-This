package com.abhi245y.watchthis.ui;

import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.abhi245y.watchthis.Models.TelegramResultsModel;
import com.abhi245y.watchthis.R;
import com.abhi245y.watchthis.RecyclerviewAdaptors.TelegramResultsAdaptor;

import java.util.ArrayList;

public class TelegramResultsActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    ArrayList<TelegramResultsModel> tgResults;
    TelegramResultsAdaptor telegramResultsAdaptor;
    RecyclerView.LayoutManager layoutManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_telegram_results);

        recyclerView  = findViewById(R.id.tg_results);
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        tgResults =new ArrayList<>();
        tgResults = (ArrayList<TelegramResultsModel>) getIntent().getSerializableExtra("Tg_results");
        Log.d("TAG","tg_result: "+tgResults);
        telegramResultsAdaptor = new TelegramResultsAdaptor(tgResults,this);
        recyclerView.setAdapter(telegramResultsAdaptor);
    }
}