package com.meri.murdermysterygame.service;

import com.meri.murdermysterygame.exception.ObjectNotFoundException;
import com.meri.murdermysterygame.dto.MainDto;

import java.util.List;

public interface RepositoryService {
    List<MainDto> getAll();
    MainDto getById(Long id) throws ObjectNotFoundException;

    void create(MainDto object);

    void update(MainDto object, Long id) throws ObjectNotFoundException;

    void delete(Long id) throws ObjectNotFoundException;
}
