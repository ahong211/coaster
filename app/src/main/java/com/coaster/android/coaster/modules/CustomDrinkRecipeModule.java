package com.coaster.android.coaster.modules;

import com.coaster.android.coaster.models.CustomDrinkRecipe;

import dagger.Module;
import dagger.Provides;

@Module
public class CustomDrinkRecipeModule {
    @Provides
    CustomDrinkRecipe provideCustomDrinkRecipe() {
        return new CustomDrinkRecipe();
    }
}
