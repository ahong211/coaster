package com.coaster.android.coaster;

public class Cocktail {

    private String name;
    private String description;
    private String ingred1, ingred2, ingred3, ingred4, ingred5, ingred6, ingred7, ingred8,
            ingred9, ingred10, ingred11, ingred12;

    private String measure1, measure2, measure3, measure4, measure5, measure6, measure7, measure8,
            measure9, measure10, measure11, measure12;

    private String prep;
    private String url;

    public Cocktail() {

    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
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

    public String getIngred6() {
        if (ingred6 == null) {
            return "";
        }

        if (measure6 != null) {
            return ingred6;
        }

        return "- " + ingred6;
    }

    public String getIngred7() {
        if (ingred7 == null) {
            return "";
        }

        if (measure7 != null) {
            return ingred7;
        }

        return "- " + ingred7;
    }

    public String getIngred8() {
        if (ingred8 == null) {
            return "";
        }

        if (measure8 != null) {
            return ingred8;
        }

        return "- " + ingred8;
    }

    public String getIngred9() {
        if (ingred9 == null) {
            return "";
        }

        if (measure9 != null) {
            return ingred9;
        }

        return "- " + ingred9;
    }

    public String getIngred10() {
        if (ingred10 == null) {
            return "";
        }

        if (measure10 != null) {
            return ingred10;
        }

        return "- " + ingred10;
    }

    public String getIngred11() {
        if (ingred11 == null) {
            return "";
        }

        if (measure11 != null) {
            return ingred11;
        }

        return "- " + ingred11;
    }

    public String getIngred12() {
        if (ingred12 == null) {
            return "";
        }

        if (measure12 != null) {
            return ingred12;
        }

        return "- " + ingred12;
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

    public String getMeasure6() {
        if (measure6 == null) {
            return "";
        }

        return "- " + measure6;
    }

    public String getMeasure7() {
        if (measure7 == null) {
            return "";
        }

        return "- " + measure7;
    }

    public String getMeasure8() {
        if (measure8 == null) {
            return "";
        }

        return "- " + measure8;
    }

    public String getMeasure9() {
        if (measure9 == null) {
            return "";
        }

        return "- " + measure9;
    }

    public String getMeasure10() {
        if (measure10 == null) {
            return "";
        }

        return "- " + measure10;
    }

    public String getMeasure11() {
        if (measure11 == null) {
            return "";
        }

        return "- " + measure11;
    }

    public String getMeasure12() {
        if (measure12 == null) {
            return "";
        }

        return "- " + measure12;
    }

    public String getPrep() {
        return prep;
    }
}