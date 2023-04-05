package com.spring.jwt.controller;

import com.spring.jwt.response.BasicResponse;
import com.spring.jwt.service.WathiqService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@RestController
@RequestMapping("api/wathiq")
public class WathiqController {
    @Autowired
    private WathiqService wathiqService;
    @GetMapping("/locations")
    public @ResponseBody ResponseEntity<?> getLookupLocations() {
        Object locations = wathiqService.locations();
        return new ResponseEntity<>(new BasicResponse("locations Imported!", "000", locations), HttpStatus.OK);
    }
    @GetMapping("/business-types")
    public @ResponseBody ResponseEntity<?> getBusinessTypes() {
        Object businessTypes = wathiqService.businessTypes();
        return new ResponseEntity<>(new BasicResponse("Business Types Imported", "000", businessTypes), HttpStatus.OK);
    }
}
