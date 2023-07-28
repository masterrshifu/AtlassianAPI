package com.atassian.service;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TimeTracking {

    public JsonNode getResponse() {

        HttpResponse<JsonNode> response;

        {
            try {
                response = Unirest.get("https://programmingwithakshay.atlassian.net/rest/api/3/configuration/timetracking")
                        .basicAuth("programmingwithakshay@gmail.com", "ATATT3xFfGF0bhx8tHHtrkv5tmPdnsR9unLs-_2jYXTDT-hXow669xWpDVYGl4vkCpjkque-S_UI70EDDehcMvucmubM6a1KTqduKviCpLHU2GcGMJTH7j7azVkcECLXwMWm5i9XBnEn1COPl-c5CPAQ7sjTtIa7YR9Baqe55fTTH8Bv2fqadks=480FBC48")
                        .header("Accept", "application/json")
                        .asJson();
            } catch (UnirestException e) {
                throw new RuntimeException(e);
            }
        }
        System.out.println(response.getBody());

//        List<JsonNode> list = new ArrayList<>();
//        list.add(response.getBody());

        return response.getBody();
    }

    public JsonNode getTimeTrackingSettings() {

        HttpResponse<JsonNode> response;

        {
            try {
                response = Unirest.get("https://programmingwithakshay.atlassian.net/rest/api/3/configuration/timetracking/options")
                        .basicAuth("programmingwithakshay@gmail.com", "ATATT3xFfGF0bhx8tHHtrkv5tmPdnsR9unLs-_2jYXTDT-hXow669xWpDVYGl4vkCpjkque-S_UI70EDDehcMvucmubM6a1KTqduKviCpLHU2GcGMJTH7j7azVkcECLXwMWm5i9XBnEn1COPl-c5CPAQ7sjTtIa7YR9Baqe55fTTH8Bv2fqadks=480FBC48")
                        .header("Accept", "application/json")
                        .asJson();
            } catch (UnirestException e) {
                throw new RuntimeException(e);
            }
        }
        System.out.println(response.getBody());

        return response.getBody();
    }

}
