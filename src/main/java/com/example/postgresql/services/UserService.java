package com.example.postgresql.services;

import com.example.postgresql.models.User;
import com.example.postgresql.repo.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
    public List<User> getAllUsers(){
        return userRepository.getAllUsers();
    }
    public List<User> findByKeyword(String keyword){
        return userRepository.findByKeyword(keyword);
    }
    public User findUser(String email) {
        return userRepository.findByEmail(email);
    }

    public void save(User user) {
        userRepository.save(user);
    }

    public void delete(User user) {
        userRepository.delete(user);
    }
}
