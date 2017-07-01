package com.coaster.android.coaster.models;

import javax.inject.Inject;

public class CustomDrinkRecipe {

    private String drinkId;
    private String drinkName;
    private String ingredient;
    private String instruction;

    @Inject
    public CustomDrinkRecipe() {
        // Required empty constructor
    }

    public String getDrinkId() {
        return drinkId;
    }

    public void setDrinkId(String drinkId) {
        this.drinkId = drinkId;
    }

    public String getDrinkName() {
        return drinkName;
    }

    public void setDrinkName(String drinkName) {
        this.drinkName = drinkName;
    }

    public String getIngredient() {
        return ingredient;
    }

    public void setIngredient(String ingredient) {
        this.ingredient = ingredient;
    }

    public String getInstruction() {
        return instruction;
    }

    public void setInstruction(String instruction) {
        this.instruction = instruction;
    }
}