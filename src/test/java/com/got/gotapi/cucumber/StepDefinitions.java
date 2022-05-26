package com.got.gotapi.cucumber;

import io.cucumber.java.en.When;

public class StepDefinitions extends SpringIntegrationTest {

    @When("^the client calls /version$")
    public void the_client_issues_GET_version() throws Throwable {
        executeGet("http://localhost:8080/version");
    }
}
