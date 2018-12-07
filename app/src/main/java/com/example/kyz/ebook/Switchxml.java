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
import android.widget.Toast;

import static java.lang.Thread.sleep;


@SuppressLint("Registered")
public class Switchxml extends AppCompatActivity {

    private EditText Account;
    private EditText Pwd;
    private EditText test;
    private TextView test1;
    private TextView TV;
    Button btn_login;
    Button btn_regsi;
    Button zhuanzhang1;
    private SocketClient client;
    private SocketServer server;
    private int pite=6666;
    private String ip="";
    private String gupwd="密码错误";
    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sigin);
        btn_login = findViewById(R.id.login);
        btn_regsi=findViewById(R.id.register);
        zhuanzhang1=findViewById(R.id.zhuanzhang1);
        test=findViewById(R.id.test);
       // test1=findViewById(R.id.test1);
        TV=findViewById(R.id.tv);

        client=new SocketClient ();
        try {
            pite= 5555;
            ip="192.168.1.107";

            //服务端的IP地址和端口号
            client.clintValue (Switchxml.this,ip ,pite);

            //开启客户端接收消息线程
            client.openClientThread ();


        }catch (Exception e){
            Toast.makeText ( Switchxml.this,"请检查ip及地址", Toast.LENGTH_SHORT ).show ();
            e.printStackTrace ();
        }
        btn_login.setOnClickListener ( new View.OnClickListener ( )
        {
            @SuppressLint("HandlerLeak")
            @Override
            public void onClick(View v)
            {

        Account= findViewById ( R.id.account );
        Pwd= findViewById ( R.id.pwd);
        String user =(Account.getText()).toString();
        String  kk=(Pwd.getText()).toString();
               Log.e(user,"用户名");
               Log.e(kk,"密码");
                client.sendMsg ("login"+","+user+","+kk);
                try {
                    sleep(200);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

              //  startActivity ( new Intent( Switchxml.this,Tozhanghu.class ) );


            }
        } );
        btn_regsi.setOnClickListener ( new View.OnClickListener ( )
        {
            @Override
            public void onClick(View v)
            {

                startActivity ( new Intent( Switchxml.this,Tozhuce.class ) );

            }
        } );
        zhuanzhang1.setOnClickListener ( new View.OnClickListener ( )
        {
            @Override
            public void onClick(View v)
            {

                startActivity ( new Intent( Switchxml.this,Tozhuce.class ) );
            }
        } );
        SocketClient.mHandler=new Handler (  ){
            @Override
            public void handleMessage(Message msg)
            {
                Log.i ( "msghh",msg.obj.toString ());
             //   Yue.setText(msg.toString());
                test.requestFocus();
                test.setText ( msg.obj.toString ());
                if(gupwd.equals(msg.obj.toString()))
                {


                }

            }
        };




    }

}
