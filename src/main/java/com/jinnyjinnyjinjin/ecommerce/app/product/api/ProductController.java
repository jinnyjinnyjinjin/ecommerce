package com.jinnyjinnyjinjin.ecommerce.app.product.api;

import com.jinnyjinnyjinjin.ecommerce.app.category.api.ApiResponse;
import com.jinnyjinnyjinjin.ecommerce.app.product.api.request.ProductCreateRequest;
import com.jinnyjinnyjinjin.ecommerce.app.product.api.request.ProductUpdateRequest;
import com.jinnyjinnyjinjin.ecommerce.app.product.api.response.ProductResponse;
import com.jinnyjinnyjinjin.ecommerce.app.product.dto.ProductDto;
import com.jinnyjinnyjinjin.ecommerce.app.product.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/v1/products")
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

    @GetMapping
    public ResponseEntity<Page<ProductResponse>> findAllProducts(Pageable pageable) {
        Page<ProductResponse> responses = productService.getAll(pageable);
        return new ResponseEntity<>(responses, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ApiResponse> updateProduct(@PathVariable("id") Long id,
                                                     @RequestBody ProductUpdateRequest request) {
        ProductDto productDto = ProductDto.of(
                request.getName(),
                request.getImageUrl(),
                request.getPrice(),
                request.getDescription(),
                request.getCategoryId()
        );

        productService.update(id, productDto);

        return new ResponseEntity<>(new ApiResponse(true, "Product has been updated"), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductResponse> findProduct(@PathVariable("id") Long id) {
        ProductResponse response = productService.getOne(id);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
