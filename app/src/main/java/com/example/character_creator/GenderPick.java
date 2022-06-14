package com.example.character_creator;

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

import androidx.appcompat.app.AppCompatActivity;

public class GenderPick extends AppCompatActivity {

    private TextView error1;
    private androidx.appcompat.widget.AppCompatButton next1;
    private TextView text1;
    private TextView text2;
    private VideoView video;
    private RadioButton he;
    private RadioButton she;
    private RadioButton they;
    private Animation fadein1;
    private Animation fadein2;
    private Animation fadein3;
    private Animation fadein4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.gender_page);

        error1 = findViewById(R.id.error1);
        next1 = findViewById(R.id.next1);
        text1 = findViewById(R.id.text1);
        text2 = findViewById(R.id.text2);
        video = findViewById(R.id.videoView);
        he = findViewById(R.id.he);
        she = findViewById(R.id.she);
        they = findViewById(R.id.they);
        fadein1 = AnimationUtils.loadAnimation(GenderPick.this,R.anim.fadein1);
        fadein2 = AnimationUtils.loadAnimation(GenderPick.this,R.anim.fadein2);
        fadein3 = AnimationUtils.loadAnimation(GenderPick.this,R.anim.fadein3);
        fadein4 = AnimationUtils.loadAnimation(GenderPick.this,R.anim.fadein4);

        String urlString = "android.resource://"+getPackageName()+"/"+R.raw.video2;
        Uri uri = Uri.parse(urlString);
        video.setVideoURI(uri);
        video.start();
        video.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mediaPlayer) {
                mediaPlayer.setLooping(true);
            }
        });

        text1.setText(Assets.nameresult + ", so that is your name.");
        text1.startAnimation(fadein1);
        text2.startAnimation(fadein2);
        he.startAnimation(fadein3);
        she.startAnimation(fadein3);
        they.startAnimation(fadein3);
        next1.startAnimation(fadein4);

        next1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                    if (Assets.genderresult == 0) {
                        error1.setVisibility(View.VISIBLE);
                        error1.setText("I need to know who you are");
                    } else {
                        openActivity();
                    }
                }
        });
        he.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                boolean maleresult = he.isChecked();
                if (maleresult) {
                    she.setChecked(false);
                    they.setChecked(false);
                    Assets.genderresult = 1;
                }
            }
        });

        she.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                boolean femaleresult = she.isChecked();
                if (femaleresult) {
                    he.setChecked(false);
                    they.setChecked(false);
                    Assets.genderresult = 2;
                }
            }
        });

        they.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                boolean themresult = they.isChecked();
                if (themresult) {
                    he.setChecked(false);
                    she.setChecked(false);
                    Assets.genderresult = 3;
                }
            }
        });
    }


    public void openActivity() {
        Intent intent = new Intent(this, ProfilePick.class);
        startActivity(intent);
    }
}