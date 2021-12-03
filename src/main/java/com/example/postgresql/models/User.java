package com.example.postgresql.models;

import com.sun.istack.NotNull;
import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Entity
@Table(name="Users")
public class User {
    @Id
    @NotNull
    @NotEmpty(message = "User's email cannot be empty.")
    @Column(name="email")
    private String email;

    @NotNull
    @NotEmpty(message = "User's name cannot be empty.")
    @Size(max = 50)
    @Column(name="name")
    private String name;

    @NotNull
    @NotEmpty(message = "User's surname cannot be empty.")
    @Column(name="surname")
    private String surname;

    @Min(value = 0)
    @Column(name="salary")
    private int salary;

    @Column(name="phone")
    private String phone;

    @NotNull
    @Column(name="cname")
    private String country;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }
}
