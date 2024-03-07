package com.meri.murdermysterygame.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "person")
@Getter
@Setter
@NoArgsConstructor
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;

    @OneToOne(fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinColumn(name = "license_id", referencedColumnName = "id")
    @JsonBackReference
    private DriversLicense driversLicense;

    @Column(name = "address_number")
    private int addressNumber;

    @Column(name = "address_street_name")
    private String addressStreetName;

    @OneToMany(mappedBy = "person", cascade = CascadeType.ALL)
    @JsonBackReference
    private List<Interview> interviews;
}
