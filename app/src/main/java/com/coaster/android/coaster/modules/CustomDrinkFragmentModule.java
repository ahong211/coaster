package com.coaster.android.coaster.module;

import com.coaster.android.coaster.CustomDrinkFragment;

import dagger.Module;
import dagger.Provides;

@Module
public class CustomDrinkFragmentModule {
    @Provides
    CustomDrinkFragment provideCustomDrinkFragment() {
        return new CustomDrinkFragment();
    }
}
