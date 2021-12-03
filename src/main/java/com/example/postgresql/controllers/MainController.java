package com.example.postgresql.controllers;

import com.example.postgresql.models.Form;
import com.example.postgresql.models.User;
import com.example.postgresql.services.UserAdvancedService;
import com.example.postgresql.services.UserService;
import com.example.postgresql.services.ValidationService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@Controller
public class MainController {

    private final UserService userService;
    private final UserAdvancedService userAdvancedService;
    private final ValidationService validationService;

    public MainController(UserService userService, UserAdvancedService userAdvancedService, ValidationService validationService) {

        this.userService = userService;
        this.userAdvancedService = userAdvancedService;
        this.validationService = validationService;
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

    @PostMapping("/users-add")
    public String addUser(@Valid User user, Model model) {
        model.addAttribute("title", "Add user");
        return "add-user";
    }

    @PostMapping("/adduser")
    public String addUser(@Valid User user, BindingResult result, Model model) {

        String err = validationService.validateUser(user);

        if (!err.isEmpty()) {
            ObjectError error = new ObjectError("globalError", err);
            result.addError(error);
        }
        if (result.hasErrors()) {
            return "add-user";
        }

        userService.save(user);
        return "redirect:/users";
    }

    @GetMapping("/edit/{email}")
    public String showUpdateForm(@PathVariable("email") String email, Model model) {
        User user = userService.findUser(email);

        model.addAttribute("user", user);
        return "update-user";
    }

    @PostMapping("/update/{email}")
    public String updateUser(@PathVariable("email") String email, @Valid User user,
                             BindingResult result, Model model) {

        String err = validationService.validateUser(user);

        if (!err.isEmpty()) {
            ObjectError error = new ObjectError("globalError", err);
            result.addError(error);
        }

        if (result.hasErrors()) {
            user.setEmail(email);
            return "users";
        }

        userService.save(user);
        return "redirect:/users";
    }

    @GetMapping("/delete/{email}")
    public String deleteUser(@PathVariable("email") String email, Model model) {
        User user = userService.findUser(email);
        userService.delete(user);
        return "redirect:/users";
    }

    @GetMapping("/form")
    public String showForm(@Valid User user) {
        return "add-user";
    }
}
