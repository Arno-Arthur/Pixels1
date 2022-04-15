package com.example.pixels;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

public class SettingActivity extends SecondActivity {

    EditText entName,entClass;
    Button saveBtn;
    SharedPreferences shPr;
    CheckBox isRem;
    boolean isRemembered = false;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.settings_activity);

        entName = findViewById(R.id.setName);
        entClass = findViewById(R.id.setClass);
        saveBtn = findViewById(R.id.saveData);
        isRem = findViewById(R.id.checkBox);
        shPr = getSharedPreferences("SharPref", MODE_PRIVATE);

        isRemembered = shPr.getBoolean("CHECKBOX", false);
        if (isRemembered) {
            Intent intent = new Intent (SettingActivity.this, SettingActivitySaved.class);
            startActivity(intent);
            finish();
        }

        saveBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String clazz = entClass.getText().toString().trim();
                String Name = entName.getText().toString().trim();
                int Class = -1;

                if(!clazz.isEmpty()){
                    Class = Integer.parseInt(clazz);
                }
                if(!Name.isEmpty() && Class>0){
                    boolean checked = isRem.isChecked();
                    SharedPreferences.Editor editor = shPr.edit();
                    editor.putString("NAME", Name);
                    editor.putInt("CLASS",Class);
                    editor.putBoolean("CHECKBOX", checked);
                    editor.apply();

                    Toast.makeText(SettingActivity.this, "Info Saved", Toast.LENGTH_SHORT).show();

                    Intent intent = new Intent (SettingActivity.this, SettingActivitySaved.class);
                    startActivity(intent);
                    finish();

                }
            }
        });

    }

}