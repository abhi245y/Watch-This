package com.abhi245y.watchthis.ui;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.abhi245y.watchthis.R;

import java.util.Objects;

public class LauncherNetworkCheckActivity extends AppCompatActivity {

    ProgressBar loading_app_progress;
    TextView loading_status;
    ImageView error_icon;


    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Objects.requireNonNull(getSupportActionBar()).hide();
        setContentView(R.layout.activity_launcher_network_check);

        loading_app_progress = findViewById(R.id.loading_app_progress);
        loading_status = findViewById(R.id.loading_status);
        error_icon = findViewById(R.id.error_icon);

        loading_app_progress.setVisibility(View.VISIBLE);
        loading_app_progress.setIndeterminate(true);
        loading_status.setText("Loading...");
        checkNetwork();

        error_icon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                loading_status.setText("Loading...");
                Toast.makeText(LauncherNetworkCheckActivity.this, "trying again", Toast.LENGTH_SHORT).show();
                loading_app_progress.setVisibility(View.VISIBLE);
                error_icon.setVisibility(View.GONE);
                checkNetwork();
            }
        });
    }

    @SuppressLint("SetTextI18n")
    private void checkNetwork(){
        if (isNetworkAvailable()) {
            loading_app_progress.setVisibility(View.INVISIBLE);
            Intent intent = new Intent(this, HomeScreenActivity.class);
            startActivity(intent);
            finish();

        } else {
            loading_app_progress.setVisibility(View.INVISIBLE);
            error_icon.setVisibility(View.VISIBLE);
            loading_status.setText("Please check your network connection to continue");
        }
    }

    private boolean isNetworkAvailable() {
        ConnectivityManager connectivityManager = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
        return activeNetworkInfo != null && activeNetworkInfo.isConnected();
    }
}

