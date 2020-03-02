package com.purplecreations.mygame;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AlertDialog;

import android.content.DialogInterface;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;

public class Gamemenu extends AppCompatActivity {

private AdView mAdView;

    MediaPlayer mysong;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gamemenu);
        MobileAds.initialize(this,"ca-app-pub-7590533102332942~2310230077");
        mAdView = findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder( ).build( );
        mAdView.loadAd(adRequest);








        Button Mybuttoneasy = findViewById(R.id.easy);
        Button Mybuttonmed = findViewById(R.id.med);
        Button Mybuttonhard = findViewById(R.id.hard);
        Button Mymenuback = findViewById(R.id.menuback);
        Button Shareit = findViewById(R.id.share);





        mysong = MediaPlayer.create(Gamemenu.this,R.raw.mymusic);

        mysong.stop();


        Mybuttoneasy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                OpenActivity();
            }

            private void OpenActivity() {
                //mysong.release();

                Intent intent = new Intent(Gamemenu.this,MainActivity.class);
                startActivity(intent);
            }
        });


        Mybuttonmed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                OpenActivity();
            }

            private void OpenActivity() {
                //mysong.release();

                Intent intent = new Intent(Gamemenu.this,Mainactivitymed.class);
                startActivity(intent);
            }
        });




        Mybuttonhard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                OpenActivity();
            }

            private void OpenActivity() {
                //mysong.release();

                Intent intent = new Intent(Gamemenu.this,Mainactivityhard.class);
                startActivity(intent);
            }
        });


        Mymenuback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                OpenActivity();
            }

            private void OpenActivity() {
                //mysong.release();

                Intent intent = new Intent(Gamemenu.this,Splashactivity.class);
                startActivity(intent);
            }
        });



    Shareit.setOnClickListener(new View.OnClickListener( ) {
        @Override
        public void onClick(View v) {
            Intent myintent = new Intent(Intent.ACTION_SEND);
            myintent.setType("text/plain");
            String sharebody = "http://play.google.com/store/apps/details?id=com.purplecreations.mygame";
            String sharesub = "Your subject here";
            myintent.putExtra(Intent.EXTRA_SUBJECT,sharesub);
            myintent.putExtra(Intent.EXTRA_TEXT,sharebody);
            startActivity(Intent.createChooser(myintent, "Share using"));
        }
    });







    }

    @Override
    public void onBackPressed() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage("Are you sure you want to exit?");
        builder.setCancelable(false);
        builder.setPositiveButton("Yes", new DialogInterface.OnClickListener( ) {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                moveTaskToBack(true);
                android.os.Process.killProcess(android.os.Process.myPid());
                System.exit(0);

            }
        });

        builder.setNegativeButton("No", new DialogInterface.OnClickListener( ) {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.cancel( );


            }
        });

        AlertDialog alertDialog = builder.create( );
        alertDialog.show( );
    }
}

