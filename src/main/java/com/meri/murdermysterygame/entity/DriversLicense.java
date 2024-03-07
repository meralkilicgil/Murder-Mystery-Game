package com.meri.murdermysterygame.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "drivers_license")
@Getter
@Setter
@NoArgsConstructor
public class DriversLicense {

    @Id
    @Column(name = "id")
    private Long id;

    @Column(name = "age")
    private int age;

    @Column(name = "height")
    private int height;

    @Column(name = "eye_color")
    private String eyeColor;

    @Column(name = "hair_color")
    private String hairColor;

    @Column(name = "gender")
    private String gender;

    @Column(name = "car_model")
    private String carModel;

    @OneToOne(mappedBy = "driversLicense", cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private Person person;
}
