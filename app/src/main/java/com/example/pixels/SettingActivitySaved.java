package com.example.pixels;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class SettingActivitySaved extends SecondActivity {
  TextView Name,Class;
  SharedPreferences Pref;
  Button Change;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.save_info_activity);

        Name = findViewById(R.id.getName);
        Class = findViewById(R.id.getClass);
        Change = findViewById(R.id.Change);
        Pref = getSharedPreferences("SharPref", MODE_PRIVATE);

        String N = Pref.getString("NAME", " ");
        Name.setText("Имя: " + N);

        int Number = Pref.getInt("CLASS", 0);
        Class.setText("Класс: " + Number);

        Change.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences.Editor editor = Pref.edit();
                editor.clear();
                editor.apply();

                Intent intent = new Intent (SettingActivitySaved.this, SettingActivity.class);
                startActivity(intent);
                finish();
            }
        });


    }
}

