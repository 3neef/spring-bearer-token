package com.spring.jwt.service;

import com.spring.jwt.model.User;
import com.spring.jwt.repos.UserRepository;
import com.spring.jwt.requests.CreateUserRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public User create(CreateUserRequest userRequest) {
        User user = new User(0, userRequest.getName(),userRequest.getEmail(),userRequest.getPassword());
        User result = userRepository.save(user);
        return result;
    }
}
