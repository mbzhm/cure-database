package com.example.postgresql.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="diseasetype")
public class DiseaseType {
    @Id
    @Column(name="id")
    private int diseaseType_id;

    @Column(name="description")
    private int diseaseType_description;

    public DiseaseType() {
    }

    public DiseaseType(int diseaseType_id, int diseaseType_description) {
        this.diseaseType_id = diseaseType_id;
        this.diseaseType_description = diseaseType_description;
    }

    public int getDiseaseType_id() {
        return diseaseType_id;
    }

    public void setDiseaseType_id(int diseaseType_id) {
        this.diseaseType_id = diseaseType_id;
    }

    public int getDiseaseType_description() {
        return diseaseType_description;
    }

    public void setDiseaseType_description(int diseaseType_description) {
        this.diseaseType_description = diseaseType_description;
    }
}
