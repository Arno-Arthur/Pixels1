package com.example.pixels;

import android.content.Intent;
import android.media.Image;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

import java.util.Random;

public class CollActivity extends SecondActivity {
    ImageView i1, i2, i3, i4, res;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.coll_activity);

        i1 = findViewById(R.id.i1);
        i2 = findViewById(R.id.i2);
        i3 = findViewById(R.id.i3);
        i4 = findViewById(R.id.i4);
        res = findViewById(R.id.reset2);
        updateNews();

        res.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                updateNews();
            }
        });
  }
    public void updateNews(){
        String[] gifs = getResources().getStringArray(R.array.gifs);
        Integer[] images = {
                R.drawable.anim_zeb,
                R.drawable.anim_el,
                R.drawable.anim_lion,
                R.drawable.anim_tig
        };

        int id = new Random().nextInt(gifs.length);
        i1.setImageResource(images[id]);
        i1.setTag(gifs[id]);
        id = new Random().nextInt(gifs.length);
        i2.setImageResource(images[id]);
        i2.setTag(gifs[id]);
        id = new Random().nextInt(gifs.length);
        i3.setImageResource(images[id]);
        i3.setTag(gifs[id]);
        id = new Random().nextInt(gifs.length);
        i4.setImageResource(images[id]);
        i4.setTag(gifs[id]);
    }

    public void onButtonClick(View view){
        Intent browseIntent = new Intent(Intent.ACTION_VIEW, Uri.parse((String) view.getTag()));
        startActivity(browseIntent);
    }
}
