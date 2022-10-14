package com.jinnyjinnyjinjin.ecommerce.app.wishlist.api;

import com.jinnyjinnyjinjin.ecommerce.app.ApiResponse;
import com.jinnyjinnyjinjin.ecommerce.app.auth.service.AuthService;
import com.jinnyjinnyjinjin.ecommerce.app.wishlist.api.request.WishlistCreateRequest;
import com.jinnyjinnyjinjin.ecommerce.app.wishlist.dto.WishlistDto;
import com.jinnyjinnyjinjin.ecommerce.app.wishlist.service.WishlistService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/v1/wishlist")
public class WishlistController {

    private final WishlistService wishlistService;
    private final AuthService authService;

    @PostMapping("/add")
    public ResponseEntity<ApiResponse> create(@RequestBody WishlistCreateRequest request,
                                              @RequestParam String token) {
        authService.authenticate(token);
        Long userId = authService.getUserId(token);
        wishlistService.create(userId, request.getProductId());
        return new ResponseEntity<>(
                new ApiResponse(
                        true,
                        "Added to wishlist"
                ), HttpStatus.CREATED);
    }

    @GetMapping("{token}")
    public ResponseEntity<List<WishlistDto>> findAll(@PathVariable("token") String token) {
        authService.authenticate(token);
        Long userId = authService.getUserId(token);
        List<WishlistDto> wishlist = wishlistService.findAll(userId);
        return new ResponseEntity<>(wishlist, HttpStatus.OK);
    }
}
