package com.example.salary;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.salary.adapters.MyAdapter;
import com.example.salary.objects.BaseObject;
import com.example.salary.objects.InterviewObject;
import com.example.salary.objects.ReviewObject;
import com.example.salary.objects.SalaryObject;
import com.google.gson.Gson;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ArrayList<BaseObject> datas;
    ListView listview;
    private MyAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        datas = new ArrayList<>();
        initView();
        getData();
    }

    private void initView() {
        listview = findViewById(R.id.listview);
        adapter = new MyAdapter(this, datas);
        listview.setAdapter(adapter);
        listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                BaseObject bean = datas.get(i);
                Intent intent = new Intent();
                if (bean.getType().equals("REVIEW_RESULT")){
                    intent.setClass(MainActivity.this, ReviewDetailActivity.class);
                }else  if (bean.getType().equals("INTERVIEW_RESULT")){
                    intent.setClass(MainActivity.this, InterviewDetailActivity.class);
                }else{
                    intent.setClass(MainActivity.this, SalaryDetailActivity.class);
                }

                intent.putExtra("bean",bean);
                startActivity(intent);
            }
        });

    }
    private void getData() {
        datas.clear();
//        String url = "https://raw.githubusercontent.com/vikrama/feed-json-sample/master/feed.json";
        String jsonString = getJson("feed.json",this);
        try {
            JSONObject response = new JSONObject(jsonString);
            JSONArray results = response.getJSONObject("response").getJSONArray("results");
            for (int i = 0; i < results.length(); i++) {
                JSONObject data = results.getJSONObject(i);
                String type = data.getString("type");
                JSONObject jsonObject = null;
                BaseObject object = null;
                Class typetoken = null;
                if (type.equals("REVIEW_RESULT")){
                    jsonObject =  data.getJSONObject("review");
                    typetoken = ReviewObject.class;
                }else if (type.equals("INTERVIEW_RESULT")){
                    jsonObject =  data.getJSONObject("interview");
                    typetoken = InterviewObject.class;
                }else {
                    jsonObject =  data.getJSONObject("salary");
                    typetoken = SalaryObject.class;
                }

                Gson gson = new Gson();
                object = (BaseObject) gson.fromJson(jsonObject.toString(),typetoken);
                object.setType(type);
//                if (type.equals("INTERVIEW_RESULT")){
//                    InterviewObject interviewObject = (InterviewObject)object;
//                    for (int j = 0; j < interviewObject.getQuestions().size(); j++) {
//                     JSONObject ques = (JSONObject) jsonObject.getJSONArray("questions").get(j);
//                     QuestionObject questionObject = interviewObject.getQuestions().get(j);
//                     questionObject.setResponseText(ques.get(""));
//                    }
//                }
                datas.add(object);
            }
            adapter.notifyDataSetChanged();
            Log.i("TAG", "getData: ");
        } catch (JSONException e) {
            e.printStackTrace();
        }


    }
    public  String getJson(String fileName, Context context){
        StringBuilder stringBuilder = new StringBuilder();
        try {
            InputStream is = context.getAssets().open(fileName);
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(is));
            String line;
            while ((line=bufferedReader.readLine()) != null){
                stringBuilder.append(line);
            }
            Log.i("TAG", "getJson: "+stringBuilder.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }

        return stringBuilder.toString();
    }

}