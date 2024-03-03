package com.meri.murdermysterygame.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "person")
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "license_id")
    private Long license_id;

    @Column(name = "address_number")
    private int address_number;

    @Column(name = "address_street_name")
    private String address_street_name;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getLicense_id() {
        return license_id;
    }

    public void setLicense_id(Long license_id) {
        this.license_id = license_id;
    }

    public int getAddress_number() {
        return address_number;
    }

    public void setAddress_number(int address_number) {
        this.address_number = address_number;
    }

    public String getAddress_street_name() {
        return address_street_name;
    }

    public void setAddress_street_name(String address_street_name) {
        this.address_street_name = address_street_name;
    }
}
