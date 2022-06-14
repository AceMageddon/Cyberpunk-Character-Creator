package com.example.character_creator;

import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.VideoView;

import androidx.appcompat.app.AppCompatActivity;

public class PersonalityStart extends AppCompatActivity {

    private androidx.appcompat.widget.AppCompatButton next1;
    private androidx.appcompat.widget.AppCompatButton next2;
    private androidx.appcompat.widget.AppCompatButton next3;
    private TextView text1;
    private TextView text2;
    private TextView text3;
    private TextView text4;
    private VideoView video;
    private Animation fadein1;
    private Animation fadein2;
    private Animation fadein3;
    private Animation fadein4;
    private Animation fadein5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.personality_start);

        next1 = findViewById(R.id.next1);
        next2 = findViewById(R.id.next2);
        next3 = findViewById(R.id.next3);
        text1 = findViewById(R.id.text1);
        text2 = findViewById(R.id.text2);
        text3 = findViewById(R.id.text3);
        text4 = findViewById(R.id.text4);
        video = findViewById(R.id.videoView);
        fadein1 = AnimationUtils.loadAnimation(PersonalityStart.this,R.anim.fadein1);
        fadein2 = AnimationUtils.loadAnimation(PersonalityStart.this,R.anim.fadein2);
        fadein3 = AnimationUtils.loadAnimation(PersonalityStart.this,R.anim.fadein3);
        fadein4 = AnimationUtils.loadAnimation(PersonalityStart.this,R.anim.fadein4);
        fadein5 = AnimationUtils.loadAnimation(PersonalityStart.this,R.anim.fadein5);


        String urlString = "android.resource://"+getPackageName()+"/"+R.raw.video3;
        Uri uri = Uri.parse(urlString);
        video.setVideoURI(uri);
        video.start();
        video.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mediaPlayer) {
                mediaPlayer.setLooping(true);
            }
        });

        text1.startAnimation(fadein1);
        text2.startAnimation(fadein2);
        text3.startAnimation(fadein3);
        text4.startAnimation(fadein4);
        next1.startAnimation(fadein5);
        next2.startAnimation(fadein5);
        next3.startAnimation(fadein5);


        next1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                        openActivityI();
                }
        });

        next2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openActivityE();
            }
        });

        next3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openActivityD();
            }
        });

    }


    public void openActivityI() {
        Intent intent = new Intent(this, Personality_I1.class);
        startActivity(intent);
    }

    public void openActivityE() {
        Intent intent = new Intent(this, Personality_E1.class);
        startActivity(intent);
    }

    public void openActivityD() {
        Intent intent = new Intent(this, Personality_D1.class);
        startActivity(intent);
    }
}