package com.example.pixels;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.AndroidViewModel;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide(); // удаляет - скрывает Action Bar
        setContentView(R.layout.activity_main);
        Log.e("MainActivity","launched");
    }

    public void onClick(View view) {
        Intent intent = new Intent(this, NewsActivity.class);
        startActivity(intent);
    }

}