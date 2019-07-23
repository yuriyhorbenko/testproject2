package com.example.bestproject;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

public class MainActivity extends AppCompatActivity {
Context ctx;

private String TAG = "MainActivity";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d(TAG, "MainActivity: onCreate()");
        ctx = this;
        final String name = "yura";
        TextView textView1 = findViewById(R.id.text1);
        textView1.setText("my name is Yura");

        Button open_button =findViewById(R.id.open_button);
        open_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Intent intent = new Intent(ctx,DetailActivity.class);
//                intent.putExtra("name","My name is Yura");
//                intent.putExtra("age",25);
                Intent sprefIntent =  new Intent(ctx,DBActivity.class);
                startActivity(sprefIntent);
            }
        });



        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                HttpGet httppost = new HttpGet("https://auto.ria.com/newauto_blocks/marka/models?lang_id=2&category_id=1&marka_id=9");
                HttpClient httpclient = new DefaultHttpClient();
                try {
                    HttpResponse response = httpclient.execute(httppost);
                    int status = response.getStatusLine().getStatusCode();

                    if (status == 200) { // ok
                        HttpEntity entity = response.getEntity();
                        String data = EntityUtils.toString(entity);
                                Log.d("okok","data ="+data);
                        JSONObject jsonobj = new JSONObject(data);
                        JSONArray marka_arr = jsonobj.getJSONArray("models");
                        Log.d("okok", "jsonobj  =" + jsonobj);
                        Log.d("okok", "marka_arr  =" + marka_arr);
                    }


                } catch (IOException e) {
                    e.printStackTrace();
                }
                catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        });

        thread1.start();
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d(TAG, "MainActivity: onRestart()");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d(TAG, "MainActivity: onStart()");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(TAG, "MainActivity: onResume()");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(TAG, "MainActivity: onPause()");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(TAG, "MainActivity: onStop()");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "MainActivity: onDestroy()");
    }
}
