package com.example.cutepets;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;


public class Results extends ActionBarActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_results);
        int cutest = getIntent().getExtras().getInt("cutestPet");
        ((ImageView) findViewById(R.id.imageView)).setImageResource(ComparePets.images[cutest]);

    }

}
