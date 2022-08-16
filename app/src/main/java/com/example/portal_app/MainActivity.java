package com.example.portal_app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    View pin_01, pin_02,pin_03,pin_04;
    Button btn_clear,btn_00,btn_01,btn_02,btn_03,btn_04,btn_05,btn_06,btn_07,btn_08,btn_09;
    ArrayList<String> numbers_list = new ArrayList<>();
    String passCode="";
    String num_01,num_02,num_03,num_04;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initializeComponents();
    }

    private void initializeComponents(){
        pin_01=findViewById(R.id.pin_01);
        pin_02=findViewById(R.id.pin_02);
        pin_03=findViewById(R.id.pin_03);
        pin_04=findViewById(R.id.pin_04);

        btn_clear=findViewById(R.id.btn_clear);
        btn_00=findViewById(R.id.btn_00);
        btn_01=findViewById(R.id.btn_01);
        btn_02=findViewById(R.id.btn_02);
        btn_03=findViewById(R.id.btn_03);
        btn_04=findViewById(R.id.btn_04);
        btn_05=findViewById(R.id.btn_05);
        btn_06=findViewById(R.id.btn_06);
        btn_07=findViewById(R.id.btn_07);
        btn_08=findViewById(R.id.btn_08);
        btn_09=findViewById(R.id.btn_09);

        btn_clear.setOnClickListener(this);
        btn_00.setOnClickListener(this);
        btn_01.setOnClickListener(this);
        btn_02.setOnClickListener(this);
        btn_03.setOnClickListener(this);
        btn_04.setOnClickListener(this);
        btn_05.setOnClickListener(this);
        btn_06.setOnClickListener(this);
        btn_07.setOnClickListener(this);
        btn_08.setOnClickListener(this);
        btn_09.setOnClickListener(this);


    }

    @Override
    public void onClick(View view){
        switch(view.getId()){
            case R.id.btn_clear:
                break;
            case R.id.btn_00:
                numbers_list.clear();
                passNumber(numbers_list);
                break;
            case R.id.btn_01:
                numbers_list.add("1");
                passNumber(numbers_list);
                break;
            case R.id.btn_02:
                numbers_list.add("2");
                passNumber(numbers_list);
                break;
            case R.id.btn_03:
                numbers_list.add("3");
                passNumber(numbers_list);
                break;
            case R.id.btn_04:
                numbers_list.add("4");
                passNumber(numbers_list);
                break;
            case R.id.btn_05:
                numbers_list.add("5");
                passNumber(numbers_list);
                break;
            case R.id.btn_06:
                numbers_list.add("6");
                passNumber(numbers_list);
                break;
            case R.id.btn_07:
                numbers_list.add("7");
                passNumber(numbers_list);
                break;
            case R.id.btn_08:
                numbers_list.add("8");
                passNumber(numbers_list);
                break;
            case R.id.btn_09:
                numbers_list.add("9");
                passNumber(numbers_list);
                break;

        }

    }

    private void passNumber(ArrayList<String> numbers_list) {
        if(numbers_list.size()==0){
            pin_01.setBackgroundResource(R.drawable.login_grey_circle);
            pin_02.setBackgroundResource(R.drawable.login_grey_circle);
            pin_03.setBackgroundResource(R.drawable.login_grey_circle);
            pin_04.setBackgroundResource(R.drawable.login_grey_circle);
        }else{
            switch (numbers_list.size()){
                case 1:
                    num_01=numbers_list.get(0);
                    pin_01.setBackgroundResource(R.drawable.login_blue_circle);
                    break;
                case 2:
                    num_01=numbers_list.get(1);
                    pin_02.setBackgroundResource(R.drawable.login_blue_circle);
                    break;
                case 3:
                    num_01=numbers_list.get(2);
                    pin_03.setBackgroundResource(R.drawable.login_blue_circle);
                    break;
                case 4:
                    num_01=numbers_list.get(3);
                    pin_04.setBackgroundResource(R.drawable.login_blue_circle);
                    passCode= num_01+num_02+num_03+num_04;
                    if(getPassCode().length()==0){
                        savePassCode(passCode);
                    }else{
                        matchPassCode();

                    }
                    break;
            }
        }
    }
    private void matchPassCode(){
        if (getPassCode().equals(passCode)){
            startActivity(new Intent(this, Home.class));
        }else{
            Toast.makeText(this,"PASSCODE ERROR", Toast.LENGTH_SHORT).show();
        }
    }

    private SharedPreferences.Editor savePassCode(String passcode){
        SharedPreferences preferences=getSharedPreferences("passcode_pref", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = preferences.edit();
        editor.putString("passcode",passCode);
        editor.commit();

        return editor;
    }

    private String getPassCode(){
        SharedPreferences preferences = getSharedPreferences("passcode_pref", Context.MODE_PRIVATE);
        return preferences.getString("passcode","");

    }
}