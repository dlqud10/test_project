package com.dlqud10.user.test_api_2;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class DateActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_date);


        Button buttonComplete = findViewById(R.id.buttonComplete) ;
        buttonComplete.setOnClickListener(new Button.OnClickListener() {

            @Override public void onClick(View v) {

                Intent intent = new Intent(DateActivity.this, AccountBookActivity.class) ;

                startActivity(intent) ;


            }
        });
    }
}
