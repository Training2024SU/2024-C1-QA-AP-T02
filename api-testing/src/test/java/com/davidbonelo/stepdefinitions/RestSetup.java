package com.davidbonelo.stepdefinitions;

import io.cucumber.java.Before;
import io.cucumber.java.BeforeAll;
import io.restassured.RestAssured;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;

import static com.davidbonelo.ApiEndpoints.BASE_PATH;
import static com.davidbonelo.ApiEndpoints.BASE_URL;
import static com.davidbonelo.ApiEndpoints.PLACEHOLDER_BASE;

public class RestSetup {

    @BeforeAll
    public static void setup() {
        // log all the data from the sent requests and received responses
        RestAssured.filters(new RequestLoggingFilter(), new ResponseLoggingFilter());
    }

    @Before("@ReqRes")
    public static void setReqResUrl() {
        RestAssured.baseURI = BASE_URL;
        RestAssured.basePath = BASE_PATH;
    }

    @Before("@jsonPlaceholder")
    public static void setJsonPlaceholderUrl() {
        RestAssured.baseURI = PLACEHOLDER_BASE;
        RestAssured.basePath = "";
    }
}
