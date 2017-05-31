package com.coaster.android.coaster;

import android.os.Bundle;
import android.os.Environment;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class CustomDrinksListFragment extends Fragment implements View.OnClickListener {

    // TODO: 5/29/2017 Make custom drinks pull from and save to local storage
    // TODO: 5/29/2017 Create methods that store file read from storage inside custom drink object
    // TODO: 5/29/2017 Create list of custom drink files read from external storage on device
    // TODO: 5/29/2017 Create recycler view that displays list of custom drink files

    FloatingActionButton addNewDrinkActionButton;

    String[] fileList() {
        return new String[0];
    }

    public CustomDrinksListFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_custom_drinks_list, container, false);

        addNewDrinkActionButton = (FloatingActionButton) view.findViewById(R.id.add_new_drink);
        addNewDrinkActionButton.setOnClickListener(this);

        return view;
    }

    @Override
    public void onClick(View v) {
        ButtonPress addCustomDrinkPress = (ButtonPress) getActivity();
        addCustomDrinkPress.addCustomDrinkButtonPress();
    }
}
