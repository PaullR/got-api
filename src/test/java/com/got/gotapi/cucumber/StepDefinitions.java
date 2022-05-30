package com.got.gotapi.cucumber;

import io.cucumber.java.en.When;

public class StepDefinitions extends SpringIntegrationTest {

    @When("^the client calls /books$")
    public void the_client_calls_GET_all_books() throws Throwable {
        executeGet("http://localhost:8080/books");
    }
}
