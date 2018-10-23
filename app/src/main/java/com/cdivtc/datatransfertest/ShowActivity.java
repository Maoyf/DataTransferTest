package com.cdivtc.datatransfertest;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

public class ShowActivity extends AppCompatActivity {
    //定义变量
    private TextView tvName;
    private TextView tvPassword;

    //定义获取商品信息的变量
    private ProgressBar lifeBar;
    private ProgressBar attackBar;
    private ProgressBar speedBar;
    private TextView myLife;
    private TextView myAttack;
    private TextView mySpeed;

    private Button mybuy;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show);
        //绑定变量与控件
        tvName = findViewById(R.id.tv_name);
        tvPassword = findViewById(R.id.tv_password);

        //接收数据
        //1、获取Intent对象
        //通过Bundle来获取Intene中的值
        Bundle bundle = getIntent().getExtras();
        //取值
        String name = bundle.getString("name");
        String password = bundle.getString("password");
       /* Intent intent = getIntent();
        //2、取值  通过key取到对应的value
        String name = intent.getStringExtra("name");
        String password = intent.getStringExtra("password");*/
        //3、将获取到的值 通过tv_name 和tv_passwrod这两个控件显示出来
        tvName.setText("用户名："+name);
        tvPassword.setText("密    码："+password);

        //绑定变量与控件
        //绑定进度条
        lifeBar = findViewById(R.id.lifeBar);
        attackBar = findViewById(R.id.attackBar);
        speedBar = findViewById(R.id.speedBar);
        //设置最大值
        lifeBar.setMax(1000);
        attackBar.setMax(1000);
        speedBar.setMax(1000);
        //绑定的文本框
        myLife = findViewById(R.id.tv_life_progress);
        myAttack = findViewById(R.id.tv_attack_progress);
        mySpeed = findViewById(R.id.tv_speed_progress);

    }

    public void buy(View view) {
        //发送购买的请求
        //通过intent到ShopActivity去购买商品
        Intent intent = new Intent(this, ShopActivity.class);
        //要求有返回数据的启动Activity
        startActivityForResult(intent,1);
    }

    //重写onActivityResult方法用来接收回传的数据
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (data != null){
            if (requestCode ==1){
                if (resultCode ==1){
                    ItemInfo info = (ItemInfo) data.getSerializableExtra("equipment");
                    //更新progressBar和textView的值
                    //定义三个整型变量，用来存放之前的Progress的值
                    int proLife = lifeBar.getProgress();
                    int proAttack = attackBar.getProgress();
                    int proSpeed = speedBar.getProgress();
                    //更新ProgressBar的值
                    lifeBar.setProgress(proLife+info.getLife());
                    attackBar.setProgress(proAttack+info.getAttack());
                    speedBar.setProgress(proSpeed+info.getSpeed());
                    //更新三个TextView的值
                    myLife.setText(lifeBar.getProgress()+"");
                    myAttack.setText(attackBar.getProgress()+"");
                    mySpeed.setText(speedBar.getProgress()+"");
                }
            }
        }
    }
}
