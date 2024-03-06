package com.meri.murdermysterygame.dto;

public class InterviewDto{

    private Long id;
    private PersonDto person;

    private Long personId;
    private String transcript;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public PersonDto getPerson() {
        return person;
    }

    public Long getPersonId() {
        return personId;
    }

    public void setPersonId(Long personId) {
        this.personId = personId;
    }

    public void setPerson(PersonDto person) {
        this.person = person;
    }

    public String getTranscript() {
        return transcript;
    }

    public void setTranscript(String transcript) {
        this.transcript = transcript;
    }
}
