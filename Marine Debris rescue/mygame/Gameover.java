package com.purplecreations.mygame;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;

public class Gameover extends AppCompatActivity{

    MediaPlayer mysong;
    public TextView DisplayScore;
    public Button StartGameagain;
    public TextView Maxscore;
    public Button Peng;


    private AdView mAdView;

    private String scoring;





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gameover);
        MobileAds.initialize(this,"ca-app-pub-7590533102332942~2310230077");
        mAdView = findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder( ).build( );
        mAdView.loadAd(adRequest);


        mysong = MediaPlayer.create(Gameover.this,R.raw.mymusic);

        DisplayScore = findViewById(R.id.scoregot);
        StartGameagain = findViewById(R.id.startagain);
        Maxscore = findViewById(R.id.highscoreview);
        Peng = findViewById(R.id.med);





        int score = getIntent().getIntExtra("Score", 0);
        //scoring = getIntent().getExtras().get("Score").toString();
        DisplayScore.setText("Your score:" + score);



        SharedPreferences settings = getSharedPreferences("GAME_DATA", Context.MODE_PRIVATE);
        int highscore = settings.getInt("HIGH_SCORE", 0);

        if(score > highscore){
            Maxscore.setText("High score : " +score);

            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setMessage("HighScore!");
            Toast.makeText(Gameover.this,"New High Score!",Toast.LENGTH_SHORT).show();










            SharedPreferences.Editor editor = settings.edit();
            editor.putInt("HIGH_SCORE", score);
            editor.commit();

        }else {
            Maxscore.setText("High score : "+ highscore);
        }













        StartGameagain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //mysong.stop();
                mysong = null;

                Intent intent = new Intent(Gameover.this,Gamemenu.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                startActivity(intent);




            }



        });







    }



    @Override
    public void onBackPressed() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage("Are you sure you want to exit?");
        builder.setCancelable(false);
        builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {

            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                moveTaskToBack(false);
                android.os.Process.killProcess(android.os.Process.myPid());
                System.exit(0);



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




    private void stopPlaying(){
        if(mysong!= null){
            mysong.stop();
            mysong.release();
            mysong = null;
        }
    }
}




