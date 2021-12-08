package com.example.postgresql.models;

import javax.persistence.*;

@Entity
@Table(name="disease")
public class Disease {
    @Id
    @Column(name="disease_code")
    private String diseaseCode;

    @Column(name="pathogen")
    private String pathogen;

    @Column(name="description")
    private String disease_description;

    @OneToOne
    @JoinColumn(name="disease_code")
    private DiscoverDate discoverDate;

    @OneToOne
    @JoinColumn(name="id")
    private DiseaseType diseaseType;

    public Disease() {
    }

    public Disease(String diseaseCode, String pathogen, String disease_description, DiscoverDate discoverDate, DiseaseType diseaseType) {
        this.diseaseCode = diseaseCode;
        this.pathogen = pathogen;
        this.disease_description = disease_description;
        this.discoverDate = discoverDate;
        this.diseaseType = diseaseType;
    }

    public String getDiseaseCode() {
        return diseaseCode;
    }

    public void setDiseaseCode(String diseaseCode) {
        this.diseaseCode = diseaseCode;
    }

    public String getPathogen() {
        return pathogen;
    }

    public void setPathogen(String pathogen) {
        this.pathogen = pathogen;
    }

    public String getDisease_description() {
        return disease_description;
    }

    public void setDisease_description(String disease_description) {
        this.disease_description = disease_description;
    }

    public DiscoverDate getDiscoverDate() {
        return discoverDate;
    }

    public void setDiscoverDate(DiscoverDate discoverDate) {
        this.discoverDate = discoverDate;
    }

    public DiseaseType getDiseaseType() {
        return diseaseType;
    }

    public void setDiseaseType(DiseaseType diseaseType) {
        this.diseaseType = diseaseType;
    }
}
