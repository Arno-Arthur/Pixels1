package com.example.pixels;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class SecondActivity extends MainActivity{
    TextView Uname,Uclass;
    SharedPreferences Pref;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.second_activity);
        Uname = findViewById(R.id.username);
        Uclass = findViewById(R.id.userclass);
        Pref = getSharedPreferences("SharPref",MODE_PRIVATE);

        String UN = Pref.getString("NAME", "");
        Uname.setText("Имя: " + UN);

        int UC = Pref.getInt("CLASS", 0);
        Uclass.setText("Класс: " + UC);

    }
    public void Settings (View view) {
        Intent intent = new Intent(this, SettingActivity.class);
        startActivity(intent);
    }
    public void Profile (View view) {
        Intent intent = new Intent(this, SecondActivity.class);
        startActivity(intent);
        }
    public void Education (View view) {
        Intent intent = new Intent(this, EducActivity.class);
        startActivity(intent);
        }
    public void Collection (View view) {
        Intent intent = new Intent(this, CollActivity.class);
        startActivity(intent);
    }
    public void News (View view) {
        Intent intent = new Intent(this, NewsActivity.class);
        startActivity(intent);
    }
}
