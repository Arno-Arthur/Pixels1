package com.example.pixels;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import java.util.Random;

public class NewsActivity extends SecondActivity {
    ImageView im1,im2,im3, res;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.news_activity);

        im2 = findViewById(R.id.news2);
        im1 = findViewById(R.id.news1);
        im3 = findViewById(R.id.news3);
        res = findViewById(R.id.reset);
        updateNews();


        res.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                updateNews();
            }
        });
    }

    public void updateNews(){
        String[] links = getResources().getStringArray(R.array.links);
        Integer[] images = {
                R.drawable.news1,
                R.drawable.news2,
                R.drawable.news3,
                R.drawable.news4,
                R.drawable.news5,
                R.drawable.news6,
                R.drawable.news7,
                R.drawable.news8,
                R.drawable.news9,
                R.drawable.news10
        };
        int id = new Random().nextInt(links.length);
        im2.setImageResource(images[id]);
        im2.setTag(links[id]);
        id = new Random().nextInt(links.length);
        im1.setImageResource(images[id]);
        im1.setTag(links[id]);
        id = new Random().nextInt(links.length);
        im3.setImageResource(images[id]);
        im3.setTag(links[id]);
    }

    public void onButtonClick(View view){
        Intent browseIntent = new Intent(Intent.ACTION_VIEW,Uri.parse((String) view.getTag()));
        startActivity(browseIntent);
    }
}
