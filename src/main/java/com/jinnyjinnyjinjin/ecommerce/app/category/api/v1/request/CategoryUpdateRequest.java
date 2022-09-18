package com.jinnyjinnyjinjin.ecommerce.app.category.api.v1.request;

import lombok.Getter;

@Getter
public class CategoryUpdateRequest {

    private String name;
    private String description;
    private String imageUrl;

}
