package com.davidbonelo.stepdefinitions;

import io.cucumber.java.BeforeAll;
import io.restassured.RestAssured;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;

import static com.davidbonelo.stepdefinitions.ApiEndpoints.BASE_PATH;
import static com.davidbonelo.stepdefinitions.ApiEndpoints.BASE_URL;

public class RestSetup {

    @BeforeAll
    public void setup() {
        RestAssured.baseURI = BASE_URL;
        RestAssured.basePath = BASE_PATH;
        // log all the data from the sent requests and received responses
        RestAssured.filters(new RequestLoggingFilter(), new ResponseLoggingFilter());
    }
}
