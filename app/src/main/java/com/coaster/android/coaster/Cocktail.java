package com.coaster.android.coaster;



public class Cocktail {
    private String whiskey;
    private String vodka;
    private String gin;
    private String rum;
    private String tequila;
    private String name;
    private String category;
    private String description;

    public Cocktail() {
        
    }

    public Cocktail(String whiskey, String vodka, String gin, String rum, String tequila, String name, String category) {
        this.whiskey = whiskey;
        this.vodka = vodka;
        this.gin = gin;
        this.rum = rum;
        this.tequila = tequila;
        this.name = name;
        this.category = category;
    }

    public Cocktail(String name) {
        this.name = name;
    }

    public String getWhiskey() {
        return whiskey;
    }

    public String getVodka() {
        return vodka;
    }

    public String getGin() {
        return gin;
    }

    public String getRum() {
        return rum;
    }

    public String getTequila() {
        return tequila;
    }

    public String getName() {
        return name;
    }

    public String getCategory() {
        return category;
    }

    public String getDescription() {
        return description;
    }

    @Override
    public String toString() {
        return "Cocktail{" +
                "whiskey='" + whiskey + '\'' +
                ", vodka='" + vodka + '\'' +
                ", gin='" + gin + '\'' +
                ", rum='" + rum + '\'' +
                ", tequila='" + tequila + '\'' +
                '}';
    }
}
