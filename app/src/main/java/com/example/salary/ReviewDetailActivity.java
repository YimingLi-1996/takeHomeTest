package com.example.salary;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.salary.objects.ReviewObject;

public class ReviewDetailActivity extends AppCompatActivity {
    TextView titleText;
    TextView careerOpportunitiesRating;
    TextView ceoRating;
    TextView compensationAndBenefitsRating;
    TextView  cultureAndValuesRating;
    TextView  seniorLeadershipRating;
    TextView  workLifeBalanceRating;
    TextView  pros;
    TextView  cons;
    TextView  advice;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        initView();
        initData();
    }

    private void initView() {
        titleText =  findViewById(R.id.title);
        careerOpportunitiesRating =  findViewById(R.id.careerOpportunitiesRating);
        ceoRating =  findViewById(R.id.ceoRating);
        compensationAndBenefitsRating =  findViewById(R.id.compensationAndBenefitsRating);
        cultureAndValuesRating =  findViewById(R.id.cultureAndValuesRating);
        seniorLeadershipRating =  findViewById(R.id.seniorLeadershipRating);
        workLifeBalanceRating =  findViewById(R.id.workLifeBalanceRating);
        pros =  findViewById(R.id.pros);
        cons =  findViewById(R.id.cons);
        advice =  findViewById(R.id.advice);

    }
    private void initData() {
        ReviewObject object = (ReviewObject) getIntent().getSerializableExtra("bean");
        titleText.setText(object.getHeadline());
        careerOpportunitiesRating.setText(object.getCareerOpportunitiesRating()+".0");
        ceoRating.setText(object.getCeoRating()+".0");
        compensationAndBenefitsRating.setText(object.getCompensationAndBenefitsRating()+".0");
        cultureAndValuesRating.setText(object.getCultureAndValuesRating()+".0");
        seniorLeadershipRating.setText(object.getSeniorLeadershipRating()+".0");
        workLifeBalanceRating.setText(object.getWorkLifeBalanceRating()+".0");
        pros.setText(object.getPros());
        cons.setText(object.getCons());
        advice.setText(object.getAdvice());


    }
   public void goBack(View view){
     finish();
    }
}