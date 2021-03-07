package com.example.salary.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.example.salary.objects.QuestionObject;
import com.example.salary.R;

import java.util.List;

public class QuestionAdapter extends BaseAdapter {
    Context context;
    List<QuestionObject> beans;
    public QuestionAdapter(Context context, List<QuestionObject> beans) {
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
        if(null==convertView) {
            holder=new Holder();
            convertView = LayoutInflater.from(context).inflate(R.layout.layout_question_item, parent,false);
            holder.question = convertView.findViewById(R.id.question);
            holder.listView = convertView.findViewById(R.id.listview);
            holder.adapter = new ResponseAdapter(context);
            holder.listView.setAdapter(holder.adapter);
            convertView.setTag(holder);
        }else {
            holder=(Holder)convertView.getTag();
        }

        QuestionObject bean = beans.get(position);
        holder.question.setText(position + 1 + "."+bean.getQuestion());
        holder.adapter.setBeans(bean.getResponses());
        return convertView;
    }
    class Holder {
        TextView question;
        ListView listView;
        ResponseAdapter adapter;
    }
}

