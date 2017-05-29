package com.coaster.android.coaster;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class CustomDrinkFragment extends Fragment {

    // TODO: 5/29/2017 Create custom drink pojo that saves information to be displayed in custom drink view

    public CustomDrinkFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_custom_drink, container, false);
    }

}
