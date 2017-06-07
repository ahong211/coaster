package com.coaster.android.coaster;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class CustomDrinksAdapter extends RecyclerView.Adapter<CustomDrinksAdapter.ViewHolder> {

    List<String> data;

    public CustomDrinksAdapter(ArrayList<String> customDrinksData) {
        this.data = customDrinksData;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(android.R.layout.simple_list_item_1, parent, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(CustomDrinksAdapter.ViewHolder holder, int position) {

        holder.bind(data.get(position));

    }

    @Override
    public int getItemCount() {
        return data != null ? data.size() : 0;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        TextView textView;

        public ViewHolder(View itemView) {
            super(itemView);

            textView = (TextView) itemView.findViewById(android.R.id.text1);

        }

        public void bind(String s) {
            textView.setText(s);
        }
    }
}
