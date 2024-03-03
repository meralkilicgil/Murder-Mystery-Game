package com.meri.murdermysterygame.dao;

import com.meri.murdermysterygame.entity.DriversLicense;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DriversLicenseDao extends JpaRepository<DriversLicense, Long> {

    List<DriversLicense> findAllByOrderById();
}
