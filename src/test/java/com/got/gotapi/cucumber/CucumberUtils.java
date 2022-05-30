package com.got.gotapi.cucumber;

import com.got.gotapi.GotApiApplication;
import io.cucumber.spring.CucumberContextConfiguration;
import io.restassured.RestAssured;
import io.restassured.parsing.Parser;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.springframework.boot.test.context.SpringBootTest;


import java.io.IOException;

@CucumberContextConfiguration
@SpringBootTest(classes = GotApiApplication.class, webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
public class CucumberUtils {
    static Response latestResponse = null;

    public void executeGet(String url, String path) throws IOException {
        RestAssured.defaultParser = Parser.JSON;
        RestAssured.baseURI = url;
        RequestSpecification httpRequest = RestAssured.given();
        latestResponse = httpRequest.get(url + path);
    }
}
