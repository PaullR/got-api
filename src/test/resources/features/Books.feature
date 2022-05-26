Feature: Books feature
  Scenario: Client makes call to GET /books
    When the client calls /books
    Then the client receives status code of 200
