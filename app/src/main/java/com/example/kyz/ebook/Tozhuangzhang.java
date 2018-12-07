package com.example.kyz.ebook;
import android.annotation.SuppressLint;
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
public class Tozhuangzhang extends AppCompatActivity {
    Button querenzhuangzhang;
    private EditText zhanghao;
    private EditText jin_e;
    private EditText mima;
    private SocketClient client;
    private int pite=6666;
    private String ip="";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.zhuanzhang);
        zhanghao= findViewById ( R.id.zhuangzhangzhanghao );
        jin_e= findViewById ( R.id.zhuangzhangjine);
        mima= findViewById ( R.id.zhuangzhangmima);
        querenzhuangzhang = findViewById(R.id.querenzhuangzhang);
        client=new SocketClient ();
        try {
            pite= 5555;
            ip="192.168.1.107";

            //服务端的IP地址和端口号
            client.clintValue (Tozhuangzhang.this,ip ,pite);

            //开启客户端接收消息线程
            client.openClientThread ();


        }catch (Exception e){
            Toast.makeText ( Tozhuangzhang.this,"请检查ip及地址", Toast.LENGTH_SHORT ).show ();

            e.printStackTrace ();
        }
        querenzhuangzhang.setOnClickListener ( new View.OnClickListener ( )
        {
            @Override
            public void onClick(View v)
            {
                String zhanghao1 =(zhanghao.getText()).toString();
                String jin_e1 =(jin_e.getText()).toString();
                String mima1 =(mima.getText()).toString();
                Log.e(zhanghao1,"账户");
                Log.e(jin_e1,"金额");
                Log.e(mima1,"密码");
                client.sendMsg ("tran_acc"+","+zhanghao1+","+jin_e1+","+mima1);

            }
        } );



        SocketClient.mHandler=new Handler(  ){
            @Override
            public void handleMessage(Message msg)
            {
                //  txt.setText ( msg.obj.toString ());
                Log.i ( "msghh",msg.obj.toString ());
            }
        };

    }
}
