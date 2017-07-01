package com.coaster.android.coaster.components;

import com.coaster.android.coaster.models.CustomDrinkRecipe;
import com.coaster.android.coaster.modules.CustomDrinkRecipeModule;

import dagger.Component;

@Component(modules = CustomDrinkRecipeModule.class)
public interface CustomDrinkRecipeComponent {
    CustomDrinkRecipe getCustomDrinkRecipe();
}
