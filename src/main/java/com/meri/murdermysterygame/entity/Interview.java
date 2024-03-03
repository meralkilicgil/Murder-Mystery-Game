package com.meri.murdermysterygame.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "interview")
public class Interview implements MainEntity{

    @Id
    @Column(name = "person_id")
    private Long person_id;

    @Column(name = "transcript")
    private String transcript;

    public Long getPerson_id() {
        return person_id;
    }

    public void setPerson_id(Long person_id) {
        this.person_id = person_id;
    }

    public String getTranscript() {
        return transcript;
    }

    public void setTranscript(String transcript) {
        this.transcript = transcript;
    }
}
