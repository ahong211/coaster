package com.coaster.android.coaster;


import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import static android.content.Context.MODE_PRIVATE;


public class CategoryAdapter extends RecyclerView.Adapter<CategoryAdapter.MyHolder> {

    List<Cocktail> mCocktails;
    public static String s  = " ";
    public static ArrayList<String> sA = new ArrayList<>();
    ArrayList<String> saTemp = new ArrayList<>();

    public static class MyHolder extends RecyclerView.ViewHolder {
        TextView textView;
        CardView cardview;
        DrinkDetails mDrinkDetails = new DrinkDetails();

        public MyHolder(final View itemView) {
            super(itemView);
           // CategoryAdapter.MyHolder myHolder;
            textView = (TextView) itemView.findViewById(R.id.textView);
            cardview = (CardView) itemView.findViewById(R.id.cardview);

//             Toast.makeText(itemView.getContext(), "Text for butoon", Toast.LENGTH_SHORT).show();
//            cardview.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View v) {
//                   Toast.makeText(itemView.getContext(), "", Toast.LENGTH_SHORT).show();
//
//                    if (mDrinkDetails == null) {
//                        mDrinkDetails = new DrinkDetails();
//                    }
//
//                    FragmentTransaction drinkTransaction = fm.beginTransaction();
//                    drinkTransaction.replace(R.id.fragment_container, mDrinkDetails);
//                    drinkTransaction.addToBackStack(null);
//                    drinkTransaction.commit();
//               }
//            });
        }

    }

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
        holder.textView.setText(mCocktails.get(position).getName());

        sA.add(holder.textView.getText().toString());
        saTemp.add(holder.textView.getText().toString());

    }

    @Override
    public int getItemCount() {
        return mCocktails.size();
    }

}
