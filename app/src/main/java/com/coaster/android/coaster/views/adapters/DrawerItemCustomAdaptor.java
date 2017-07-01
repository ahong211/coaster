package com.coaster.android.coaster.views.adapters;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.coaster.android.coaster.R;
import com.coaster.android.coaster.models.DataModel;

/*
 * Created by Kevin on 6/10/17.
 */

public class DrawerItemCustomAdaptor extends ArrayAdapter<DataModel> {
    public Context mContext;
    public int layoutResourceId;
    public DataModel data[] = null;

    public DrawerItemCustomAdaptor(Context mContext, int layoutResourceId, DataModel[] data) {

        super(mContext, layoutResourceId, data);
        this.layoutResourceId = layoutResourceId;
        this.mContext = mContext;
        this.data = data;
    }

    // FIXME: 6/30/2017 OH MY GOD, KEVIN, refactor the class name to 'adapter' with an 'e'
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View listItem;

        LayoutInflater inflater = ((Activity) mContext).getLayoutInflater();
        listItem = inflater.inflate(layoutResourceId, parent, false);

        ImageView imageViewIcon = (ImageView) listItem.findViewById(R.id.imageViewIcon);
        TextView textViewName = (TextView) listItem.findViewById(R.id.textViewName);

        DataModel folder = data[position];

        imageViewIcon.setImageResource(folder.icon);
        textViewName.setText(folder.name);

        return listItem;
    }
}
