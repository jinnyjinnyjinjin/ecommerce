package com.jinnyjinnyjinjin.ecommerce.app.category.api;

import com.jinnyjinnyjinjin.ecommerce.app.category.api.request.CategoryCreateRequest;
import com.jinnyjinnyjinjin.ecommerce.app.category.api.request.CategoryUpdateRequest;
import com.jinnyjinnyjinjin.ecommerce.app.category.api.response.CategoryResponse;
import com.jinnyjinnyjinjin.ecommerce.app.category.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

        return new ResponseEntity<>(new ApiResponse(true, "created category"), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<Page<CategoryResponse>> findAllCategories(@PageableDefault Pageable pageable) {

        Page<CategoryResponse> categories = categoryService.getAll(pageable)
                .map(CategoryResponse::of);

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
}
