package com.coaster.android.coaster.components;

import com.coaster.android.coaster.views.fragments.DrinkListInfoFragment;
import com.coaster.android.coaster.modules.DrinkListInfoFragmentModule;

import dagger.Component;

@Component(modules = DrinkListInfoFragmentModule.class)
public interface DrinkListInfoFragmentComponent {
    DrinkListInfoFragment getDrinkListInfoFragment();
}
