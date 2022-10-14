package com.jinnyjinnyjinjin.ecommerce.app.wishlist.dto;

import com.jinnyjinnyjinjin.ecommerce.app.product.dto.ProductDto;
import com.jinnyjinnyjinjin.ecommerce.domain.product.dto.Product;
import com.jinnyjinnyjinjin.ecommerce.domain.wishlist.dto.Wishlist;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class WishlistDto {

    private Long id;
    private ProductDto product;

    public static WishlistDto of(Wishlist wishlist) {

        ProductDto product = ProductDto.of(wishlist.getProduct());

        return WishlistDto.builder()
                .id(wishlist.getId())
                .product(product)
                .build();
    }
}
