package com.coaster.android.coaster.components;

import com.coaster.android.coaster.views.fragments.CustomDrinkFragment;
import com.coaster.android.coaster.modules.CustomDrinkFragmentModule;

import dagger.Component;

@Component(modules = CustomDrinkFragmentModule.class)
public interface CustomDrinkFragmentComponent {
    CustomDrinkFragment getCustomDrinkFragment();
}
