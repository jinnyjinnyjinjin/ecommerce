package com.jinnyjinnyjinjin.ecommerce.domain.token.entity;

import com.jinnyjinnyjinjin.ecommerce.domain.user.entity.UserEntity;
import lombok.Getter;

import javax.persistence.*;

import static javax.persistence.GenerationType.IDENTITY;

@Entity
@Getter
@Table(name = "TOKENS")
public class AuthTokenEntity {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;

    private String token;

    @OneToOne
    @JoinColumn(name = "user_id", nullable = false)
    private UserEntity user;

    protected AuthTokenEntity() {
    }

    public AuthTokenEntity(String token, UserEntity user) {
        this.token = token;
        this.user = user;
    }
}
