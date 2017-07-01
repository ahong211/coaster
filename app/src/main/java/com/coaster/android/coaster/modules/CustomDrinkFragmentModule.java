package com.coaster.android.coaster.modules;

import com.coaster.android.coaster.views.fragments.CustomDrinkFragment;

import dagger.Module;
import dagger.Provides;

@Module
public class CustomDrinkFragmentModule {
    @Provides
    CustomDrinkFragment provideCustomDrinkFragment() {
        return new CustomDrinkFragment();
    }
}
