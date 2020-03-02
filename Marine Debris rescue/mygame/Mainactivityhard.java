package com.purplecreations.mygame;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;

import com.purplecreations.mygame.R;

import java.util.Timer;
import java.util.TimerTask;


public class Mainactivityhard extends AppCompatActivity {


    MediaPlayer mysong;
    private Gamemovehard gamemovehard;

    private Handler handler = new Handler( );
    private final static long Interval = 30;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mysong = MediaPlayer.create(Mainactivityhard.this, R.raw.mymusic);
        mysong.start( );


        gamemovehard = new Gamemovehard(this);
        setContentView(gamemovehard);


        Timer timer = new Timer( );
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        gamemovehard.invalidate( );


                    }
                });
            }
        }, 0, Interval);


    }

    @Override
    protected void onPause() {
        super.onPause( );
        android.os.Process.killProcess(android.os.Process.myPid());
        mysong.release( );


    }

    @Override
    protected void onResume() {
        super.onResume( );
        mysong.start( );

    }

    @Override
    public void onBackPressed() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage("Exit Playing?");
        builder.setCancelable(false);
        builder.setPositiveButton("Yes", new DialogInterface.OnClickListener( ) {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                android.os.Process.killProcess(android.os.Process.myPid());
                Intent intent = new Intent(Mainactivityhard.this, Gamemenu.class);
                startActivity(intent);


            }
        });

        builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.cancel();
            }
        });


        AlertDialog alertDialog = builder.create();
        alertDialog.show();
    }

}

