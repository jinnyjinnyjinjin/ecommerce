package com.jinnyjinnyjinjin.ecommerce.category.api.request;

import lombok.Getter;

@Getter
public class CategoryUpdateRequest {

    private String name;
    private String description;
    private String imageUrl;

}
