package com.example.gifclick;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import pl.droidsonroids.gif.GifImageView;

public class MainActivity extends AppCompatActivity {



    GifImageView gifImageView;
    ImageView imageView;
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imageView = findViewById(R.id.idImage);
        gifImageView = findViewById(R.id.idGif);
        button = findViewById(R.id.idButton);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {



              thread();

            }
        });




    }

    private void thread() {

        imageView.setVisibility(View.GONE);

        gifImageView.setVisibility(View.VISIBLE);


        final Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                imageView.setVisibility(View.VISIBLE);

                gifImageView.setVisibility(View.GONE);


            }
        }, 900);

    }


    }

