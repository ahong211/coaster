package com.coaster.android.coaster;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

public class CategoryAdapter extends RecyclerView.Adapter<CategoryAdapter.MyHolder> {

    List<Cocktail> mCocktails;

    public CategoryAdapter(List<Cocktail> cocktails) {
        mCocktails = cocktails;
    }

    @Override
    public MyHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.category_item, parent, false);

        return new MyHolder(view);
    }

    @Override
    public void onBindViewHolder(MyHolder holder, int position) {
        holder.textView.setText(mCocktails.get(position).getName() + "\n"
                + mCocktails.get(position).getDescription());
    }

    @Override
    public int getItemCount() {
        return mCocktails.size();
    }

    public class MyHolder extends RecyclerView.ViewHolder {

        TextView textView;

        public MyHolder(View itemView) {
            super(itemView);

            textView = (TextView) itemView.findViewById(R.id.textView);
        }
    }
}
