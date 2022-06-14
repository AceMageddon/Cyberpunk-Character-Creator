package com.example.character_creator;

import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.VideoView;

import androidx.appcompat.app.AppCompatActivity;

public class Results extends AppCompatActivity {

    private TextView text1;
    private TextView text2;
    private VideoView video;
    private ImageView icon;
    private Animation fadein1;
    private Animation fadein2;
    private Animation fadein3;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.results);

        text1 = findViewById(R.id.text1);
        text2 = findViewById(R.id.text2);
        video = findViewById(R.id.videoView);
        icon = findViewById(R.id.icon);
        fadein1 = AnimationUtils.loadAnimation(Results.this,R.anim.fadein1);
        fadein2 = AnimationUtils.loadAnimation(Results.this,R.anim.fadein2);
        fadein3 = AnimationUtils.loadAnimation(Results.this,R.anim.fadein3);



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

        String gender;
        if (Assets.genderresult == 1){
            gender = "man";
        }else if (Assets.genderresult == 2){
            gender = "woman";
        }else{
            gender = "person";
        }

        text1.setText("Your name is " + Assets.nameresult + ". You are a " + gender + "  who" );

        if (Assets.Hscore == 2){
            text2.setText("is lukewarm and hate to be bothered to do much of anything, but are also dignified. You assert yourself easily, are thick-skinned, and have few worries. However, you are obstinate, contrarian, and hate to lose, often preventing it by aggressive means. You are overbearing and rebellious, but have talent to back it up.");
        }
        if (Assets.Ascore == 2){
            text2.setText("is a hard worker and always on the move. You are humble and mature. However, you are insecure, fearing rejection more than anything, and are neurotic and methodical to an obsessive degree. You avoid conflict to the utmost extreme, and are receptive and compassionate.");
        }
        if (Assets.Dscore == 2){
            text2.setText("is sensitive, deeply trusting, and easily wounded. Though you avoid people whenever possible, you would never abandon someone in a time of need. Naturally skeptical, you are a truth-seeker who desires to get to the bottom of everything. You spend much of your time alone, pondering the universe.");
        }
        if (Assets.Fscore == 2){
            text2.setText("is on the surface cool-headed and alert. But deep down you are filled with curiosity and love spending time with family and friends more than anything else. Though you are wary of new people and situations, you are thick-skinned and composed, never one to sweat the small stuff.");
        }
        if (Assets.Cscore == 2){
            text2.setText("is co-operative and open-hearted, but down-to-earth to the point of being dry. Always an individual, you are sentimental and have an eye for beauty. Though aloof and laid back, you easily succumb to loneliness, and you treasure your time spent with friends more than anything else in the world.");
        }
        if (Assets.Escore == 2){
            text2.setText("is antisocial and has trouble fitting in. However, you are honest and do not put on a show of yourself for others. You hate the things you do not understand, and take things as fact without looking into them. However, when it comes to protecting your loved ones, you can accomplish tremendous feats of strength.");
        }

        if (Assets.character_icon == 1){
            icon.setBackgroundResource(R.drawable.image1);
        }
        if (Assets.character_icon == 2){
            icon.setBackgroundResource(R.drawable.image2);
        }
        if (Assets.character_icon == 3){
            icon.setBackgroundResource(R.drawable.image3);
        }
        if (Assets.character_icon == 4){
            icon.setBackgroundResource(R.drawable.image4);
        }

        text1.startAnimation(fadein1);
        text2.startAnimation(fadein2);
        icon.startAnimation(fadein3);
    }
}