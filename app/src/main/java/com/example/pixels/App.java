package com.example.pixels;

import android.app.Application;
import android.content.SharedPreferences;

public class App extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        SharedPreferences sp = getSharedPreferences("SharPref", MODE_PRIVATE);
        if(!sp.getBoolean("CHECKBOX",false)){
            SharedPreferences.Editor editor = sp.edit();
            editor.clear().apply();
        }
    }
}
