package com.example.yakuza.animation;

import android.content.Context;
import android.support.v4.view.ViewCompat;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by nilarnab on 30/11/15.
 */
public class CustomAdapter extends ArrayAdapter<RowItem> {
    public CustomAdapter(Context context, ArrayList<RowItem> objects) {
        super(context, 0 , objects);

    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        if(convertView == null)
        {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.list_item,parent,false);
        }
        ImageView image = (ImageView)convertView.findViewById(R.id.list_image);

        image.setTransitionName("xyz" + position);
        //ViewCompat.setTransitionName(image,"xyz"+position);
       Log.d("get view transition",image.getTransitionName());

        return convertView;
    }
}
