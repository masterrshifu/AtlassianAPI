package com.atassian.controller;

import com.atassian.service.Issues;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.exceptions.UnirestException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class IssueController {

    @Autowired
    private Issues issues;

    @GetMapping("/issues")
    public ResponseEntity<JsonNode> getProjects() throws UnirestException {
        return new ResponseEntity<JsonNode>( issues.getIssues(), HttpStatus.OK);
    }

    @GetMapping("/issue/{id}")
    public ResponseEntity<JsonNode> getIssueById(@PathVariable int id) throws UnirestException {
        return new ResponseEntity<JsonNode>( issues.getIssueById(id), HttpStatus.OK);
    }

    @GetMapping("issueDetails")
    public ResponseEntity<JsonNode> getIssueById() throws UnirestException {

        String issueId = issues.getIssueId();
        return new ResponseEntity<JsonNode>( issues.getIssueById(issueId), HttpStatus.OK);
    }

    @GetMapping("/issueId")
    public ResponseEntity<String> getIssueId() {
        return new ResponseEntity<String>( issues.getIssueId(), HttpStatus.OK);
    }
}
