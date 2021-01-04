package com.abhi245y.watchthis.ui;

import android.os.Bundle;
import android.util.TypedValue;
import android.widget.CompoundButton;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.abhi245y.watchthis.Extra.Constants;
import com.abhi245y.watchthis.Models.HomeVerticalListModel;
import com.abhi245y.watchthis.R;
import com.abhi245y.watchthis.RecyclerviewAdaptors.HomeRecyclerviewAdaptor;
import com.google.android.material.chip.Chip;
import com.google.android.material.chip.ChipGroup;

import java.util.ArrayList;
import java.util.Map;

public class AddMoviesActivity extends AppCompatActivity {
    RecyclerView addMovies_view;
    HomeRecyclerviewAdaptor homeVerticalRecyclerviewAdaptor;
    ArrayList<HomeVerticalListModel> verticalListModels;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_movies);

//        verticalListModels = new ArrayList<>();
////
////        addMovies_view = findViewById(R.id.homeVerticalRecyclerView);
////        addMovies_view.setHasFixedSize(true);
////
////        addMovies_view.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false));
////        homeVerticalRecyclerviewAdaptor  = new HomeRecylerviewAdaptor(this,verticalListModels);
////        addMovies_view.setAdapter(homeVerticalRecyclerviewAdaptor);

        ChipGroup genreChips = findViewById(R.id.genreChips);

        for(Map.Entry genres: Constants.getGenerCode().entrySet()){
            Chip mChip = (Chip) this.getLayoutInflater().inflate(R.layout.item_chip_category, null, false);
            mChip.setText(genres.getValue().toString());
            int paddingDp = (int) TypedValue.applyDimension(
                    TypedValue.COMPLEX_UNIT_DIP, 10,
                    getResources().getDisplayMetrics()
            );
            mChip.setPadding(paddingDp, 0, paddingDp, 0);
            mChip.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                    mChip.setCheckedIconVisible(true);
                }
            });
            genreChips.addView(mChip);
        }

        ChipGroup languageChips = findViewById(R.id.languageChips);

        for(Map.Entry language: Constants.getLanguageCode().entrySet()){
            Chip mChip = (Chip) this.getLayoutInflater().inflate(R.layout.item_chip_category, null, false);
            mChip.setText(language.getValue().toString());
            int paddingDp = (int) TypedValue.applyDimension(
                    TypedValue.COMPLEX_UNIT_DIP, 10,
                    getResources().getDisplayMetrics()
            );
            mChip.setPadding(paddingDp, 0, paddingDp, 0);
            mChip.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                    mChip.setCheckedIconVisible(true);
                }
            });
            languageChips.addView(mChip);
        }

    }


}