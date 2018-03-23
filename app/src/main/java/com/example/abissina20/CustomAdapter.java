package com.example.abissina20;

import android.app.Activity;
import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.text.NoCopySpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by BelA on 6/29/2017.
 */

public class CustomAdapter extends BaseAdapter {
    Context context;
    List<RowItem> rowItem;

    CustomAdapter(Context context, List<RowItem> rowItem) {
        this.context = context;
        this.rowItem = rowItem;
    }

    @Override
    public int getCount() {
        return rowItem.size();
    }

    @Override
    public Object getItem(int position) {
        return rowItem.get(position);
    }

    @Override
    public long getItemId(int position) {
        return rowItem.indexOf(getItem(position));
    }

    static class ViewHolder{
        public ImageView profile_pic;
        public TextView leader_name;
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder=null;
        LayoutInflater mInflater = (LayoutInflater)context.getSystemService(Activity.LAYOUT_INFLATER_SERVICE);

        if(convertView==null){
            convertView = mInflater.inflate(R.layout.list_item,null);
            holder = new ViewHolder();
            holder.leader_name = (TextView)convertView.findViewById(R.id.leader_name);
            holder.profile_pic = (ImageView)convertView.findViewById(R.id.profile_pic);

            RowItem row_pss = rowItem.get(position);

            holder.profile_pic.setImageResource(row_pss.getProfielPicId());
            holder.leader_name.setText(row_pss.getLeaderName());

        }


        return convertView;
    }


}

