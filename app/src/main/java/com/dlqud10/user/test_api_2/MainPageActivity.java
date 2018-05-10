/**
 * @file MainPageActivity.java
 * @brief The UI of using Main page
 * @author 이병현
 * @date 2018.05.10
 * @version ERP v0.2
 * @state The main page of application
 */

package com.dlqud10.user.test_api_2;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainPageActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_page);

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
