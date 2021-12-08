package com.example.postgresql.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="discover")
public class DiscoverDate {

    @Column(name="cname")
    private String country;

    @Id
    @Column(name="first_enc_date")
    private String date;

    public DiscoverDate() {
    }

    public DiscoverDate(String country, String date) {
        this.country = country;
        this.date = date;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
