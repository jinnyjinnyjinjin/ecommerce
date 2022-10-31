package com.jinnyjinnyjinjin.ecommerce.domain.cart.entity;

import com.jinnyjinnyjinjin.ecommerce.domain.product.entity.ProductEntity;
import com.jinnyjinnyjinjin.ecommerce.domain.user.entity.UserEntity;
import lombok.Getter;

import javax.persistence.*;

import static javax.persistence.FetchType.LAZY;
import static javax.persistence.GenerationType.IDENTITY;

@Getter
@Entity
@Table(name = "CART")
public class CartEntity {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;

    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "product_id", nullable = false)
    private ProductEntity product;

    @OneToOne
    @JoinColumn(name = "user_id", nullable = false)
    private UserEntity user;

    private int quantity;

    protected CartEntity() {
    }

    private CartEntity(ProductEntity product, int quantity, UserEntity user) {
        this.product = product;
        this.quantity = quantity;
        this.user = user;
    }

    public static CartEntity create(ProductEntity product, int quantity, UserEntity user) {
        return new CartEntity(product, quantity, user);
    }
}
