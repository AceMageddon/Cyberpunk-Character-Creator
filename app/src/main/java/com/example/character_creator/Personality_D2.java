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

public class Personality_D2 extends AppCompatActivity {

    private androidx.appcompat.widget.AppCompatButton next1;
    private androidx.appcompat.widget.AppCompatButton next2;
    private TextView text1;
    private TextView text2;
    private TextView text3;
    private VideoView video;
    private Animation fadein1;
    private Animation fadein2;
    private Animation fadein3;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.personality_e2);

        next1 = findViewById(R.id.next1);
        next2 = findViewById(R.id.next2);
        text1 = findViewById(R.id.text1);
        text2 = findViewById(R.id.text2);
        text3 = findViewById(R.id.text3);
        video = findViewById(R.id.videoView);
        fadein1 = AnimationUtils.loadAnimation(Personality_D2.this,R.anim.fadein1);
        fadein2 = AnimationUtils.loadAnimation(Personality_D2.this,R.anim.fadein2);
        fadein3 = AnimationUtils.loadAnimation(Personality_D2.this,R.anim.fadein3);



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
        text3.startAnimation(fadein2);
        next1.startAnimation(fadein3);
        next2.startAnimation(fadein3);


        next1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Assets.Cscore++;
                if (Assets.Cscore == 2) {
                    openActivity2();
                }else{
                    openActivity1();
                }
                }
        });

        next2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Assets.Escore++;
                if (Assets.Escore == 2) {
                    openActivity2();
                }else{
                    openActivity1();
                }
            }
        });
    }


    public void openActivity1() {
        Intent intent = new Intent(this, Personality_D3.class);
        startActivity(intent);
    }

    public void openActivity2() {
        Intent intent = new Intent(this, Results.class);
        startActivity(intent);
    }
}