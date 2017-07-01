package com.coaster.android.coaster.modules;

import com.coaster.android.coaster.views.fragments.DrinksFragment;

import dagger.Module;
import dagger.Provides;

@Module
public class DrinksFragmentModule {
    @Provides
    DrinksFragment provideDrinkFragment() {
        return new DrinksFragment();
    }
}
