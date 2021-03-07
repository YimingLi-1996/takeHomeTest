package com.example.salary;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;

import com.example.salary.adapters.QuestionAdapter;
import com.example.salary.objects.InterviewObject;

public class InterviewDetailActivity extends AppCompatActivity {
    TextView jobTitle;

    TextView  processAnswer;
    ListView listview;
    private QuestionAdapter adapter;
    TextView  advice;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_interview_detail);
        initView();
        initData();
    }

    private void initView() {
        jobTitle =  findViewById(R.id.jobTitle);
        processAnswer =  findViewById(R.id.processAnswer);
        listview =  findViewById(R.id.listview);








    }
    private void initData() {
        InterviewObject object = (InterviewObject) getIntent().getSerializableExtra("bean");
        jobTitle.setText(object.getJobTitle());
        adapter = new QuestionAdapter(this, object.getQuestions());
        listview.setAdapter(adapter);
        processAnswer.setText(object.getProcessAnswer());

    }
    public void goBack(View view){
        finish();
    }
}