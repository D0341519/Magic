package com.example.user8856.magic;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


public class nextcard5 extends AppCompatActivity {

    int rannext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nextcard5);
        Allactivity.getInstance().addActivity(this);

        Button start = (Button)findViewById(R.id.next4bt);
        start.setOnClickListener(nextpage);

        Intent intent = getIntent();
        rannext = intent.getIntExtra("ran", 1);
    }

    private View.OnClickListener nextpage = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent intent = new Intent();
            intent.putExtra("ran",rannext);
            intent.setClass(nextcard5.this, Card_4.class);
            startActivity(intent);
        }
    };

    public boolean onKeyDown(int keyCode,KeyEvent event){

        if(keyCode==KeyEvent.KEYCODE_BACK && event.getRepeatCount()==0){   //確定按下退出鍵and防止重複按下退出鍵

            dialog();
        }

        return false;
    }

    private void dialog(){

        AlertDialog.Builder builder = new AlertDialog.Builder(nextcard5.this); //創建訊息方塊

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
