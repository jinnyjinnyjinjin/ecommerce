package com.jinnyjinnyjinjin.ecommerce.app.cart.api;

import com.jinnyjinnyjinjin.ecommerce.app.ApiResponse;
import com.jinnyjinnyjinjin.ecommerce.app.auth.service.AuthService;
import com.jinnyjinnyjinjin.ecommerce.app.cart.api.request.AddToCartRequest;
import com.jinnyjinnyjinjin.ecommerce.app.cart.service.CartService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/v1/cart")
public class CartController {

    private final AuthService authService;
    private final CartService cartService;

    @PostMapping("/add")
    public ResponseEntity<ApiResponse> addToCart(@RequestBody AddToCartRequest request,
                                                 @RequestParam String token) {
        authService.authenticate(token);
        Long userId = authService.getUserId(token);
        cartService.add(userId, request.getProductId(), request.getQuantity());
        return new ResponseEntity<>(
                new ApiResponse(true, "Added to Cart"),
                HttpStatus.CREATED);
    }
}
