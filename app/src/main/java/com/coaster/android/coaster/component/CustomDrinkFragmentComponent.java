package com.coaster.android.coaster.component;

import com.coaster.android.coaster.CustomDrinkFragment;
import com.coaster.android.coaster.module.CustomDrinkFragmentModule;

import dagger.Component;

@Component(modules = CustomDrinkFragmentModule.class)
public interface CustomDrinkFragmentComponent {
    CustomDrinkFragment getCustomDrinkFragment();
}
