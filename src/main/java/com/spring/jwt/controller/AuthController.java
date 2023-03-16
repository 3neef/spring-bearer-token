package com.spring.jwt.controller;

import com.spring.jwt.model.User;
import com.spring.jwt.repos.UserRepository;
import com.spring.jwt.requests.CreateUserRequest;
import com.spring.jwt.response.AuthResponse;
import com.spring.jwt.response.BasicResponse;
import com.spring.jwt.service.CustomDetailsService;
import com.spring.jwt.service.TokenService;
import com.spring.jwt.service.UserService;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/user")
public class AuthController {

    @Autowired
    private UserService userService;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private CustomDetailsService customDetailsService;
    private static final Logger LOG = LoggerFactory.getLogger(AuthController.class);

    private final TokenService tokenService;

    public AuthController(TokenService tokenService) {
        this.tokenService = tokenService;
    }

    @PostMapping("/register")
    public @ResponseBody ResponseEntity<?> register(@RequestBody @Valid CreateUserRequest request){
        User user = userService.create(request);

        return new ResponseEntity<>(new BasicResponse("User Created Successfully", "000", user), HttpStatus.OK);
    }

    @PostMapping("/login")
    public @ResponseBody ResponseEntity<?> token(Authentication authentication) {
        LOG.debug("Token requested for user: '{}'", authentication.getName());
        String token = tokenService.generateToken(authentication);
        LOG.debug("Token granted: {}", token);

        String name = authentication.getName();

        Optional<User> user = userRepository.findByName(name);

        return new ResponseEntity<>(new AuthResponse("User Logged in successfully", "000", user, token), HttpStatus.OK);
    }

}
