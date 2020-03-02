package com.purplecreations.mygame;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ProgressBar;
import android.widget.TextView;

public class Splashscreen extends AppCompatActivity {


    ProgressBar progressBar;
    TextView textView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splashscreen);





        Thread thread = new Thread()
        {
            @Override
            public void run() {
                try {
                    sleep(4000);

                }catch (Exception e )
                {
                    e.printStackTrace();

                }
                finally {

                    Intent mainintent = new Intent(Splashscreen.this,Gamemenu.class);
                    startActivity(mainintent);

                }
            }
        };
        thread.start();
    }




}
