package com.example.salary.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.salary.objects.BaseObject;
import com.example.salary.objects.InterviewObject;
import com.example.salary.R;
import com.example.salary.objects.ReviewObject;
import com.example.salary.objects.SalaryObject;

import java.util.List;

public class MyAdapter extends BaseAdapter {
    Context context;
    List<BaseObject> beans;
    public MyAdapter(Context context, List<BaseObject> beans) {
        this.context = context;
        this.beans = beans;
    }
    @Override
    public int getCount() {
        return beans.size();
    }

    @Override
    public Object getItem(int position) {
        return beans.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Holder holder = null;
        if(null == convertView) {
            holder = new Holder();
            convertView = LayoutInflater.from(context).inflate(R.layout.layout_item, parent,false);
            holder.typeText = convertView.findViewById(R.id.type);
            holder.titleText1 = convertView.findViewById(R.id.title1);
            holder.titleText2 = convertView.findViewById(R.id.title2);
            holder.titleText3 = convertView.findViewById(R.id.title3);
            holder.companyText = convertView.findViewById(R.id.company);
            holder.logo = convertView.findViewById(R.id.logo);
            convertView.setTag(holder);
        }else {
            holder = (Holder)convertView.getTag();
        }

        BaseObject bean = beans.get(position);
        holder.typeText.setText(bean.getType().equals("REVIEW_RESULT")?"Review":bean.getType().equals("INTERVIEW_RESULT")?"Interview":"Salary");

        if (bean.getType().equals("REVIEW_RESULT")) {
            ReviewObject reviewObject = (ReviewObject)bean;
            holder.titleText1.setText(reviewObject.getEmployerName());
            holder.titleText2.setText(reviewObject.getJobTitleFromDb());
            holder.titleText3.setText(reviewObject.getHeadline());
            holder.companyText.setText(reviewObject.getJobTitle());
            Glide.with(context).load(((ReviewObject) bean).getSqLogoUrl()).into(holder.logo);
        } else if (bean.getType().equals("INTERVIEW_RESULT")) {
            InterviewObject interviewObject = (InterviewObject)bean;
            holder.titleText1.setText(interviewObject.getEmployerName());
            holder.titleText2.setText(interviewObject.getProcessOverallExperience());
            holder.titleText3.setText(interviewObject.getProcessDifficulty());
            holder.companyText.setText(interviewObject.getJobTitle());
            Glide.with(context).load(interviewObject.getSquareLogo()).into(holder.logo);
        } else {
            SalaryObject salaryObject = (SalaryObject)bean;
            holder.titleText1.setText(salaryObject.getEmployerName());
            holder.titleText2.setText(salaryObject.getLocation());
            holder.titleText3.setText(salaryObject.getReviewDateTime());
            holder.companyText.setText(salaryObject.getJobTitle());
            Glide.with(context).load(salaryObject.getSqLogoUrl()).into(holder.logo);
        }
        return convertView;
    }
    class Holder {
       TextView typeText;
       TextView titleText1;
       TextView titleText2;
       TextView titleText3;
       TextView companyText;
       ImageView logo;
    }
}
