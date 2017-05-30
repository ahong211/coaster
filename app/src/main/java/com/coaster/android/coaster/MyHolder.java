package com.coaster.android.coaster;

import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;


public class MyHolder extends RecyclerView.ViewHolder {

    TextView textView;
    CardView mCardView;
    TextView textDrinkName;
    TextView textDrinkDesc;

    public MyHolder(View itemView) {
        super(itemView);

        textView = (TextView) itemView.findViewById(R.id.textView);
        mCardView = (CardView) itemView.findViewById(R.id.cardView);

        textDrinkName = (TextView) itemView.findViewById(R.id.drinkName);
        textDrinkDesc = (TextView) itemView.findViewById(R.id.drinkDesc);
    }
}
