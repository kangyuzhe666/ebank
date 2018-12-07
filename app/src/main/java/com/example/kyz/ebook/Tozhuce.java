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
import android.widget.Toast;

@SuppressLint("Registered")

public class Tozhuce extends AppCompatActivity {
    Button btn_rescm;
    private SocketClient client;
    private int pite=6666;
    private String ip="";
    private EditText res_user;
    private EditText res_pwd;
    private EditText zhuangtai;
    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.regsi);
        btn_rescm = findViewById(R.id.res_cm);
        res_user= findViewById ( R.id.res_user );
        res_pwd= findViewById ( R.id.res_pwd);
        zhuangtai= findViewById ( R.id.zhuangtai);
        client=new SocketClient ();
        try {
            pite= 5555;
            ip="192.168.1.107";

            //服务端的IP地址和端口号
            client.clintValue (Tozhuce.this,ip ,pite);

            //开启客户端接收消息线程
            client.openClientThread ();


        }catch (Exception e){
            Toast.makeText ( Tozhuce.this,"请检查ip及地址", Toast.LENGTH_SHORT ).show ();
            e.printStackTrace ();
        }
        btn_rescm.setOnClickListener ( new View.OnClickListener ( )
        {
            @Override
            public void onClick(View v)
            {   final String res_user1 =(res_user.getText()).toString();
                final String res_pwd1 =(res_pwd.getText()).toString();
               client.sendMsg ("reg"+","+res_user1+","+res_pwd1);

            }
        } );
        SocketClient.mHandler=new Handler(  ){
            @Override
            public void handleMessage(Message msg)
            {
                Log.i ( "msghh",msg.obj.toString ());
                zhuangtai.setText(msg.obj.toString ());
            }
        };
    }
}
