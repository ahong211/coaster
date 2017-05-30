package com.coaster.android.coaster;

public class Cocktail {

    private String name;
    private String description;
    private String ingred1;
    private String ingred2;
    private String ingred3;
    private String ingred4;
    private String ingred5;
    private String measure1;
    private String measure2;
    private String measure3;
    private String measure4;
    private String measure5;
    private String prep;

    public Cocktail() {

    }

    public Cocktail(String name) {
        this.name = name;
    }


    public String getName() {
        return name;
    }


    public String getDescription() {
        return description;
    }

    public String getIngred1() {
        if (ingred1 == null) {
            return "";
        }
        if (measure1 != null) {
            return ingred1;
        }
        return "- " + ingred1;
    }

    public String getIngred2() {
        if (ingred2 == null) {
            return "";
        }
        if (measure2 != null) {
            return ingred2;
        }
        return "- " + ingred2;
    }

    public String getIngred3() {
        if (ingred3 == null) {
            return "";
        }
        if (measure3 != null) {
            return ingred3;
        }
        return "- " + ingred3;
    }

    public String getIngred4() {
        if (ingred4 == null) {
            return "";
        }
        if (measure4 != null) {
            return ingred4;
        }
        return "- " + ingred4;
    }

    public String getIngred5() {
        if (ingred5 == null) {
            return "";
        }
        if (measure5 != null) {
            return ingred5;
        }
        return "- " + ingred5;
    }

    public String getMeasure1() {
        if (measure1 == null) {
            return "";
        }
        return "- " + measure1;
    }

    public String getMeasure2() {
        if (measure2 == null) {
            return "";
        }
        return "- " + measure2;
    }

    public String getMeasure3() {
        if (measure3 == null) {
            return "";
        }
        return "- " + measure3;
    }

    public String getMeasure4() {
        if (measure4 == null) {
            return "";
        }
        return "- " + measure4;
    }

    public String getMeasure5() {
        if (measure5 == null) {
            return "";
        }
        return "- " + measure5;
    }

    public String getPrep() {
        return prep;
    }
}