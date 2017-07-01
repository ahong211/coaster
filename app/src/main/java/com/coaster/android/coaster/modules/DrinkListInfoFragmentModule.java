package com.coaster.android.coaster.module;

import com.coaster.android.coaster.DrinkListInfoFragment;

import dagger.Module;
import dagger.Provides;

@Module
public class DrinkListInfoFragmentModule {
    @Provides
    DrinkListInfoFragment provideDrinkListInfoFragment() {
        return new DrinkListInfoFragment();
    }
}
