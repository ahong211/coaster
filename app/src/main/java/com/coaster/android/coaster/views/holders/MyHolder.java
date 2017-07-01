package com.coaster.android.coaster.views.holders;

import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.coaster.android.coaster.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MyHolder extends RecyclerView.ViewHolder {

    @BindView(R.id.card_drink_title)
    public TextView cardDrinkTitle;

    @BindView(R.id.card_drink_desc)
    public TextView cardDrinkDesc;

    @BindView(R.id.cardView)
    public CardView mCardView;

    @BindView(R.id.card_drink_img)
    public ImageView imageView;

    public MyHolder(View itemView) {
        super(itemView);
        ButterKnife.bind(this, itemView);
    }
}
