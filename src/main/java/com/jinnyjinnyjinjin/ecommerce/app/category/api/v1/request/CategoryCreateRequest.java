package com.jinnyjinnyjinjin.ecommerce.app.category.api.v1.request;

public class CategoryCreateRequest {

    private String categoryName;

    private String description;

    private String imageUrl;

    public String getCategoryName() {
        return categoryName;
    }

    public String getDescription() {
        return description;
    }

    public String getImageUrl() {
        return imageUrl;
    }
}
