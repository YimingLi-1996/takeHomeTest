package com.example.salary.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.salary.R;
import com.example.salary.objects.ResponseObject;

import java.util.ArrayList;
import java.util.List;


public class ResponseAdapter extends BaseAdapter {
    Context context;
    List<ResponseObject> beans = new ArrayList<>();
    public ResponseAdapter(Context context) {
        this.context = context;
    }

    public void setBeans(List<ResponseObject> beans) {
        if (beans != null){
            this.beans = beans;
            notifyDataSetChanged();
        }

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
            convertView = LayoutInflater.from(context).inflate(R.layout.layout_response_item, parent,false);
            holder.response = convertView.findViewById(R.id.response);
            convertView.setTag(holder);
        }else {
            holder=(Holder)convertView.getTag();
        }

        ResponseObject bean = beans.get(position);
        holder.response.setText("  " + (position + 1) + ") " + bean.getResponseText());
        return convertView;
    }
    class Holder {
        TextView response;

    }
}

