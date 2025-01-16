package com.cbrk.micro.service.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "micro_users")
@Data
public class User {

    @Id
    @Column(name = "ID")
    private String userId;


    @Column(name = "NAME", length = 255)
    private String name;

    @Column(name = "EMAIL")
    private String email;

    @Column(name = "ABOUT")
    private String about;


}
