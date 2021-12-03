package com.example.postgresql.services;

import com.example.postgresql.models.User;
import org.springframework.stereotype.Service;

@Service
public class ValidationService {
    public String validateUser(User user) {
        String message = "";
        if (user.getCountry() == null || user.getName() == null || user.getEmail() == null
        || user.getSurname() == null || user.getPhone() == null) {
            message = "Please fill out all the fields";
        }
        return message;
    }
}
