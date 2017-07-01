package com.coaster.android.coaster.modules;

import com.coaster.android.coaster.views.fragments.DrinkListInfoFragment;

import dagger.Module;
import dagger.Provides;

@Module
public class DrinkListInfoFragmentModule {
    @Provides
    DrinkListInfoFragment provideDrinkListInfoFragment() {
        return new DrinkListInfoFragment();
    }
}
