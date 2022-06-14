package com.example.character_creator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.VideoView;

public class MainActivity extends AppCompatActivity {

    private TextView error1;
    private androidx.appcompat.widget.AppCompatButton next1;
    private EditText charactername;
    private TextView text1;
    private TextView text2;
    private VideoView video;


    private Animation fadein1;
    private Animation fadein2;
    private Animation fadein3;
    private Animation fadein4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.starter_page);

        error1 = findViewById(R.id.error1);
        next1 = findViewById(R.id.next1);
        charactername = findViewById(R.id.charactername);
        text1 = findViewById(R.id.text1);
        text2 = findViewById(R.id.text2);
        video = findViewById(R.id.videoView);
        fadein1 = AnimationUtils.loadAnimation(MainActivity.this,R.anim.fadein1);
        fadein2 = AnimationUtils.loadAnimation(MainActivity.this,R.anim.fadein2);
        fadein3 = AnimationUtils.loadAnimation(MainActivity.this,R.anim.fadein3);
        fadein4 = AnimationUtils.loadAnimation(MainActivity.this,R.anim.fadein4);


        String urlString = "android.resource://"+getPackageName()+"/"+R.raw.video1;
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
        charactername.startAnimation(fadein3);
        next1.startAnimation(fadein4);

        next1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Assets.nameresult = charactername.getText().toString();
                    if (Assets.nameresult != null && !Assets.nameresult.trim().isEmpty()) {
                        openActivity();
                    } else {
                        error1.setVisibility(View.VISIBLE);
                        error1.setText("Follow your orders. Input your name.");
                    }
                }
        });
    }

    private void openActivity() {
        Intent intent = new Intent(this, GenderPick.class);
        startActivity(intent);
    }
}