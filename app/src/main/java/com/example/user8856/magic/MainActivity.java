package com.example.user8856.magic;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.view.KeyEvent;



public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Allactivity.getInstance().addActivity(this);

        Button start = (Button)findViewById(R.id.startbtn);
        start.setOnClickListener(gamestart);
        Button exit = (Button)findViewById(R.id.exitbtn);
        exit.setOnClickListener(gameexit);
        Button about = (Button)findViewById(R.id.aboutbtn);
        about.setOnClickListener(gameabout);
    }

    private View.OnClickListener gamestart = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
          Intent intent = new Intent();
            intent.setClass(MainActivity.this,gamestart.class);
            startActivity(intent);
        }
    };

    private View.OnClickListener gameexit = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Allactivity.getInstance().exit();
        }
    };

    private View.OnClickListener gameabout = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            AlertDialog.Builder ad1 = new AlertDialog.Builder(MainActivity.this);
            ad1.setTitle("關於本程式");
            ad1.setMessage("作者：廖裕弘、李定睿、許中瀚、蘇冠睿\n版本：v_1.0");

            DialogInterface.OnClickListener listener1 = new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface di, int i) {
                }
            };
            ad1.setPositiveButton("確定", listener1);
            ad1.show();
        }
    };

    public boolean onKeyDown(int keyCode,KeyEvent event){

        if(keyCode==KeyEvent.KEYCODE_BACK && event.getRepeatCount()==0){   //確定按下退出鍵and防止重複按下退出鍵

            dialog();
        }

        return false;
    }

    private void dialog(){

        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this); //創建訊息方塊

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