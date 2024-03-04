package com.meri.murdermysterygame.controller;

import com.meri.murdermysterygame.dto.DriversLicenseDto;
import com.meri.murdermysterygame.exception.ObjectNotFoundException;
import com.meri.murdermysterygame.service.DriversLicenseService;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/getDriversLicense")
    public DriversLicenseDto getDriversLicense(@RequestParam(name = "id") Long id){
        try {
            return driversLicenseService.getDriversLicenseById(id);
        } catch (ObjectNotFoundException e) {
            System.out.println("Drivers License cannot be found.");
        }
        return null;
    }

    @PostMapping("/addDriversLicense")
    public void addDriversLicense(@RequestBody DriversLicenseDto driversLicenseDto){
        driversLicenseService.createDriversLicense(driversLicenseDto);
    }

    @PutMapping("/updateDriversLicense")
    public void updateDriversLicense(@RequestBody DriversLicenseDto driversLicenseDto, @RequestParam(name = "id") Long id){
        driversLicenseService.updateDriversLicense(driversLicenseDto, id);
    }

    @DeleteMapping("/deleteDriversLicense")
    public void deleteDriversLicense(@RequestParam(name = "id") Long id){
        try {
            DriversLicenseDto driversLicenseDto = driversLicenseService.getDriversLicenseById(id);
            driversLicenseService.deleteDriversLicense(driversLicenseDto);
        } catch (ObjectNotFoundException e) {
            System.out.println("Drivers License cannot be found to delete.");
        }

    }
}
