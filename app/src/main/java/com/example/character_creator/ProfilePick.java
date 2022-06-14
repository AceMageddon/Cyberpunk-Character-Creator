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

public class ProfilePick extends AppCompatActivity {

    private TextView error1;
    private androidx.appcompat.widget.AppCompatButton next1;
    private ImageButton choice1;
    private ImageButton choice2;
    private ImageButton choice3;
    private ImageButton choice4;
    private TextView text1;
    private VideoView video;
    private Animation fadein1;
    private Animation fadein2;
    private Animation fadein3;
    private Animation blink;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.profile_page);

        error1 = findViewById(R.id.error1);
        next1 = findViewById(R.id.next1);
        choice1 = findViewById(R.id.choice1);
        choice2 = findViewById(R.id.choice2);
        choice3 = findViewById(R.id.choice3);
        choice4 = findViewById(R.id.choice4);
        text1 = findViewById(R.id.text1);
        video = findViewById(R.id.videoView);
        fadein1 = AnimationUtils.loadAnimation(ProfilePick.this,R.anim.fadein1);
        fadein2 = AnimationUtils.loadAnimation(ProfilePick.this,R.anim.fadein2);
        fadein3 = AnimationUtils.loadAnimation(ProfilePick.this,R.anim.fadein3);
        blink = AnimationUtils.loadAnimation(ProfilePick.this,R.anim.blink_anim);


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

        text1.setText("And what about your face, " + Assets.nameresult + "?");
        text1.startAnimation(fadein1);

        next1.startAnimation(fadein3);
        choice1.startAnimation(fadein2);
        choice2.startAnimation(fadein2);
        choice3.startAnimation(fadein2);
        choice4.startAnimation(fadein2);
        next1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                    if (Assets.character_icon == 0) {
                        error1.setVisibility(View.VISIBLE);
                        error1.setText("Let me look at you");
                    } else {
                        openActivity();
                    }
                }
        });

        choice1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Assets.character_icon = 1;
                choice1.setClickable(false);
                choice1.startAnimation(blink);
                choice2.setClickable(true);
                choice3.setClickable(true);
                choice4.setClickable(true);
            }
        });

        choice2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Assets.character_icon = 2;
                choice2.setClickable(false);
                choice2.startAnimation(blink);
                choice1.setClickable(true);
                choice3.setClickable(true);
                choice4.setClickable(true);
            }
        });

        choice3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Assets.character_icon = 3;
                choice3.startAnimation(blink);
                choice3.setClickable(false);
                choice2.setClickable(true);
                choice1.setClickable(true);
                choice4.setClickable(true);
            }
        });

        choice4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Assets.character_icon = 4;
                choice4.startAnimation(blink);
                choice4.setClickable(false);
                choice3.setClickable(true);
                choice2.setClickable(true);
                choice1.setClickable(true);
            }
        });
    }


    public void openActivity() {
        Intent intent = new Intent(this, Personality_Info.class);
        startActivity(intent);
    }
}