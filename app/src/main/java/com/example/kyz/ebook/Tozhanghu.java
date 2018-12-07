package com.example.kyz.ebook;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


@SuppressLint("Registered")
public class Tozhanghu extends AppCompatActivity {
    Button btn_zhuangzhang;
    private EditText Yue;
    private TextView TV;
    String a="";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.yu_e);
        Yue=findViewById(R.id.yue);
        TV=findViewById(R.id.tv);
        btn_zhuangzhang = findViewById(R.id.zhuangzhang);
        btn_zhuangzhang.setOnClickListener ( new View.OnClickListener ( )
        {
            @Override
            public void onClick(View v)
            {

                startActivity ( new Intent( Tozhanghu.this,Tozhuangzhang.class ) );
            }
        } );



        SocketClient.mHandler=new Handler(  ){
            @Override
            public void handleMessage(Message msg)
            {
                Log.i ( "msghh",msg.obj.toString ());


                a=msg.toString();
                Log.e(a,"标记");
            }
        };



    }

}

