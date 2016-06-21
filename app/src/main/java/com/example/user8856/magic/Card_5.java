package com.example.user8856.magic;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Random;

public class Card_5 extends AppCompatActivity {
    private TextView time;
    int ran = (int)(Math.random()*10);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_card_5);
        Allactivity.getInstance().addActivity(this);

        String[] uri = new String[5];

        if(ran == 0)
        {
            uri[0] = "@drawable/squareq";
            uri[1] = "@drawable/hatowq";
            uri[2] = "@drawable/heartj";
            uri[3] = "@drawable/heartk";
            uri[4] = "@drawable/flowerj";
        }
        else if(ran == 1)
        {
            uri[0] = "@drawable/flowerj";
            uri[1] = "@drawable/heartq";
            uri[2] = "@drawable/floewrq";
            uri[3] = "@drawable/heartk";
            uri[4] = "@drawable/hatowk";
        }
        else if(ran == 2)
        {
            uri[0] = "@drawable/squareq";
            uri[1] = "@drawable/hatowk";
            uri[2] = "@drawable/squarej";
            uri[3] = "@drawable/heartk";
            uri[4] = "@drawable/hatowq";
        }
        else if(ran == 3)
        {
            uri[0] = "@drawable/squareq";
            uri[1] = "@drawable/hatowj";
            uri[2] = "@drawable/squarek";
            uri[3] = "@drawable/heartj";
            uri[4] = "@drawable/hatowq";
        }
        else if(ran == 4)
        {
            uri[0] = "@drawable/heartk";
            uri[1] = "@drawable/hatowq";
            uri[2] = "@drawable/flowerk";
            uri[3] = "@drawable/flowerj";
            uri[4] = "@drawable/heartj";
        }
        else if(ran == 5)
        {
            uri[0] = "@drawable/floewrq";
            uri[1] = "@drawable/squareq";
            uri[2] = "@drawable/hatowj";
            uri[3] = "@drawable/squarek";
            uri[4] = "@drawable/flowerk";
        }
        else if(ran == 6)
        {
            uri[0] = "@drawable/hatowk";
            uri[1] = "@drawable/heartq";
            uri[2] = "@drawable/heartj";
            uri[3] = "@drawable/squarek";
            uri[4] = "@drawable/floewrq";
        }
        else if(ran == 7)
        {
            uri[0] = "@drawable/hatowj";
            uri[1] = "@drawable/flowerq";
            uri[2] = "@drawable/squarej";
            uri[3] = "@drawable/hatowk";
            uri[4] = "@drawable/squareq";
        }
        else if(ran == 8)
        {
            uri[0] = "@drawable/flowerk";
            uri[1] = "@drawable/heartj";
            uri[2] = "@drawable/squareq";
            uri[3] = "@drawable/heartk";
            uri[4] = "@drawable/hatowj";
        }
        else if(ran == 9)
        {
            uri[0] = "@drawable/hatowk";
            uri[1] = "@drawable/heartj";
            uri[2] = "@drawable/hatowq";
            uri[3] = "@drawable/squareq";
            uri[4] = "@drawable/flowerj";
        }

        ImageView imageView1 = (ImageView) findViewById( R.id.image1);
        int imageResource1 = getResources().getIdentifier(uri[0], null, getPackageName());
        Drawable image1 = getResources().getDrawable(imageResource1);
        imageView1.setImageDrawable(image1);

        ImageView imageView2 = (ImageView) findViewById( R.id.image2);
        int imageResource2 = getResources().getIdentifier(uri[1], null, getPackageName());
        Drawable image2 = getResources().getDrawable(imageResource2);
        imageView2.setImageDrawable(image2);

        ImageView imageView3 = (ImageView) findViewById( R.id.image3);
        int imageResource3 = getResources().getIdentifier(uri[2], null, getPackageName());
        Drawable image3 = getResources().getDrawable(imageResource3);
        imageView3.setImageDrawable(image3);

        ImageView imageView4 = (ImageView) findViewById( R.id.image4);
        int imageResource4 = getResources().getIdentifier(uri[3], null, getPackageName());
        Drawable image4 = getResources().getDrawable(imageResource4);
        imageView4.setImageDrawable(image4);

        ImageView imageView5 = (ImageView) findViewById( R.id.image5);
        int imageResource5 = getResources().getIdentifier(uri[4], null, getPackageName());
        Drawable image5 = getResources().getDrawable(imageResource5);
        imageView5.setImageDrawable(image5);

        time = (TextView)findViewById(R.id.time);
        new CountDownTimer(2000,1000){
            public void onFinish(){
                Intent intent = new Intent();
                intent.setClass(Card_5.this, nextcard5.class);
                intent.putExtra("ran",ran);
                startActivity(intent);
            }

            public void onTick(long millisUntilFinished) {
            }
        }.start();
    }

    public boolean onKeyDown(int keyCode,KeyEvent event){

        if(keyCode==KeyEvent.KEYCODE_BACK && event.getRepeatCount()==0){   //確定按下退出鍵and防止重複按下退出鍵

            dialog();
        }

        return false;
    }

    private void dialog(){

        AlertDialog.Builder builder = new AlertDialog.Builder(Card_5.this); //創建訊息方塊

        builder.setMessage("確定要離開？");

        builder.setTitle("離開");

        builder.setPositiveButton("確認", new DialogInterface.OnClickListener()  {

            @Override

            public void onClick(DialogInterface dialog, int which) {

                dialog.dismiss(); //dismiss為關閉dialog,Activity還會保留dialog的狀態

                Allactivity.getInstance().exit();//關閉activity
            }
        });

        builder.setNegativeButton("取消", new DialogInterface.OnClickListener()  {

            @Override

            public void onClick(DialogInterface dialog, int which) {

                dialog.dismiss();
            }
        });

        builder.create().show();
    }
}
