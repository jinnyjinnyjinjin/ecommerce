package com.jinnyjinnyjinjin.ecommerce.category.api;

import com.jinnyjinnyjinjin.ecommerce.ApiResponse;
import com.jinnyjinnyjinjin.ecommerce.category.api.request.CategoryCreateRequest;
import com.jinnyjinnyjinjin.ecommerce.category.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/v1/categories")
public class CategoryController {

    private final CategoryService categoryService;

    @PostMapping
    public ResponseEntity<ApiResponse> createCategory(@RequestBody CategoryCreateRequest request) {

        categoryService.create(
                request.getCategoryName(),
                request.getDescription(),
                request.getImageUrl()
        );

        return new ResponseEntity<>(new ApiResponse(true, "OK"), HttpStatus.CREATED);
    }
}
