package com.meri.murdermysterygame.dto;

import com.meri.murdermysterygame.entity.MainEntity;

public class InterviewDto implements MainDto{
    private Long personId;
    private String transcript;

    public Long getPersonId() {
        return personId;
    }

    public void setPersonId(Long personId) {
        this.personId = personId;
    }

    public String getTranscript() {
        return transcript;
    }

    public void setTranscript(String transcript) {
        this.transcript = transcript;
    }

    @Override
    public MainDto convertToDto(MainEntity entity) {
        return null;
    }

    @Override
    public MainEntity convertToEntity(MainDto dto) {
        return null;
    }
}
