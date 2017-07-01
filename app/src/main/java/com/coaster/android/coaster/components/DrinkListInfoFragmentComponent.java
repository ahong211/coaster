package com.coaster.android.coaster.component;

import com.coaster.android.coaster.DrinkListInfoFragment;
import com.coaster.android.coaster.module.DrinkListInfoFragmentModule;

import dagger.Component;

@Component(modules = DrinkListInfoFragmentModule.class)
public interface DrinkListInfoFragmentComponent {
    DrinkListInfoFragment getDrinkListInfoFragment();
}
