package com.coaster.android.coaster;


import java.io.File;

public class CustomDrinkRecipe {

    private String drinkName;
    private String ingredient;
    private String instruction;
    private File drinkFileName;

    public File getDrinkFileName() {
        return drinkFileName;
    }

    public void setDrinkFileName(File drinkFileName) {
        this.drinkFileName = drinkFileName;
    }

    public CustomDrinkRecipe() {
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
