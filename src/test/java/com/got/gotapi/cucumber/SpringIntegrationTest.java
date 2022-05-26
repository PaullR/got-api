package com.got.gotapi.cucumber;

import io.cucumber.spring.CucumberContextConfiguration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpMethod;
import org.springframework.web.client.RestTemplate;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.web.client.ResponseErrorHandler;


import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@CucumberContextConfiguration
@SpringBootTest
public class SpringIntegrationTest {
    static ResponseResults latestResponse = null;

    @Autowired
    protected RestTemplate restTemplate;

    void executeGet(String url) throws IOException {
        final Map<String, String> headers = new HashMap<>();
        headers.put("Accept", "application/json");
        final HeaderSettingRequestCallback requestCallback = new HeaderSettingRequestCallback(headers);
        final ResponseResultErrorHandler errorHandler = new ResponseResultErrorHandler();

        restTemplate.setErrorHandler(errorHandler);
        latestResponse = restTemplate.execute(url, HttpMethod.GET, requestCallback, response -> {
            if (errorHandler.hadError) {
                return (errorHandler.getResults());
            } else {
                return (new ResponseResults(response));
            }
        });
    }
}
