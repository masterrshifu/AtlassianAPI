package com.atassian.controller;

import com.atassian.service.TimeTracking;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class TimeTrackingController {

    @Autowired
    private TimeTracking timeTracking;

    @GetMapping("/response")
    public ResponseEntity<JsonNode> getResponse() {
        return new ResponseEntity<JsonNode>( timeTracking.getResponse(), HttpStatus.OK);
    }

    @GetMapping("/response/settings")
    public ResponseEntity<JsonNode> getSettingsResponse() {
        return new ResponseEntity<JsonNode>( timeTracking.getTimeTrackingSettings(), HttpStatus.OK);
    }

    @GetMapping("/hello")
    public String testMethod() {
        return new String("Hello World");
    }

    @Bean
    public MappingJackson2HttpMessageConverter mappingJackson2HttpMessageConverter() {
        ObjectMapper mapper = new ObjectMapper();
        mapper.configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false);
        MappingJackson2HttpMessageConverter converter = new MappingJackson2HttpMessageConverter(mapper);
        return converter;
    }
}
