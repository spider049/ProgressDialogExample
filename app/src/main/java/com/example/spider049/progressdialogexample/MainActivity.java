package com.example.spider049.progressdialogexample;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.app.Activity;
import android.app.ProgressDialog;
// import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
// import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

/**
 * Android ProgressDialog example
 * @author Prabu Dhanapal
 * @version 1.0
 * @since SEP 01 2013
 *
 */
public class MainActivity extends Activity {
    Button button;
    ProgressDialog progressDoalog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button = (Button) findViewById(R.id.button1);
        button.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                progressDoalog = new ProgressDialog(MainActivity.this);
                progressDoalog.setMax(100);
                progressDoalog.setMessage("Its loading....");
                progressDoalog.setTitle("ProgressDialog bar example");
                progressDoalog.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
                progressDoalog.show();
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        try {
                            while (progressDoalog.getProgress() <= progressDoalog
                                    .getMax()) {
                                Thread.sleep(50);
                                handle.sendMessage(handle.obtainMessage());
                                if (progressDoalog.getProgress() == progressDoalog
                                        .getMax()) {
                                    progressDoalog.dismiss();
                                }
                            }
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                }).start();
            }

            Handler handle = new Handler() {
                @Override
                public void handleMessage(Message msg) {
                    super.handleMessage(msg);
                    progressDoalog.incrementProgressBy(1);
                }
            };
        });
    }



}
