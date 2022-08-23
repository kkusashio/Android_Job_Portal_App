package com.example.portal_app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

public class Home extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        //findViewById(R.id.btSearch).setOnClickListener(this);
        // 「遷移」ボタンをタップしたらonClick()を呼び出す
        //findViewById(R.id.btLink).setOnClickListener(this);
        // 日付ボタンをタップしたらonClick()を呼び出す
        //findViewById(R.id.etStart).setOnClickListener(this);
        //findViewById(R.id.etEnd).setOnClickListener(this);
    }

    @Override
    protected void onRestart(){
        super.onRestart();
        startActivity(new Intent(this,MainActivity.class));
    }
}