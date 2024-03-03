package com.meri.murdermysterygame.dto;

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
}
