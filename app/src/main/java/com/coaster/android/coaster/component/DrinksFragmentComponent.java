package com.coaster.android.coaster.component;

import com.coaster.android.coaster.DrinksFragment;
import com.coaster.android.coaster.module.DrinksFragmentModule;

import dagger.Component;

@Component(modules = DrinksFragmentModule.class)
public interface DrinksFragmentComponent {
    DrinksFragment getDrinksFragment();
}
