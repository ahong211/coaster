package com.coaster.android.coaster;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import java.util.ArrayList;

public class CustomDrinksListFragment extends Fragment implements View.OnClickListener {

    private static final String LOG_TAG = "MAC_TAG";
    FloatingActionButton addCustomDrinkActionButton;

    ArrayList<String> customDrinksDataList;

    public CustomDrinksListFragment() {
        // Required empty public constructor
    }

    //CustomDrinkFragment swapData;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_custom_drinks_list, container, false);

        addCustomDrinkActionButton = (FloatingActionButton) view.findViewById(R.id.add_new_drink);
        addCustomDrinkActionButton.setOnClickListener(this);

        //customDrinksDataList = swapData.getCustomDrinksDataList();
        Log.e(LOG_TAG, "onCreateView: " + customDrinksDataList);

        return view;
    }

    @Override
    public void onClick(View v) {
        ButtonPress addCustomDrinkPress = (ButtonPress) getActivity();
        addCustomDrinkPress.addCustomDrinkButtonPress();
    }

}
