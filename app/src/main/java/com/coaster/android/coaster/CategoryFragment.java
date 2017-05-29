package com.coaster.android.coaster;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.widget.CardView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;


public class CategoryFragment extends Fragment implements View.OnClickListener{

    Button ginButton;
    Button rumButton;
    Button tequilaButton;
    Button vodkaButton;
    Button whiskeyButton;

    FragmentManager manager = getFragmentManager();

    private static final String TAG = CategoryFragment.class.getSimpleName() + "_TAG";
    DrinksFragment drinksFrag = new DrinksFragment();

    public CategoryFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_category, container, false);

        ginButton = (Button) view.findViewById(R.id.gin_button);
        rumButton = (Button) view.findViewById(R.id.rum_button);
        tequilaButton = (Button) view.findViewById(R.id.tequila_button);
        vodkaButton = (Button) view.findViewById(R.id.vodka_button);
        whiskeyButton = (Button) view.findViewById(R.id.whiskey_button);

        ginButton.setOnClickListener(this);
        rumButton.setOnClickListener(this);
        tequilaButton.setOnClickListener(this);
        vodkaButton.setOnClickListener(this);
        whiskeyButton.setOnClickListener(this);

        return view;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.vodka_button:

                ButtonPress vodkaPress = (ButtonPress) getActivity();
                vodkaPress.drinkButtonPress();
                vodkaPress.vodkaStringKey();

                break;

            case R.id.whiskey_button:

                ButtonPress whiskeyPress = (ButtonPress) getActivity();
                whiskeyPress.drinkButtonPress();
                whiskeyPress.whiskeyStringKey();

                break;

        }
    }
}
