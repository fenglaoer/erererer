package com.example.administrator.pengyouquan;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.RequestParams;
import com.loopj.android.http.TextHttpResponseHandler;

import org.greenrobot.eventbus.EventBus;

import java.util.Timer;
import java.util.TimerTask;

import cz.msebera.android.httpclient.Header;

public class RegisterActivity extends AppCompatActivity {
    private String url = "http://132.232.42.76/BasePorject";
    private Button Yanzhengmabutton,Registerbutton;
    private int sum = 35;
    Timer timer;
    TimerTask timerTask;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.register);
        EventBus.getDefault().register(this);
        getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);

        Yanzhengmabutton =  (Button)findViewById(R.id.register_yanzhengma);
        Registerbutton = (Button)findViewById(R.id.Register_zhuche);
        intDate1();

        Registerbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
                intNetzhuce();

            }
        });
    }
//点击注册之后的网络访问
    private void intNetzhuce () {
        Toast.makeText(this, "你点击了注册，现在开始网络访问", Toast.LENGTH_SHORT).show();
    }




    //验证码的执行
    private void intDate1() {
        timer = new Timer();//实例化timer;
        Yanzhengmabutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                timerTask = new TimerTask(){
                    @Override
                    public void run() {
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                if (sum > 0) {
                                    sum--;
                                    Yanzhengmabutton.setText("(" + sum + ")后获取");
                                } else {
                                    timerTask.cancel();//停止计时器
                                    Yanzhengmabutton.setText("获取验证码");
                                    Yanzhengmabutton.setEnabled(true);
                                    sum = 20;
                                }
                            }
                        });
                    }
                };
                timer.schedule( timerTask,0,1000);
                Yanzhengmabutton.setEnabled(false);//设置倒计时中不可按

                AsyncHttpClient asyncHttpClient = new AsyncHttpClient();
                RequestParams requestParams = new RequestParams();
                requestParams.put("111","a");
                asyncHttpClient.get(url, requestParams, new TextHttpResponseHandler() {
                    @Override
                    public void onFailure(int i, Header[] headers, String s, Throwable throwable) {
                        Log.e("111","走了失败的");
                    }

                    @Override
                    public void onSuccess(int i, Header[] headers, String s) {

                    }
                });

            }
        });

    }


}
