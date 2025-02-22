package com.demo.redis.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="user")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserEntity {

    @Id
    @Column(name="userId")

    private String userId;

    @Column(name="name")
    private String name;

    @Column(name = "email")
    private String email;

    @Column(name="password")
    private String password;


}
