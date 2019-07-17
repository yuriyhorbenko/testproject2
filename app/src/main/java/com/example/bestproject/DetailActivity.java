package com.example.bestproject;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

public class DetailActivity extends AppCompatActivity {

    private String TAG = "DetailActivity";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        Log.d(TAG, "DetailActivity: onCreate()");
        Intent intent = getIntent();
        String my_name = intent.getStringExtra("name");
        Integer my_age = intent.getIntExtra("age",14);
        TextView textView = findViewById(R.id.text_to_view);
        String text = my_name+". My age is "+my_age;
        textView.setText(text);
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d(TAG, "DetailActivity: onRestart()");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d(TAG, "DetailActivity: onStart()");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(TAG, "DetailActivity: onResume()");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(TAG, "DetailActivity: onPause()");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(TAG, "DetailActivity: onStop()");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "DetailActivity: onDestroy()");
    }
}
