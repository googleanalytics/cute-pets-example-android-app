package com.example.cutepets;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;

import com.google.android.gms.analytics.HitBuilders;

public class ComparePets extends AppCompatActivity {
    final static int[] images = {
            R.drawable.cat_1,
            R.drawable.dog_1,
            R.drawable.cat_2,
            R.drawable.dog_2,
            R.drawable.cat_3,
            R.drawable.dog_3,
            R.drawable.cat_4,
            R.drawable.dog_4,
            R.drawable.cat_5,
            R.drawable.dog_5
    };

    private int cutest, index;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_compare_pets);

        Bundle extras = getIntent().getExtras();
        if (extras == null) {
            cutest = 0;
            index = 1;
        } else {
            cutest = extras.getInt("cutestPet", 0);
            index = extras.getInt("petIndex", 1);
        }

        ImageView ivCutest = (ImageView) findViewById(R.id.imageView1);
        if (ivCutest != null) {
            ivCutest.setImageResource(images[cutest]);
        }

        ImageView ivCandidate = (ImageView) findViewById(R.id.imageView2);
        if (ivCandidate != null) {
            ivCandidate.setImageResource(images[index]);
        }
    }

    public void select(View view) {
        Intent intent = new Intent();

        String imageLabel;
        if (view.getId() == R.id.imageView1) {
            intent.putExtra("cutestPet", cutest);
            imageLabel = getResources().getResourceName(images[cutest]);
        } else {
            intent.putExtra("cutestPet", index);
            imageLabel = getResources().getResourceName(images[index]);
        }
        HitBuilders.EventBuilder eventBuilder = new HitBuilders.EventBuilder();
        eventBuilder.setAction("Vote").setCategory("Image").setValue(1L).setLabel(imageLabel);
        MyApp.tracker().send(eventBuilder.build());

        intent.putExtra("petIndex", index + 1);

        if (index < images.length - 1) {
            intent.setClass(this, ComparePets.class);
        } else {
            intent.setClass(this, Results.class);
        }
        startActivity(intent);
        finish();
    }
}
