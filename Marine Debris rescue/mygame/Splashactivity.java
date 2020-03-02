package com.purplecreations.mygame;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Splashactivity extends AppCompatActivity {



    MediaPlayer mysong;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);






        Button Mybutton = findViewById(R.id.Mybuttonplay);

        mysong = MediaPlayer.create(Splashactivity.this,R.raw.mymusic);

        mysong.stop();


        Mybutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                OpenActivity();
            }

            private void OpenActivity() {
                //mysong.release();

                Intent intent = new Intent(Splashactivity.this,Gamemenu.class);
                startActivity(intent);
            }
        });
    }

    @Override
    public void onBackPressed() {
        moveTaskToBack(false);
    }

    @Override
    protected void onPause() {
        super.onPause( );

    }

    @Override
    protected void onResume() {
        super.onResume( );

    }




}

