package com.coaster.android.coaster.components;

import com.coaster.android.coaster.views.fragments.DrinksFragment;
import com.coaster.android.coaster.modules.DrinksFragmentModule;

import dagger.Component;

@Component(modules = DrinksFragmentModule.class)
public interface DrinksFragmentComponent {
    DrinksFragment getDrinksFragment();
}
