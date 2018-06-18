package com.example.androidclasstest;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private Button fragment;
    private Button layout;
    private Button volley;
    private Button activity1;
    private Button service;
    private Button notification;
    private Button sqlite;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d("MainActivity","onCreate");
        setContentView(R.layout.activity_main);
        init();
    }
    private void init() {
        fragment = findViewById(R.id.fragment);
        fragment.setOnClickListener(this);
        layout = findViewById(R.id.layout);
        layout.setOnClickListener(this);
        volley = findViewById(R.id.volley);
        volley.setOnClickListener(this);
        activity1 = findViewById(R.id.activity1);
        activity1.setOnClickListener(this);
        service = findViewById(R.id.service);
        service.setOnClickListener(this);
        notification = findViewById(R.id.notification);
        notification.setOnClickListener(this);
        sqlite = findViewById(R.id.sqlite);
        sqlite.setOnClickListener(this);

    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d("MainActivity","onStart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d("MainActivity","onResume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d("MainActivity","onPause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d("MainActivity","onStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("MainActivity","onDestroy");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d("MainActivity","onRestart");
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.fragment:{
                Intent intent = new Intent(MainActivity.this, FragmentActivity.class);
                startActivity(intent);
                break;
            }
            case R.id.layout:{
                Intent intent = new Intent(MainActivity.this, LayoutActivity.class);
                startActivity(intent);
                break;

            }
            case R.id.volley:{
                Intent intent = new Intent(MainActivity.this, VolleyActivity.class);
                startActivity(intent);
                break;
            }
            case R.id.activity1:{
                Intent intent = new Intent(MainActivity.this, AsyncTaskActivity.class);
                startActivity(intent);
                break;
            }
            case R.id.service:{
                Intent intent = new Intent(MainActivity.this, ServiceActivity.class);
                startActivity(intent);
                break;
            }
            case R.id.notification:{
                Intent intent = new Intent(MainActivity.this, NotificationActivity.class);
                startActivity(intent);
                break;
            }
            case R.id.sqlite:{
                Intent intent = new Intent(MainActivity.this, SqliteActivity.class);
                startActivity(intent);
                break;
            }
        }

    }
}
