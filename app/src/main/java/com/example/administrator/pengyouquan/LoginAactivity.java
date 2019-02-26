package com.example.administrator.pengyouquan;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class LoginAactivity extends AppCompatActivity {
    @BindView(R.id.login_denglu)
    Button loginDenglu;
    @BindView(R.id.login_zhuce)
    Button loginZhuce;
//    private Button Loginbutton, Longindenglu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);
        ButterKnife.bind(this);//绑定id小助手
        getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);

//        Loginbutton = (Button) findViewById(R.id.login_zhuce);
//        Longindenglu = (Button) findViewById(R.id.login_denglu);//登录按钮绑定id

//按了登录之后执行事件
//        Longindenglu.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Toast.makeText(LoginAactivity.this, "哈哈哈哈或或或或或或或或或或或或", Toast.LENGTH_SHORT).show();
//
//
//            }
//        });
//注册按钮点击跳转事件
//        Loginbutton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent;
//                intent = new Intent(LoginAactivity.this, RegisterActivity.class);
//                startActivity(intent);
//            }
//        });
    }

    @OnClick({R.id.login_denglu, R.id.login_zhuce})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.login_denglu:
                Toast.makeText(LoginAactivity.this, "哈哈哈哈或或或或或或或或或或或或", Toast.LENGTH_SHORT).show();
                break;
            case R.id.login_zhuce:
                Intent intent;
                intent = new Intent(LoginAactivity.this, RegisterActivity.class);
                startActivity(intent);
                break;
        }
    }
}
