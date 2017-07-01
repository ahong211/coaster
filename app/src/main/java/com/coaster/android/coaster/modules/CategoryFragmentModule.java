package com.coaster.android.coaster.modules;

import com.coaster.android.coaster.views.fragments.CategoryFragment;

import dagger.Module;
import dagger.Provides;

@Module
public class CategoryFragmentModule {
    @Provides
    CategoryFragment provideCategoryFragment() {
        return new CategoryFragment();
    }
}
