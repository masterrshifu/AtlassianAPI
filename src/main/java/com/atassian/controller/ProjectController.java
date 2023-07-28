package com.atassian.controller;

import com.atassian.service.Projects;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.exceptions.UnirestException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class ProjectController {

    @Autowired
    private Projects projects;

    @GetMapping("/projects")
    public ResponseEntity<JsonNode> getProjects() throws UnirestException {
        return new ResponseEntity<JsonNode>( projects.getProjects(), HttpStatus.OK);
    }
}
