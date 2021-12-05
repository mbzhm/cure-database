package com.example.postgresql.models;

import com.sun.istack.NotNull;
import javax.persistence.*;

@Entity
@Table(name="Record")
@IdClass(RecordId.class)
public class Records {

    @Id
    @NotNull
    @Column(name="email")
    private String email;

    @Id
    @NotNull
    @Column(name="cname")
    private String country;

    @Column(name="total_deaths")
    private int total_deaths;

    @Column(name="total_patients")
    private int total_patients;

    @Id
    @Column(name="disease_code")
    private String diseaseCode;

    public Records() {

    }

    public String getDiseaseCode() {
        return diseaseCode;
    }

    public void setDiseaseCode(String diseaseCode) {
        this.diseaseCode = diseaseCode;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public int getTotal_deaths() {
        return total_deaths;
    }

    public void setTotal_deaths(int total_deaths) {
        this.total_deaths = total_deaths;
    }

    public int getTotal_patients() {
        return total_patients;
    }

    public void setTotal_patients(int total_patients) {
        this.total_patients = total_patients;
    }

    public Records(String email, String country, int total_deaths, int total_patients, String diseaseCode) {
        this.email = email;
        this.country = country;
        this.total_deaths = total_deaths;
        this.total_patients = total_patients;
        this.diseaseCode = diseaseCode;
    }
}
