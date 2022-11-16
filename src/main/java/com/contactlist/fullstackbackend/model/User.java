package com.contactlist.fullstackbackend.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Setter
@Getter
@Entity
public class User {
    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private String lastName;
    private String email;
    private Long phoneNumber;
}
