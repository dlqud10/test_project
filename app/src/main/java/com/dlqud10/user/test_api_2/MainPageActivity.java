/**
 * @file MainPageActivity.java
 * @brief The UI of using Main page
 * @author 이병현
 * @date 2018.05.09 ~ 2018.05.15
 * @version ERP v0.2
 * @state The main page of application
 */

package com.dlqud10.user.test_api_2;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.gson.Gson;


import java.net.*;
import java.io.*;
import java.util.concurrent.ExecutionException;

public class MainPageActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_page);


        TextView textview = (TextView)findViewById(R.id.textView);
        String resultText = "값이없음";

        try{
            resultText = new Task().execute().get();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

        textview.setText((resultText));


        Button buttonGoStatics = findViewById(R.id.buttonGoStatics) ;
        buttonGoStatics.setOnClickListener(new Button.OnClickListener() {

            @Override public void onClick(View v) {

                Intent intent = new Intent(MainPageActivity.this, StaticsActivity.class) ;

                startActivity(intent) ;


                }
        });

        Button buttonGoDate = findViewById(R.id.buttonGoDate) ;
        buttonGoDate.setOnClickListener(new Button.OnClickListener() {

            @Override public void onClick(View v) {

                Intent intent = new Intent(MainPageActivity.this, DateActivity.class) ;

                startActivity(intent) ;


            }
        });



    }
}
