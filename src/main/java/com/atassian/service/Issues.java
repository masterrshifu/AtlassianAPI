package com.atassian.service;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import org.springframework.stereotype.Service;

@Service
public class Issues {

    private static final String API_KEY = "ATATT3xFfGF0C477TZowojlGsJ1JIQSBQY_Bj7_wGzB1ueHlghdAciRUDKPP46oabdyPgSwtHGpX-uiQQlQvvq7b0Oy8a5X9l9XPwGbvxdz7jTWUlN-_y4VFLCiDLiklXJF7dV_RrRmW9Qb-c3VyJHWh-9yhvyNoBvIwpGFTf7v9qjXVDcKwzDU=CC218E33";

    private static final String API_KEY1 = "ATATT3xFfGF0jEdN1_cQXhpR79f7vziikdJ1JxnYHYf9KVlWYG5TnOUq3X2tQtPQcasNmIZTulwq7YnFH9RHz3cVG21TOKfT5Vs6c1VliLPqxhSN9_4Qy0zDm0yMS5LO-eDcc8fz4ICQsDjSfp16MxoLT2egV81068uJV3c_39Y80VTen5n_-G8=5DD365B4";


    public JsonNode getIssues() throws UnirestException {

        HttpResponse<JsonNode> response = Unirest.get("https://programmingwithakshay.atlassian.net/rest/api/3/issue/createmeta")
                .basicAuth("programmingwithakshay@gmail.com", API_KEY)
                .header("Accept", "application/json")
                .asJson();

        System.out.println(response);

        return response.getBody();
    }

    public JsonNode getIssueById(int issueId) throws UnirestException {

        String apiUrl = "https://programmingwithakshay.atlassian.net/rest/api/3/issue/" + Integer.toString(issueId);

        HttpResponse<JsonNode> response = Unirest.get(apiUrl)
                .basicAuth("programmingwithakshay@gmail.com", API_KEY)
                .header("Accept", "application/json")
                .asJson();

        System.out.println(response.getBody());

        return response.getBody();

    }

    public JsonNode getIssueById(String issueId) throws UnirestException {

        String apiUrl = "https://akshayagarwal.atlassian.net/rest/api/3/issue/" + issueId;

        HttpResponse<JsonNode> response = Unirest.get(apiUrl)
                .basicAuth("akshay.agarwal@epikso.com", API_KEY1)
                .header("Accept", "application/json")
                .asJson();

        System.out.println(response.getBody());

        return response.getBody();

    }

    public String getIssueId() {
        String url = "https://akshayagarwal.atlassian.net/jira/software/projects/TT/boards/1?selectedIssue=TT-1";

        String substring = url.substring(url.lastIndexOf('=') + 1);
        return substring;
    }

}
