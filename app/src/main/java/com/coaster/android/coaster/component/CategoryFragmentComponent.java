package com.coaster.android.coaster.component;

import com.coaster.android.coaster.CategoryFragment;
import com.coaster.android.coaster.module.CategoryFragmentModule;

import dagger.Component;

@Component(modules = {CategoryFragmentModule.class})
public interface CategoryFragmentComponent {
    CategoryFragment getCategoryFragment();
}
