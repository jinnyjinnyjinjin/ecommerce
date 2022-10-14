package com.jinnyjinnyjinjin.ecommerce.domain.wishlist.entity;

import com.jinnyjinnyjinjin.ecommerce.domain.DateTimeEntity;
import com.jinnyjinnyjinjin.ecommerce.domain.product.entity.ProductEntity;
import com.jinnyjinnyjinjin.ecommerce.domain.user.entity.UserEntity;
import lombok.Getter;

import javax.persistence.*;

import static javax.persistence.FetchType.LAZY;
import static javax.persistence.GenerationType.IDENTITY;

@Entity
@Getter
@Table(name = "WISHLIST")
public class WishlistEntity extends DateTimeEntity {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;

    @OneToOne(targetEntity = UserEntity.class)
    @JoinColumn(name = "user_id", nullable = false)
    private UserEntity user;

    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "product_id")
    private ProductEntity product;

    protected WishlistEntity() {
    }

    public WishlistEntity(UserEntity user, ProductEntity product) {
        this.user = user;
        this.product = product;
    }

    public static WishlistEntity create(UserEntity user, ProductEntity product) {
        return new WishlistEntity(user, product);
    }
}
