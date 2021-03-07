package com.example.salary;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.salary.objects.SalaryObject;

public class SalaryDetailActivity extends AppCompatActivity {
    TextView employerName;
    TextView jobTitle;
    TextView location;
    TextView reviewDateTime;
    TextView amount;
    TextView meanBasePay;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_salary_detail);
        initView();
        initData();
    }

    private void initView() {
        employerName =  findViewById(R.id.employerName);
        jobTitle =  findViewById(R.id.jobTitle);
        location = findViewById(R.id.location);
        reviewDateTime = findViewById(R.id.reviewDateTime);

        amount = findViewById(R.id.amount);
        meanBasePay = findViewById(R.id.meanBasePay);


    }
    private void initData() {
        SalaryObject object = (SalaryObject) getIntent().getSerializableExtra("bean");
        employerName.setText(object.getEmployerName());
        jobTitle.setText(object.getJobTitle());
        location.setText(object.getLocation());
        reviewDateTime.setText(object.getReviewDateTime());
        amount.setText(object.getBasePay().getSymbol() + object.getBasePay().getAmount());
        meanBasePay.setText(object.getMeanBasePay().getSymbol() + object.getMeanBasePay().getAmount());
    }
    public void goBack(View view){
        finish();
    }
}