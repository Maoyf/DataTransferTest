package com.cdivtc.datatransfertest;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    //定义三个变量
    private EditText etName;
    private EditText etPassword;
    private Button regist;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //绑定变量与控件
        //通过findViewById()方法来绑定
        etName = findViewById(R.id.et_name);
        etPassword = findViewById(R.id.et_psw);
        regist = findViewById(R.id.btn_regist);
    }

    public void regist(View view) {
        //创建Intent对象,跳转到ShowActivity
        Intent intent = new Intent(MainActivity.this, ShowActivity.class);
        //先获取值
        String name = etName.getText().toString().trim();
        String password = etPassword.getText().toString().trim();
        //定义bandle数据传递绑定
        Bundle bundle = new Bundle();
        bundle.putString("name",name);
        bundle.putString("password",password);
        intent.putExtras(bundle);

        /*intent.putExtra("name",etName.getText().toString().trim());
        intent.putExtra("password",etPassword.getText().toString().trim());*/
        startActivity(intent);

    }
}
