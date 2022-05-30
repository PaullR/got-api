package com.got.gotapi.cucumber;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.springframework.http.HttpStatus;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class StepDefinitions extends SpringIntegrationTest {

    @When("^the client calls /books$")
    public void the_client_calls_GET_all_books() throws Throwable {
        executeGet("http://localhost:8080/books");
    }

    @Then("^the client receives status code (\\d+)$")
    public void the_client_receives_success_status_code(int statusCode) throws Throwable {
        HttpStatus currentStatusCode = latestResponse.getTheResponse().getStatusCode();
        assertThat("status code is correct : "+
                latestResponse.getBody(), currentStatusCode.value(), is(statusCode));
    }

    @Then("^the client receives a non-empty book list$")
    public void the_client_receives_non_empty_book_list() throws Throwable {
        String responseBody = latestResponse.getBody();
        assertThat("book list is empty", !responseBody.isEmpty());
    }

}
