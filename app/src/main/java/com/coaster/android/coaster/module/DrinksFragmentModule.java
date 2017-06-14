package com.coaster.android.coaster.module;

import com.coaster.android.coaster.DrinksFragment;

import dagger.Module;
import dagger.Provides;

@Module
public class DrinksFragmentModule {
    @Provides
    DrinksFragment provideDrinkFragment() {
        return new DrinksFragment();
    }
}
