Feature: Books feature
  Scenario: Get all books
    When the client calls /books
    Then the client receives status code 200
    And the client receives a non-empty book list

