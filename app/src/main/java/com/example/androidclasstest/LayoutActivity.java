package com.example.androidclasstest;

import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.style.TtsSpan;
import android.view.View;
import android.widget.Button;

public class LayoutActivity extends AppCompatActivity implements View.OnClickListener{

    private Button AlertDialogButton;
    private Button ProgressDialogButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_layout);
        AlertDialogButton = findViewById(R.id.layout_button_AlertDialog);
        AlertDialogButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder dialog = new AlertDialog.Builder(LayoutActivity.this);
                dialog.setTitle("Test Dialog");
                dialog.setMessage("This is Dialog");
                dialog.setCancelable(false);
                dialog.setPositiveButton("确定", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                    }
                });
                dialog.setNegativeButton("取消", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                    }
                });
                dialog.show();
            }
        });
        ProgressDialogButton = findViewById(R.id.layout_button_ProgressDialog);
        ProgressDialogButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ProgressDialog progressDialog = new ProgressDialog(LayoutActivity.this);
                progressDialog.setTitle("Test ProgressDialog");
                progressDialog.setMessage("加载中...");
                progressDialog.setCancelable(true);
                progressDialog.show();
            }
        });



    }

    @Override
    public void onClick(View view) {

    }
}
