package com.coaster.android.coaster;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bumptech.glide.Glide;
import com.coaster.android.coaster.models.Cocktail;

import java.util.List;

public class RecyclerViewAdapter extends RecyclerView.Adapter<MyHolder> {

    List<Cocktail> mCocktails;
    private ViewGroup viewGroup;

    public RecyclerViewAdapter(List<Cocktail> cocktails) {
        mCocktails = cocktails;
    }

    @Override
    public MyHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.category_item, parent, false);

        this.viewGroup = parent;

        return new MyHolder(view);
    }

    @Override
    public void onBindViewHolder(MyHolder holder, final int position) {
        holder.cardDrinkTitle.setText(mCocktails.get(position).getName());
        holder.cardDrinkDesc.setText(mCocktails.get(position).getDescription());

        Glide.with(viewGroup.getContext())
                .load(mCocktails.get(position).getUrl())
                .into(holder.imageView);

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