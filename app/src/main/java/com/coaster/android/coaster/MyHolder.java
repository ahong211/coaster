package com.coaster.android.coaster;

import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class MyHolder extends RecyclerView.ViewHolder {

    TextView cardDrinkTitle;
    TextView cardDrinkDesc;
    CardView mCardView;
    ImageView imageView;

    public MyHolder(View itemView) {
        super(itemView);
        cardDrinkTitle = (TextView) itemView.findViewById(R.id.card_drink_title);
        cardDrinkDesc = (TextView) itemView.findViewById(R.id.card_drink_desc);
        mCardView = (CardView) itemView.findViewById(R.id.cardView);
        imageView = (ImageView) itemView.findViewById(R.id.card_drink_img);
    }
}
