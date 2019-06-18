package cine.emon.live.com.cinematic.model;

public class Category {

    private String categoryTitle;

    public String getCategoryTitle() {
        return categoryTitle;
    }

    public void setCategoryTitle(String categoryTitle) {
        this.categoryTitle = categoryTitle;
    }

    public Category(String categoryTitle) {
        this.categoryTitle = categoryTitle;
    }
}
