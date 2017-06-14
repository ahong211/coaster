package com.coaster.android.coaster.module;

import com.coaster.android.coaster.CategoryFragment;

import dagger.Module;
import dagger.Provides;

@Module
public class CategoryFragmentModule {
    @Provides
    CategoryFragment provideCategoryFragment() {
        return new CategoryFragment();
    }
}
