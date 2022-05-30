package com.got.gotapi.cucumber;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.util.List;
import java.util.Map;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class BookFeatureStepDefinitions extends CucumberUtils {

    public static final String BOOKS_URL = "http://localhost:8080/books";
    public static final String PATH_VARIABLE_NAME = "?name=";
    public static final String BOOK_NAME = "A Game of Thrones";

    @When("^the client calls /books$")
    public void the_client_calls_GET_all_books() throws Throwable {
        executeGet(BOOKS_URL, "/");
    }

    @Then("^the client receives status code (\\d+)$")
    public void the_client_receives_success_status_code(int statusCode) throws Throwable {
        int currentStatusCode = latestResponse.getStatusCode();
        assertThat("Status code is " +
                currentStatusCode + ". Expected status code is 200" , currentStatusCode, is(statusCode));
    }

    @Then("^the client receives a non-empty book list$")
    public void the_client_receives_non_empty_book_list() throws Throwable {
        assertThat("book list is empty", !latestResponse.jsonPath().getList("$").isEmpty());
    }

    @When("^the client searches a book which is not present in the list (\\w+)$")
    public void the_client_searches_not_existent_book_name(String bookName) throws Throwable {
        executeGet(BOOKS_URL, PATH_VARIABLE_NAME + bookName);
    }

    @Then("^the client receives an empty book list$")
    public void the_client_receives_an_empty_book_list() throws Throwable {
        List<Map<String, String>> responseList = latestResponse.jsonPath().getList("$");
        assertThat("book list is not empty: " + responseList, responseList.isEmpty());
    }

    @When("^the client searches by bookName " + BOOK_NAME + "$")
    public void the_client_searches_existent_book_name() throws Throwable {
        executeGet(BOOKS_URL,PATH_VARIABLE_NAME + BOOK_NAME);
    }

    @Then("^a single book is returned$")
    public void single_book_is_returned() throws Throwable {
        List<Map<String, String>> responseList = latestResponse.jsonPath().getList("$");

        assertThat(responseList.size() + " books were found. Only one  was expected", responseList.size()==0);
    }

    @Then("^the book name is correct$")
    public void the_book_name_is_correct() throws Throwable {
        List<Map<String, String>> responseList = latestResponse.jsonPath().getList("$");

        assertThat("Incorrect book name", responseList.get(0).get("name").equals(BOOK_NAME));
    }

    @When("^the client searches a book which is not present in the list by id (\\d+)$")
    public void the_client_searches_not_existent_book_by_id(int bookId) throws Throwable {
        executeGet(BOOKS_URL,"/" + bookId);
    }

    @Then("^returned status code for not found book is (\\d+)$")
    public void book_not_found_by_id(int statusCode) throws Throwable {
        int currentStatusCode = latestResponse.getStatusCode();
        assertThat("Status code is " +
                currentStatusCode + ". Expected status code is " + statusCode, currentStatusCode, is(statusCode));
    }

    @When("^the client searches a book which is present in the list by id (\\d+)$")
    public void the_client_searches_existent_book_by_id(int bookId) throws Throwable {
        executeGet(BOOKS_URL,"/" + bookId);
    }

    @Then("^returned status code for found book is (\\d+)$")
    public void success_code_for_book_found_by_id(int statusCode) throws Throwable {
        int currentStatusCode = latestResponse.getStatusCode();
        assertThat("Status code is " +
                currentStatusCode + ". Expected status code is" + statusCode , currentStatusCode, is(statusCode));
    }

    @Then("^the client receives a book with id (\\d+)$")
    public void book_found_successfully_by_id(int statusCode) throws Throwable {
        String url = latestResponse.jsonPath().get("url");
        assertThat("Wrong book url", url, is("https://www.anapioficeandfire.com/api/books/" + 1));

    }

}
