package com.meri.murdermysterygame.dto;

import com.meri.murdermysterygame.entity.MainEntity;

public interface MainDto {
    MainDto convertToDto(MainEntity entity);

    MainEntity convertToEntity(MainDto dto);
}
