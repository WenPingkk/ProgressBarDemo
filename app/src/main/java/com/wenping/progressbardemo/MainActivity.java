package com.wenping.progressbardemo;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private static final int CONSTANT_MSG_WHAT = 1;
    private ProgressView mViewDatasProgress;
    private ProgressView mViewUserProgress;
    private int mProgress;

    private Handler mHandler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            switch (msg.what) {
                case CONSTANT_MSG_WHAT:
                    operDatas();
                    break;
            }
        }
    };

    private void operDatas() {
        mProgress++;
        mViewDatasProgress.setCurrentProgress(mProgress);
        mViewDatasProgress.setLeftTitle("当前已经用内存:" + mProgress + "M");
        mViewDatasProgress.setrightTitle("总内存100M");

        mViewUserProgress.setCurrentProgress(mProgress);
        mViewUserProgress.setLeftTitle("当前在线用户:" + mProgress);
        mViewUserProgress.setrightTitle("总用户数量" + 100);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();

        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 100; i++) {
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    mHandler.sendEmptyMessage(CONSTANT_MSG_WHAT);
                    if (i ==88) {
                        break;
                    }
                }
            }
        }).start();
    }

    private void initView() {
        mViewDatasProgress = (ProgressView) findViewById(R.id.viewDatasProgress);
        mViewUserProgress = (ProgressView) findViewById(R.id.viewUserProgress);
    }
}
