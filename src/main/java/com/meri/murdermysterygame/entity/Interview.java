package com.meri.murdermysterygame.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "interview")
public class Interview {

    @Id
    @Column(name = "person_id")
    private Long personId;

    @Column(name = "transcript")
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
