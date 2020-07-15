package com.example.gifclick;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.media.MediaPlayer;
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
    Button button, btnReset, btn33, btn99, btnttlr, btnSound;
    TextView tvCurrentCounter, tvSetCount, tvTotalcount;



    int currentcounter =0;
    int countset = 33;
    int totalcount =0;
    int SoundInt = 0;
    String defaultValue;
    MediaPlayer mp;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imageView = findViewById(R.id.idImage);
        gifImageView = findViewById(R.id.idGif);
        button = findViewById(R.id.idButton);
        btnReset = findViewById(R.id.idReset);
        tvCurrentCounter = findViewById(R.id.idCurrentCount);
        btn33 = findViewById(R.id.id33);
        btn99 = findViewById(R.id.id99);
        btnSound = findViewById(R.id.idSound);
        tvSetCount = findViewById(R.id.idCountSet);
        tvTotalcount = findViewById(R.id.idtotalCount);
        btnttlr = findViewById(R.id.idttlr);

        SharedPreferences sharedPref = MainActivity.this.getPreferences(Context.MODE_PRIVATE);
        currentcounter = sharedPref.getInt("Count",0);
        countset = sharedPref.getInt("CountSet",0);
        totalcount = sharedPref.getInt("TotalCount",0);
        SoundInt = sharedPref.getInt("Soundintt",0);
        tvCurrentCounter.setText(""+ currentcounter);
        tvTotalcount.setText(""+ totalcount);

        btnSound.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (SoundInt == 0){
                    SoundInt = 1;

                    btnSound.setText("Turn Off Sound");

                }else {
                    SoundInt = 0;
                    btnSound.setText("Turn On Sound");
                }

                SharedPreferences sharedPref = MainActivity.this.getPreferences(Context.MODE_PRIVATE);
                SharedPreferences.Editor editor = sharedPref.edit();
                editor.putInt("Soundintt", Integer.parseInt(""+ SoundInt));
                editor.commit();

            }
        });

        btn33.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tvSetCount.setText("33");

                countset = 33;
                SharedPreferences sharedPref = MainActivity.this.getPreferences(Context.MODE_PRIVATE);
                SharedPreferences.Editor editor = sharedPref.edit();
                editor.putInt("CountSet", Integer.parseInt(""+ countset));
                editor.commit();
            }
        });

        btn99.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tvSetCount.setText("99");
                countset = 99;
                SharedPreferences sharedPref = MainActivity.this.getPreferences(Context.MODE_PRIVATE);
                SharedPreferences.Editor editor = sharedPref.edit();
                editor.putInt("CountSet", Integer.parseInt(""+ countset));
                editor.commit();
            }
        });

        mp = MediaPlayer.create(MainActivity.this, R.raw.metaltick);




        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                if (SoundInt == 1){

                    try {
                        if (mp.isPlaying()){
                            mp.stop();
                            mp.release();
                            mp = MediaPlayer.create(getApplicationContext(),R.raw.metaltick);
                        } mp.start();

                    }catch (Exception e){
                        e.printStackTrace();
                    }

                }



//                try {
//                    if (mp.isPlaying()) {
//                        mp.stop();
//                        mp.release();
//                        mp = MediaPlayer.create(context, R.raw.sound);
//                    } mp.start();
//                } catch(Exception e) { e.printStackTrace();

//                mp.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
//                    public void onCompletion(MediaPlayer mp) {
//                        //code
//
//                        onCompletion(mp);
//
//                    }
//                });




                if (currentcounter == countset){
                    currentcounter = 0;
                }

                currentcounter = currentcounter +1;
                totalcount = totalcount +1;




                SharedPreferences sharedPref = MainActivity.this.getPreferences(Context.MODE_PRIVATE);
                SharedPreferences.Editor editor = sharedPref.edit();
                editor.putInt("Count", Integer.parseInt(""+ currentcounter));
                editor.putInt("TotalCount", Integer.parseInt(""+ totalcount));
                editor.commit();

                //defaultValue = sharedPref.getString("LastSuraName","");

                tvCurrentCounter.setText(""+ currentcounter);
                tvTotalcount.setText(""+totalcount);



              thread();

            }
        });




        btnReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                currentcounter = 00;

                SharedPreferences sharedPref = MainActivity.this.getPreferences(Context.MODE_PRIVATE);
                SharedPreferences.Editor editor = sharedPref.edit();
                editor.putInt("Count", Integer.parseInt(""+ currentcounter));
                editor.commit();

                //defaultValue = sharedPref.getString("LastSuraName","");

                tvCurrentCounter.setText(""+ currentcounter);


            }
        });

        btnttlr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                currentcounter = 00;
                totalcount = 00;


                SharedPreferences sharedPref = MainActivity.this.getPreferences(Context.MODE_PRIVATE);
                SharedPreferences.Editor editor = sharedPref.edit();
                editor.putInt("Count", Integer.parseInt(""+ currentcounter));
                editor.putInt("TTlCount", Integer.parseInt(""+ totalcount));
                editor.commit();

                //defaultValue = sharedPref.getString("LastSuraName","");

                tvCurrentCounter.setText(""+ currentcounter);
                tvTotalcount.setText(""+ totalcount);


            }
        });




    }


    public void onCompletion(MediaPlayer mp) {
        mp.release();
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
        }, 500);

    }


    }

