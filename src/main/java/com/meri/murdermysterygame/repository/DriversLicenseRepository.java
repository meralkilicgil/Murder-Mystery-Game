package com.meri.murdermysterygame.repository;

import com.meri.murdermysterygame.entity.DriversLicense;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DriversLicenseRepository extends JpaRepository<DriversLicense, Long> {

    List<DriversLicense> findAllByOrderById();
}
