package com.coaster.android.coaster;

import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MyHolder extends RecyclerView.ViewHolder {

    @BindView(R.id.card_drink_title)
    TextView cardDrinkTitle;

    @BindView(R.id.card_drink_desc)
    TextView cardDrinkDesc;

    @BindView(R.id.cardView)
    CardView mCardView;

    @BindView(R.id.card_drink_img)
    ImageView imageView;

    public MyHolder(View itemView) {
        super(itemView);
//        cardDrinkTitle = (TextView) itemView.findViewById(R.id.card_drink_title);
//        cardDrinkDesc = (TextView) itemView.findViewById(R.id.card_drink_desc);
//        mCardView = (CardView) itemView.findViewById(R.id.cardView);
//        imageView = (ImageView) itemView.findViewById(R.id.card_drink_img);
        ButterKnife.bind(this, itemView);
    }
}
