package com.jinnyjinnyjinjin.ecommerce.domain.user.entity;

import com.jinnyjinnyjinjin.ecommerce.domain.DateTimeEntity;
import lombok.Getter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import static javax.persistence.GenerationType.IDENTITY;

@Entity
@Getter
@Table(name = "USERS")
public class UserEntity extends DateTimeEntity {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;

    private String name;

    private String email;

    private String password;

    protected UserEntity() {
    }

    private UserEntity(String name, String email, String password) {
        this.name = name;
        this.email = email;
        this.password = password;
    }

    public static UserEntity create(String name, String email, String password) {
        return new UserEntity(name, email, password);
    }
}
