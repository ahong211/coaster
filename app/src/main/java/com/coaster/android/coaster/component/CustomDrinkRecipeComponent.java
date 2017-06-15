package com.coaster.android.coaster.component;

import com.coaster.android.coaster.model.CustomDrinkRecipe;
import com.coaster.android.coaster.module.CustomDrinkRecipeModule;

import dagger.Component;

@Component(modules = CustomDrinkRecipeModule.class)
public interface CustomDrinkRecipeComponent {
    CustomDrinkRecipe getCustomDrinkRecipe();
}
