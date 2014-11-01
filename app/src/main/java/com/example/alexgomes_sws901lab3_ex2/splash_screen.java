package com.example.alexgomes_sws901lab3_ex2;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;


public class splash_screen extends Activity {

    Button listRestaurants;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash_screen);

        listRestaurants = (Button)findViewById(R.id.btnListRestaurants);

        listRestaurants.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(splash_screen.this,ListRestaurants.class);
                startActivity(intent);
            }
        });
    }
}
