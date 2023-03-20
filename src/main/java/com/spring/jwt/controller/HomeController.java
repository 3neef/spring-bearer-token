package com.spring.jwt.controller;

import com.spring.jwt.response.BasicResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@RestController
public class HomeController {

    @GetMapping("/")
    public @ResponseBody ResponseEntity<?> home(Principal principal, Authentication authentication) {
        String name = authentication.getName();
        return new ResponseEntity<>(new BasicResponse("welcome home "+ name, "000", null), HttpStatus.OK);
    }

}
