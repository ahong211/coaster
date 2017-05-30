package com.coaster.android.coaster;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

public class RecyclerViewAdapter extends RecyclerView.Adapter<MyHolder> {

    List<Cocktail> mCocktails;

    public RecyclerViewAdapter(List<Cocktail> cocktails) {
        mCocktails = cocktails;
    }

    @Override
    public MyHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.category_item, parent, false);

        return new MyHolder(view);
    }

    @Override
    public void onBindViewHolder(MyHolder holder, final int position) {
        holder.textView.setText(mCocktails.get(position).getName());

        holder.mCardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String cocktailName = mCocktails.get(position).getName();
                DrinkInfo drinkInfo = (DrinkInfo) v.getContext();
                drinkInfo.goToDrinkListFragment();
                drinkInfo.setDrinkNameNode(cocktailName);
            }
        });
    }

    @Override
    public int getItemCount() {
        return mCocktails.size();
    }
}