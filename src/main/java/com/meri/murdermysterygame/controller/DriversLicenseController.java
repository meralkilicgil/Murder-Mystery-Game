package com.meri.murdermysterygame.controller;

import com.meri.murdermysterygame.dto.DriversLicenseDto;
import com.meri.murdermysterygame.service.DriversLicenseService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class DriversLicenseController {

    private final DriversLicenseService driversLicenseService;

    public DriversLicenseController(DriversLicenseService driversLicenseService) {
        this.driversLicenseService = driversLicenseService;
    }

    @GetMapping("/getAllDriversLicense")
    public List<DriversLicenseDto> getAllDriversLicense(){
        return driversLicenseService.getDriversLicenseDtoList();
    }
}
