package com.coaster.android.coaster.components;

import com.coaster.android.coaster.views.fragments.CategoryFragment;
import com.coaster.android.coaster.modules.CategoryFragmentModule;

import dagger.Component;

@Component(modules = {CategoryFragmentModule.class})
public interface CategoryFragmentComponent {
    CategoryFragment getCategoryFragment();
}
