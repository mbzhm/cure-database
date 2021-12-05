package com.example.postgresql.models;

import java.io.Serializable;

public class RecordId implements Serializable {
    private String email;
    private String country;
    private String diseaseCode;

    public RecordId() {
    }

    public RecordId(String email, String country, String diseaseCode) {
        this.email = email;
        this.country = country;
        this.diseaseCode = diseaseCode;
    }
}
