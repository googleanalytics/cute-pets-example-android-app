package com.example.cutepets;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;

public class Results extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_results);
        int cutest = getIntent().getExtras().getInt("cutestPet");
        ((ImageView) findViewById(R.id.imageView)).setImageResource(ComparePets.images[cutest]);
    }
}
