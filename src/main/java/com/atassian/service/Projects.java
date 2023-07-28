package com.atassian.service;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import org.springframework.stereotype.Service;

@Service
public class Projects {

    private static final String API_KEY = "ATATT3xFfGF0bhx8tHHtrkv5tmPdnsR9unLs-_2jYXTDT-hXow669xWpDVYGl4vkCpjkque-S_UI70EDDehcMvucmubM6a1KTqduKviCpLHU2GcGMJTH7j7azVkcECLXwMWm5i9XBnEn1COPl-c5CPAQ7sjTtIa7YR9Baqe55fTTH8Bv2fqadks=480FBC48";

    public JsonNode getProjects() throws UnirestException {

        HttpResponse<JsonNode> response = Unirest.get("https://programmingwithakshay.atlassian.net/rest/api/3/project")
                .basicAuth("programmingwithakshay@gmail.com", API_KEY)
                .header("Accept", "application/json")
                .asJson();

        System.out.println(response.getBody());

        return response.getBody();
    }
}
