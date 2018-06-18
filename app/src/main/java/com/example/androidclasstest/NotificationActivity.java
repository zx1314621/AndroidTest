package com.example.androidclasstest;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class NotificationActivity extends AppCompatActivity {


    private Button notification;
    private Button toast;
    private NotificationManager notificationManager;

    public static final int NOTIFICATION_ID = 1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notification);
        notification = findViewById(R.id.notification);
        notificationManager = (NotificationManager)getSystemService(Context.NOTIFICATION_SERVICE);
        toast = findViewById(R.id.toast);

        toast.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(NotificationActivity.this,"This is a Toast",Toast.LENGTH_SHORT).show();
            }
        });
        notification.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sendNotification();
            }
        });
    }

    public void sendNotification(){
        Notification notification = new Notification.Builder(this)
                .setSmallIcon(R.mipmap.ic_launcher)//设置小图标
                .setContentTitle("title title title ")
                .setContentText("text text text")
                .build();
        NotificationManager notificationManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        notificationManager.notify(0, notification);

        PendingIntent pendingIntent = PendingIntent.getActivity(this, 0, new Intent(this,NotificationActivity.class), 0);

        notification.contentIntent = pendingIntent;
        notification.flags = Notification.FLAG_AUTO_CANCEL;
    }
}
