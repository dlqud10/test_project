/**
 * @file AccountBookActivity.java
 * @brief The UI of using exchange rate page
 * @author 이병현
 * @date 2018.05.09
 * @version ERP v0.2
 * @state  make text file had success
 */

package com.dlqud10.user.test_api_2;

import java.io.*;


import android.os.Bundle;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;


import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.ExecutionException;

public class AccountBookActivity extends AppCompatActivity {


    static String now = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
    final static String folder = Environment.getExternalStorageDirectory().getAbsolutePath()+"/Exchange Rate";
    static String filename = now+".txt";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_account_book);

        Log.v("path", folder);

        Button btnMakeText = (Button) findViewById(R.id.makeTextButton);
        btnMakeText.setOnClickListener(new Button.OnClickListener() {

            @Override
            public void onClick(View v) {
                mOnFileWrite(v);
            }

        });

    }

    //버튼클릭
    public void mOnFileWrite(View v){

        String contents = null;
        try {
            contents = new Task().execute().get();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

        WriteTextFile(folder, filename, contents);
    }

    //텍스트내용을 경로의 텍스트 파일에 쓰기
    public void WriteTextFile(String foldername, String filename, String contents){
        try{
            File dir = new File (foldername);
            //디렉토리 폴더가 없으면 생성함
            if(!dir.exists()){
                dir.mkdir();
            }


            Toast.makeText(this, "파일생성 성공~", Toast.LENGTH_SHORT).show();

            //파일 output stream 생성
            FileOutputStream fos = new FileOutputStream(foldername+"/"+filename, true);
            //파일쓰기
            BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(fos));
            writer.write(contents);
            writer.flush();

            writer.close();
            fos.close();
        }catch (IOException e){
            Toast.makeText(this, "파일생성 실패~", Toast.LENGTH_SHORT).show();
        }
    }
}