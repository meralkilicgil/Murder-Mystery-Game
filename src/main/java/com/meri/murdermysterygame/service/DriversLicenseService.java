package com.meri.murdermysterygame.service;

import com.meri.murdermysterygame.dao.DriversLicenseDao;
import com.meri.murdermysterygame.dto.DriversLicenseDto;
import com.meri.murdermysterygame.entity.DriversLicense;
import com.meri.murdermysterygame.exception.ObjectNotFoundException;
import com.meri.murdermysterygame.utils.DtoUtils;
import org.springframework.http.HttpStatusCode;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DriversLicenseService {

    private final DriversLicenseDao driversLicenseDao;

    public DriversLicenseService(DriversLicenseDao driversLicenseDao) {
        this.driversLicenseDao = driversLicenseDao;
    }

    public List<DriversLicenseDto> getDriversLicenseDtoList(){
        List<DriversLicense> driversLicenseList = driversLicenseDao.getAll();
        return driversLicenseList.stream().map(DtoUtils::convertDriverLicenseEntityToDriversLicenseDto).toList();
    }

    public DriversLicenseDto getDriversLicenseById(Long id) throws ObjectNotFoundException {
        Optional<DriversLicense> result = driversLicenseDao.getById(id);
        if(result.isPresent()){
            return DtoUtils.convertDriverLicenseEntityToDriversLicenseDto(result.get());
        }
        throw new ObjectNotFoundException("Drivers License cannot be found with Id: " + id, HttpStatusCode.valueOf(404));
    }

    public DriversLicenseDto createDriversLicense(DriversLicenseDto driversLicenseDto) throws ObjectNotFoundException {
        DriversLicense driversLicense = DtoUtils.convertDriversLicenseDtoToDriversLicenseEntity(driversLicenseDto);
        driversLicenseDao.create(driversLicense);
        return getDriversLicenseById(driversLicense.getId());
    }

    public DriversLicenseDto updateDriversLicense(DriversLicenseDto driversLicenseDto, Long id) throws ObjectNotFoundException {
        DriversLicense driversLicense = DtoUtils.convertDriversLicenseDtoToDriversLicenseEntity(driversLicenseDto);
        driversLicense.setId(id);
        driversLicenseDao.update(driversLicense);
        return getDriversLicenseById(id);
    }

    public void deleteDriversLicense(DriversLicenseDto driversLicenseDto){
        driversLicenseDao.delete(driversLicenseDto.getId());
    }
}
