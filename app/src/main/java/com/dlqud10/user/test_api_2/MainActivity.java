/**
 * @file MainActivity.java
 * @brief The UI of using exchange rate page
 * @author 이병현
 * @date 2018.05.03
 * @version ERP v0.1
 * @state The function of parsing json text in URL is unsuccessful
 */

package com.dlqud10.user.test_api_2;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;


import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btn = (Button) findViewById(R.id.addListButton);
        btn.setOnClickListener(new Button.OnClickListener() {


            @Override
            public void onClick(View v) {

                EditText et = (EditText) findViewById(R.id.editText);

                URL url = null;
                HttpURLConnection urlConnection = null;
                BufferedInputStream buf = null;

                et.append("ok");

                try {

                    //URL 지장
                    url = new URL("https://www.koreaexim.go.kr/site/program/financial/exchangeJSON?authkey=5bC4hLlng7kzfx5HpjA8lJFvs6ehjlV9&searchdate=&data=AP01");

                    //URL 접속
                    urlConnection = (HttpURLConnection) url.openConnection();

                    BufferedReader bufReader = new BufferedReader(new InputStreamReader(urlConnection.getInputStream(), "UTF-8"));
                    Log.d("line:", bufReader.toString());

                    String line = null;
                    String page = "";

                    while ((line = bufReader.readLine()) != null) {
                        Log.d("line:", line);
                        page += line;
                    }

                    JsonParser jsonParser = new JsonParser();

                    JsonObject json = (JsonObject) jsonParser.parse(page);


                    JsonElement curl_unit = json.get("curl_unit");
                    JsonObject curl_nm = json.getAsJsonObject("curl_nm");
                    System.out.println("curl_unit:" + curl_unit + "curl_nm:" + curl_nm);

                    // et.append(curl_unit+"\n");
                    // et.append(curl_nm+"\n");


                } catch (Exception e) {
                    //et.setText(e.getMessage());
                } finally {
                    urlConnection.disconnect();
                }

            }
        });


    }
}
