package com.coaster.android.coaster.module;

import com.coaster.android.coaster.model.CustomDrinkRecipe;

import dagger.Module;
import dagger.Provides;

@Module
public class CustomDrinkRecipeModule {
    @Provides
    CustomDrinkRecipe provideCustomDrinkRecipe() {
        return new CustomDrinkRecipe();
    }
}
