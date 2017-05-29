package com.coaster.android.coaster;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import static com.coaster.android.coaster.MainActivity.sharedString;


public class DrinkDetails extends Fragment {
TextView drinkName_TextView;
TextView drinkDesc_TextView;
    String s;
    public DrinkDetails() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v =inflater.inflate(R.layout.fragment_drink_details, container, false);

        drinkName_TextView = (TextView)v.findViewById(R.id.drinkDetails);
        drinkDesc_TextView = (TextView) v.findViewById(R.id.drinkDescription);
        drinkName_TextView.setText(CategoryAdapter.sA.get(1));
        return v;

    }

}
