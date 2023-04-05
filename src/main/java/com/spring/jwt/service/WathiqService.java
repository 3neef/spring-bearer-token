package com.spring.jwt.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.spring.jwt.model.BusinessType;
import com.spring.jwt.model.Location;
import com.spring.jwt.repos.BusinessTypeRepository;
import com.spring.jwt.repos.LocationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class WathiqService{
    String Url
            = "https://api.wathq.sa/v5/commercialregistration/";
    @Bean
    private Object headers()  {
        HttpHeaders headers = new HttpHeaders();
        headers.add("apikey", "skwAyrXpbfHcLAJAna6JSN5kIz4KRGU3");
        return new HttpEntity<Object>(headers);
    }
    @Autowired
    private LocationRepository locationRepository;

    @Autowired
    private BusinessTypeRepository businessTypeRepository;
    public JsonNode locations(){
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<String> response =  restTemplate.exchange(Url + "lookup/locations",
                HttpMethod.GET, (HttpEntity<?>) this.headers(), String.class);
        ObjectMapper mapper = new ObjectMapper();
        JsonNode locations;
        try {
            locations = mapper.readTree(response.getBody());
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
        locations.forEach((location)-> locationRepository.save(new Location(0L,
                Long.parseLong(location.get("id").textValue()),
                location.get("name").textValue(),
                location.get("nameEn").textValue())));
        return locations;

    }
    public JsonNode businessTypes(){
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<String> response =  restTemplate.exchange(Url + "lookup/businessTypes",
                HttpMethod.GET, (HttpEntity<?>) this.headers(), String.class);
        ObjectMapper mapper = new ObjectMapper();
        JsonNode types;
        try {
            types = mapper.readTree(response.getBody());
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
        types.forEach((type)-> businessTypeRepository.save(new BusinessType(0L,
                Integer.parseInt(type.get("id").textValue()),
                type.get("name").textValue(),
                type.get("nameEn").textValue())));
        return types;

    }
}
