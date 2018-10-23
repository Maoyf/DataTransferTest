package com.cdivtc.datatransfertest;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

public class ShopActivity extends AppCompatActivity {
    //定义两个变量
    private ItemInfo itemInfo;//通过itemInfo获取商品信息，可以调用对应的方法
    private LinearLayout layout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shop);
        //绑定变量与控件
        layout = findViewById(R.id.ll_layout);
        TextView tvName = findViewById(R.id.tv_name);
        TextView tvLife = findViewById(R.id.tv_life);
        TextView tvSpeed = findViewById(R.id.tv_speed);
        TextView tvAttack = findViewById(R.id.tv_attack);
        //初始化商品
        itemInfo = new ItemInfo("金剑",20,100,20);
        //将商品信息加载到控件
        tvName.setText(itemInfo.getName()+"");
        tvLife.setText("生命值"+itemInfo.getLife());
        tvAttack.setText("攻击力"+itemInfo.getAttack());
        tvSpeed.setText("敏捷度"+itemInfo.getSpeed());
    }

    public void buy(View view) {
        //通过Intent实现数据的传递
        //实例化一个Intent
        Intent intent = new Intent();
        //将附加信息添加到intent中
        intent.putExtra("equipment",itemInfo);
        //调用setResult方法将数据回传到请求方
        setResult(1,intent);
        //调用finish()方法销毁当前 的活动
        finish();
    }
}
