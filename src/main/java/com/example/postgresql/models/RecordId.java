package com.example.postgresql.models;

import com.example.postgresql.models.disease.Disease;

import java.io.Serializable;

public class RecordId implements Serializable {
    private String email;
    private String country;
    private Disease disease;

    public RecordId() {
    }

    public RecordId(String email, String country, Disease disease) {
        this.email = email;
        this.country = country;
        this.disease = disease;
    }
}
