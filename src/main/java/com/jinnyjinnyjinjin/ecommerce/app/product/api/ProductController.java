package com.jinnyjinnyjinjin.ecommerce.app.product.api;

import com.jinnyjinnyjinjin.ecommerce.app.category.api.ApiResponse;
import com.jinnyjinnyjinjin.ecommerce.app.product.api.request.ProductCreateRequest;
import com.jinnyjinnyjinjin.ecommerce.app.product.dto.ProductDto;
import com.jinnyjinnyjinjin.ecommerce.app.product.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/v1/product")
public class ProductController {

    private final ProductService productService;

    @PostMapping("/add")
    public ResponseEntity<ApiResponse> addProduct(@RequestBody ProductCreateRequest request) {
        ProductDto product = request.toDto(
                request.getName(),
                request.getImageUrl(),
                request.getPrice(),
                request.getDescription(),
                request.getCategoryId()
        );
        productService.add(product);
        return new ResponseEntity<>(new ApiResponse(
                true,
                "Product has been added"),
                HttpStatus.CREATED);
    }
}
