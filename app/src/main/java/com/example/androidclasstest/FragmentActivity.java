package com.example.androidclasstest;

import android.support.v7.app.AppCompatActivity;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.androidclasstest.fragment.AnotherRightFragment;
import com.example.androidclasstest.fragment.RightFragment;

public class FragmentActivity extends AppCompatActivity implements View.OnClickListener{
    boolean flag=true;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragment);
        Button button = findViewById(R.id.fragment_button);
        button.setOnClickListener(this);
        replaceFragment(new RightFragment());
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.fragment_button:
                if(flag)
                {replaceFragment(new AnotherRightFragment());flag = false;}
                else if(!flag){
                    replaceFragment(new RightFragment());
                    flag = true;
                }
                break;
            default:break;
        }

    }

    private void replaceFragment(Fragment fragment) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.replace(R.id.right_layout, fragment);
        transaction.commit();
    }


}
