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

public class AccountBookActivity extends AppCompatActivity {


        final static String folder = Environment.getExternalStorageDirectory().getAbsolutePath()+"/Test_Api";
        final static String filename = "test.txt";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_account_book);

        Log.d("path", folder);

        Button btnMakeText = (Button) findViewById(R.id.makeTextButton);
        btnMakeText.setOnClickListener(new Button.OnClickListener() {

            @Override
            public void onClick(View v) {
                mOnFileWrite(v);
            }

        });

        Button btnAddList = (Button) findViewById(R.id.addListButton);
        btnAddList.setOnClickListener(new Button.OnClickListener() {

            @Override
            public void onClick(View v) {


                URL url;
                HttpURLConnection urlConnection;
                BufferedInputStream bufInsTream = null;



                try {

                    //URL 지장
                    url = new URL("https://www.koreaexim.go.kr/site/program/financial/exchangeJSON?authkey=5bC4hLlng7kzfx5HpjA8lJFvs6ehjlV9&searchdate=&data=AP01");

                    //URL 접속
                    urlConnection = (HttpURLConnection) url.openConnection();

                    BufferedReader bufReader = new BufferedReader(new InputStreamReader(urlConnection.getInputStream(), "UTF-8"));
                    Log.d("line:", bufReader.toString());

                    String line;
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


                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    //버튼클릭
    public void mOnFileWrite(View v){
        String now = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
        String contents = "Log 생성 : "+now+"\n";

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

            dir.createNewFile();

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


    /*
    private void textFile()
    {

        String dirPath = getFilesDir().getAbsolutePath();
        File file = new File(dirPath);

        //일치하는 폴더가 없으면 생성
        if (!file.exists() )
        {
            file.mkdirs();
            Toast.makeText(this, "success", Toast.LENGTH_SHORT).show();
        }

        String testStr = "complete";
        File savefile = new File(dirPath+"/test.txt");
        try{
            FileOutputStream fos = new FileOutputStream(savefile);
            fos.write(testStr.getBytes());
            fos.close();
            Toast.makeText(this, " save Success", Toast.LENGTH_SHORT).show();;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    */


}