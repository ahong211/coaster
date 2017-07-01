package com.coaster.android.coaster;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class CategoryFragment extends Fragment {

    @BindView(R.id.gin_button)
    ImageView ginButton;

    @BindView(R.id.rum_button)
    ImageView rumButton;

    @BindView(R.id.tequila_button)
    ImageView tequilaButton;

    @BindView(R.id.vodka_button)
    ImageView vodkaButton;

    @BindView(R.id.whiskey_button)
    ImageView whiskeyButton;

    @BindView(R.id.mixed_button)
    ImageView mixedButton;

    @BindView(R.id.custom_drinks_button)
    Button customDrinksButton;

    @Inject
    public CategoryFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_category, container, false);

        ButterKnife.bind(this, view);

        return view;
    }

    @OnClick({R.id.vodka_button, R.id.whiskey_button, R.id.tequila_button, R.id.rum_button,
            R.id.gin_button, R.id.mixed_button, R.id.custom_drinks_button})
    public void onDrinksCategoryButtonClicked(View v) {

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

            case R.id.tequila_button:

                ButtonPress tequilaPress = (ButtonPress) getActivity();
                tequilaPress.drinkButtonPress();
                tequilaPress.tequilaStringKey();

                break;

            case R.id.rum_button:

                ButtonPress rumPress = (ButtonPress) getActivity();
                rumPress.drinkButtonPress();
                rumPress.rumStringKey();

                break;

            case R.id.gin_button:

                ButtonPress ginPress = (ButtonPress) getActivity();
                ginPress.drinkButtonPress();
                ginPress.ginStringKey();

                break;

            case R.id.mixed_button:

                ButtonPress mixedDrinkPress = (ButtonPress) getActivity();
                mixedDrinkPress.drinkButtonPress();
                mixedDrinkPress.mixedDrinkStringKey();

                break;

            case R.id.custom_drinks_button:

                Intent loadCustomList = new Intent(getContext(), CustomDrinkListActivity.class);
                startActivity(loadCustomList);

                break;

            default:
                throw new RuntimeException("Invalid selection: " + v.getId());
        }
    }
}