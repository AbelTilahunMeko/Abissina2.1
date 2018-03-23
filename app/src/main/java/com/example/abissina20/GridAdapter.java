package com.example.abissina20;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by BelA on 6/24/2017.
 */

public class GridAdapter extends BaseAdapter{
    //GridView is an an AdapterView that displays items in a two-d, scrallable grid
    Context context;
    private final String[] values;
    private final int[] images;

    View view;
    LayoutInflater layoutInflater;

    public GridAdapter(Context context, String[] values, int[] images) {
        this.context = context;
        this.values = values;
        this.images = images;
    }

    @Override
    public int getCount() {
        return values.length;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {




        layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        if(convertView == null){

            view = new View(context);
            view = layoutInflater.inflate(R.layout.single_item, null);

            ImageView  imageView = (ImageView)view.findViewById(R.id.imageViewer);
            TextView textView =(TextView)view.findViewById(R.id.iconText);
            imageView.setImageResource(images[position]);
            textView.setText(values[position]);

        }
        return view;
    }
}
