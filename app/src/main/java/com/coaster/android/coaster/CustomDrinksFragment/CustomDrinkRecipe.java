package com.coaster.android.coaster.CustomDrinkFragment;

import java.io.File;

public class CustomDrinkRecipe {

    public String getDrinkId() {
        return drinkId;
    }

    public void setDrinkId(String drinkId) {
        this.drinkId = drinkId;
    }

    public CustomDrinkRecipe(String drinkId) {

        this.drinkId = drinkId;
    }

    private String drinkId;
    private String drinkName;
    private String ingredient;
    private String instruction;

    public CustomDrinkRecipe() {
        // Required empty constructor
    }

    public CustomDrinkRecipe(String drinkName, String ingredient, String instruction) {

        this.drinkName = drinkName;
        this.ingredient = ingredient;
        this.instruction = instruction;
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