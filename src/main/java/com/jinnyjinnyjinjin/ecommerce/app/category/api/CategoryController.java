package com.jinnyjinnyjinjin.ecommerce.app.category.api;

import com.jinnyjinnyjinjin.ecommerce.app.ApiResponse;
import com.jinnyjinnyjinjin.ecommerce.app.category.api.request.CategoryCreateRequest;
import com.jinnyjinnyjinjin.ecommerce.app.category.api.request.CategoryUpdateRequest;
import com.jinnyjinnyjinjin.ecommerce.app.category.api.response.CategoryResponse;
import com.jinnyjinnyjinjin.ecommerce.app.category.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/v1/categories")
public class CategoryController {

    private final CategoryService categoryService;

    @PostMapping("/add")
    public ResponseEntity<ApiResponse> createCategory(@RequestBody CategoryCreateRequest request) {

        categoryService.create(
                request.getName(),
                request.getDescription(),
                request.getImageUrl()
        );

        return new ResponseEntity<>(new ApiResponse(true, "created category"), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<CategoryResponse>> findAllCategories() {
        List<CategoryResponse> categories = categoryService.getAll();
        return new ResponseEntity<>(categories, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ApiResponse> updateCategory(@PathVariable("id") Long id,
                                                      @RequestBody CategoryUpdateRequest request) {

        categoryService.update(
                id,
                request.getName(),
                request.getDescription(),
                request.getImageUrl()
        );

        return new ResponseEntity<>(new ApiResponse(true, "updated category"), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CategoryResponse> findCategory(@PathVariable("id") Long id) {
        CategoryResponse response = categoryService.getOne(id);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
