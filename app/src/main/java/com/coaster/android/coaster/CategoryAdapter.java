package com.coaster.android.coaster;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;
import java.util.List;


public class CategoryAdapter extends RecyclerView.Adapter<CategoryAdapter.MyHolder> {
    static int i;
    private List<Cocktail> mCocktails;
    private Activity context;

    public static class MyHolder extends RecyclerView.ViewHolder {
        TextView textView;
        CardView cardview;


        public MyHolder(final View itemView) {
            super(itemView);
            textView = (TextView) itemView.findViewById(R.id.textView);
            cardview = (CardView) itemView.findViewById(R.id.cardview);

        }

    }

    public CategoryAdapter(List<Cocktail> cocktails) {
        i=1;
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
        //holder.textView.setText(mCocktails.get(position).getDescription());
        final int k = position;

        holder.cardview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(v.getContext(), "you have clicked " +mCocktails.get(k).getName(), Toast.LENGTH_LONG).show();

                AppCompatActivity activity = (AppCompatActivity) v.getContext();
                DrinkDetails myFragment = new DrinkDetails();
                Bundle args = new Bundle();
                args.putString("key", mCocktails.get(k).getName());
                myFragment.setArguments(args);
                //inflate the fragment

                //Create a bundle to pass data, add data, set the bundle to your fragment and:
                activity.getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, myFragment).addToBackStack(null).commit();

            }
        });
    }

    @Override
    public int getItemCount() {

        return mCocktails.size();
    }

}
