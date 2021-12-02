package com.example.postgresql.controllers;

import com.example.postgresql.models.Form;
import com.example.postgresql.models.User;
import com.example.postgresql.services.UserAdvancedService;
import com.example.postgresql.services.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Controller
public class MainController {

    private final UserService userService;
    private final UserAdvancedService userAdvancedService;

    public MainController(UserService userService, UserAdvancedService userAdvancedService) {

        this.userService = userService;
        this.userAdvancedService = userAdvancedService;
    }

    @GetMapping("/")
    public String home(Model model){
        model.addAttribute("title", "Home page");
        return "home";
    }

    @GetMapping("/users-advanced-search")
    public String usersAdvancedSearch(String keyword,
                                      String country,
                                      String comparisonOperation,
                                      Integer salary,
                                      @RequestParam(defaultValue = "name") String sortBy,
                                      @RequestParam(defaultValue = "asc") String sortDirection,
                                      Model model){
        model.addAttribute("title", "Advanced Search (users)");

        List<User> users;

        if(keyword != null) {
            users = userService.findByKeyword(keyword);
        }else{
            users = userService.getAllUsers();
        }

        List<User> filteredByCountryUsers;

        if(country != null && !country.equals("None")) {
            filteredByCountryUsers = new ArrayList<>();
            userAdvancedService.filterByCountry(filteredByCountryUsers, users, country);
        }else{
            filteredByCountryUsers = users;
        }

        List<User> filteredBySalaryUsers;

        if(salary != null) {
            filteredBySalaryUsers = new ArrayList<>();
            userAdvancedService.filterBySalary(filteredBySalaryUsers, users, comparisonOperation, salary);
        }else{
            filteredBySalaryUsers = filteredByCountryUsers;
        }

        userAdvancedService.sortingBy(filteredBySalaryUsers, sortBy, sortDirection);
        model.addAttribute("users", filteredBySalaryUsers);
        model.addAttribute("form", new Form(keyword, comparisonOperation, salary, country, sortBy, sortDirection));
        return "users-advanced-search";
    }

    @GetMapping("/users")
    public String users(String keyword, Model model){
        model.addAttribute("title", "Users page");

        Iterable<User> users;
        if(keyword != null) {
            users = userService.findByKeyword(keyword);
        }else{
            users = userService.getAllUsers();
        }

        model.addAttribute("users", users);
        model.addAttribute("form", new Form(keyword));
        return "users";
    }
}
