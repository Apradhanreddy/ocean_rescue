package com.purplecreations.mygame;


import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.view.MotionEvent;
import android.view.View;

import static android.graphics.Color.BLACK;
import static android.graphics.Color.blue;
import static java.lang.Math.*;


public class Gamemove extends View {

    private Bitmap object[] = new Bitmap[4];
    private int objectX;
    private int objectY;
    private int objectSpeed;
   // private Paint objectXPaint = new Paint();
   // private Paint objectYPaint = new Paint();

    private int canvasWidth, canvasHeight;


    private Bitmap backgroundimg,backgroundimgg;



    private Bitmap sprayjunk;
    private int sprayjunkX;
    private int sprayjunkY;
    private int sprayjunkSpeed = 7;

    private Bitmap tinjunk;
    private int tinjunkX;
    private int tinjunkY;
    private int tinjunkSpeed = 8;

    private Bitmap jarjunk;
    private int jarjunkX;
    private int jarjunkY;
    private int jarjunkSpeed = 7;

    private Bitmap forkjunk;
    private int forkjunkX;
    private int forkjunkY;
    private int forkjunkSpeed = 7;

    private Bitmap medjunk;
    private int medjunkX;
    private int medjunkY;
    private int medjunkSpeed = 6;

    private Bitmap fishone;
    private int fishoneX;
    private int fishoneY;
    private int fishoneSpeed = 7;

    private Bitmap fishtwo;
    private int fishtwoX;
    private int fishtwoY;
    private int fishtwoSpeed = 8;

    private Bitmap fishthree;
    private int fishthreeX;
    private int fishthreeY;
    private int fishthreeSpeed = 6;

    private Bitmap fishfour;
    private int fishfourX;
    private int fishfourY;
    private int fishfourSpeed = 9;

    private Bitmap fishfive;
    private int fishfiveX;
    private int fishfiveY;
    private int fishfiveSpeed = 5;


















    private int score, Highscore, lifecounter;

    private Paint scorePaint = new Paint();

    private boolean touch = false;

    private Bitmap life[] = new Bitmap[2];



    public Gamemove(Context context) {

        super(context);



        object[0] = BitmapFactory.decodeResource(getResources(), R.drawable.dolphin1);
        object[1] = BitmapFactory.decodeResource(getResources(), R.drawable.dolphinsecond);
        object[2] = BitmapFactory.decodeResource(getResources(),R.drawable.windolph);
        object[3] = BitmapFactory.decodeResource(getResources(),R.drawable.outdolph);

        backgroundimg = BitmapFactory.decodeResource(getResources(),R.drawable.walllll);
       // backgroundimgg = BitmapFactory.decodeResource(getResources(),R.drawable.walllll);




        sprayjunk = BitmapFactory.decodeResource(getResources(), R.drawable.spray);
        jarjunk = BitmapFactory.decodeResource(getResources(), R.drawable.jar1);





        tinjunk = BitmapFactory.decodeResource(getResources(), R.drawable.cokeytin);


        fishone = BitmapFactory.decodeResource(getResources(), R.drawable.smallfish);
        fishtwo = BitmapFactory.decodeResource(getResources(), R.drawable.smallfish2);
        fishthree = BitmapFactory.decodeResource(getResources(), R.drawable.smallfishh);
        fishfour = BitmapFactory.decodeResource(getResources(), R.drawable.fisho);
        fishfive = BitmapFactory.decodeResource(getResources(), R.drawable.fisht);







        //grassone = BitmapFactory.decodeResource(getResources(), R.drawable.bushfirst);
        //grasstwo = BitmapFactory.decodeResource(getResources(), R.drawable.bushsec);


        scorePaint.setColor(BLACK);
        scorePaint.setTextSize(40);
        scorePaint.setTypeface(Typeface.defaultFromStyle(Typeface.BOLD));
        scorePaint.setAntiAlias(true);

        life[0] = BitmapFactory.decodeResource(getResources(), R.drawable.hearts);
        life[1] = BitmapFactory.decodeResource(getResources(), R.drawable.heart_grey);

        objectY = 500;
        score = 0;
        Highscore = 0;
        lifecounter = 3;







    }


    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);


        canvasWidth = canvas.getWidth( );
        canvasHeight = canvas.getHeight( );

        //canvas.drawColor(ContextCompat.getColor(getContext( ), R.color.colorPrimaryplayagain));

       canvas.drawBitmap(backgroundimg, 0, 0, null);

        int minobjectY = object[0].getHeight();
        int maxobjectY = canvasHeight - object[0].getHeight() * 3;

        int mindollyX = object[0].getWidth();
        int maxdollyX = canvasWidth - object[0].getWidth();




        objectY = objectY + objectSpeed;

        if (objectY < minobjectY) {
            objectY = minobjectY;
        }
        if (objectY > maxobjectY) {
            objectY = maxobjectY;
        }

        objectSpeed = objectSpeed + 2;

        if (touch) {
            canvas.drawBitmap(object[1], objectX, objectY, null);
            touch = false;
        } else {
            canvas.drawBitmap(object[0], objectX, objectY, null);


        }

        fishoneX = fishoneX - fishoneSpeed;

        if (hitballChecker(fishoneX, fishoneY)) {
            score = score + 10;
            fishoneX = -100;
            canvas.drawBitmap(object[2],objectX,objectY,null);

        }

        if (fishoneX < 0) {
            fishoneX = canvasWidth + 21;
            fishoneY = (int) floor(Math.random( ) * (maxobjectY - minobjectY)) + minobjectY;

        }

        fishtwoX = fishtwoX - fishtwoSpeed;

        if (hitballChecker(fishtwoX, fishtwoY)) {
            score = score + 15;
            fishtwoX = -100;

            canvas.drawBitmap(object[2],objectX,objectY,null);
        }

        if (fishtwoX < 0) {
            fishtwoX = canvasWidth + 21;
            fishtwoY = (int) floor(Math.random( ) * (maxobjectY - minobjectY)) + minobjectY;

        }

        fishthreeX = fishthreeX - fishthreeSpeed;

        if (hitballChecker(fishthreeX, fishthreeY)) {
            score = score + 20;
            fishthreeX = -100;

            canvas.drawBitmap(object[2],objectX,objectY,null);
        }

        if (fishthreeX < 0) {
            fishthreeX = canvasWidth + 21;
            fishthreeY = (int) floor(Math.random( ) * (maxobjectY - minobjectY)) + minobjectY;

        }

        fishfourX = fishfourX - fishfourSpeed;

        if (hitballChecker(fishfourX, fishfourY)) {
            score = score + 5;
            fishfourX = -100;
            canvas.drawBitmap(object[2],objectX,objectY,null);

        }

        if (fishfourX < 0) {
            fishfourX= canvasWidth + 21;
            fishfourY = (int) floor(Math.random( ) * (maxobjectY - minobjectY)) + minobjectY;

        }

        fishfiveX = fishfiveX - fishfiveSpeed;

        if (hitballChecker(fishfiveX, fishfiveY)) {
            score = score + 25;
            fishfiveX = -100;

            canvas.drawBitmap(object[2],objectX,objectY,null);

        }

        if (fishfiveX < 0) {
            fishfiveX = canvasWidth + 21;
            fishfiveY = (int) floor(Math.random( ) * (maxobjectY - minobjectY)) + minobjectY;

        }









        sprayjunkX = sprayjunkX - sprayjunkSpeed;

        if (hitballChecker(sprayjunkX, sprayjunkY)) {
            sprayjunkX = (canvasWidth - 1);
            lifecounter--;

            canvas.drawBitmap(object[3],objectX,objectY,null);


            if (lifecounter == 0) {



                Intent gameover = new Intent(getContext( ), Gameover.class);

                gameover.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                gameover.putExtra("Score", score);
                getContext( ).startActivity(gameover);

            }
        }

        if (sprayjunkX < 0) {
            sprayjunkX = canvasWidth + 21;
            sprayjunkY = (int) floor(Math.random( ) * (maxobjectY - minobjectY)) + minobjectY;

        }


        tinjunkX = tinjunkX - tinjunkSpeed;

        if (hitballChecker(tinjunkX, tinjunkY)) {
            tinjunkX = (canvasWidth - 1);
            lifecounter--;

            canvas.drawBitmap(object[3],objectX,objectY,null);


            if (lifecounter == 0) {



                Intent gameover = new Intent(getContext( ), Gameover.class);

                gameover.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                gameover.putExtra("Score", score);
                getContext( ).startActivity(gameover);

            }
        }

        if (tinjunkX < 0) {
            tinjunkX = canvasWidth + 21;
            tinjunkY = (int) floor(Math.random( ) * (maxobjectY - minobjectY)) + minobjectY;

        }



        jarjunkX = jarjunkX - jarjunkSpeed;

        if (hitballChecker(jarjunkX, jarjunkY)) {
            jarjunkX = (canvasWidth - 1);
            lifecounter--;

            canvas.drawBitmap(object[3],objectX,objectY,null);


            if (lifecounter == 0) {



                Intent gameover = new Intent(getContext( ), Gameover.class);

                gameover.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                gameover.putExtra("Score", score);
                getContext( ).startActivity(gameover);

            }
        }

        if (jarjunkX < 0) {
            jarjunkX = canvasWidth + 21;
            jarjunkY = (int) floor(Math.random( ) * (maxobjectY - minobjectY)) + minobjectY;

        }















        canvas.drawBitmap(fishone,fishoneX,fishoneY,null);
        canvas.drawBitmap(fishtwo,fishtwoX,fishtwoY,null);
        canvas.drawBitmap(fishthree,fishthreeX,fishthreeY,null);
        canvas.drawBitmap(fishfour,fishfourX,fishfourY,null);
        canvas.drawBitmap(fishfive,fishfiveX,fishfiveY,null);










        canvas.drawBitmap(tinjunk,tinjunkX,tinjunkY,null);
        canvas.drawBitmap(sprayjunk,sprayjunkX,sprayjunkY,null);
        canvas.drawBitmap(jarjunk,jarjunkX,jarjunkY,null);






        canvas.drawText("Score :" + score, 30, 60, scorePaint);


        for (int i = 0; i < 3; i++) {
            int x = (int) (300 + life[0].getWidth( ) * 1.5 * i);
            int y = 30;
            if (i < lifecounter) {
                canvas.drawBitmap(life[0], x, y, null);
            } else {
                canvas.drawBitmap(life[1], x, y, null);
            }

        }







    }


    public boolean hitballChecker ( int x, int y){
        if (objectX < x && x < (objectX + object[0].getWidth( )) && objectY < y && y < (objectY + object[0].getHeight( ))) {

            return true;
        }

        return false;
    }






    @Override
    public boolean onTouchEvent (MotionEvent event){
        if (event.getAction( ) == MotionEvent.ACTION_DOWN) {
            touch = true;
            objectSpeed = -22;
        }
        return true;
    }

}
