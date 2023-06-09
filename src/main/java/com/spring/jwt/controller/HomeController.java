package com.spring.jwt.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.spring.jwt.response.BasicResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.security.Principal;
import java.util.Optional;

@RestController
public class HomeController {

    @GetMapping("/")
    public @ResponseBody ResponseEntity<?> home(Principal principal, Authentication authentication) {
        String name = authentication.getName();
        return new ResponseEntity<>(new BasicResponse("welcome home "+ name, "000", null), HttpStatus.OK);
    }
    @GetMapping("/quran")
    public @ResponseBody ResponseEntity<?> quran(Principal principal, Authentication authentication, Optional<String> language) {
        RestTemplate restTemplate = new RestTemplate();
        String Url
                = "https://api.quran.com/api/v4/chapters";
        String param = language.orElseGet(() -> "ar");
        ResponseEntity<String> response
                = restTemplate.getForEntity(Url + "?language=" + param, String.class);
        ObjectMapper mapper = new ObjectMapper();
        JsonNode chapters;
        try {
            chapters = mapper.readTree(response.getBody());
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
        return new ResponseEntity<>(new BasicResponse("All The Quran Chapters", "000", chapters), HttpStatus.OK);

    }

}
