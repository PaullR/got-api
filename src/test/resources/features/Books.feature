Feature: Books feature
  Scenario: Get all books
    When the client calls /books
    Then the client receives status code 200
    And the client receives a non-empty book list
  Scenario: Filter by bookName not present in the list
    When the client searches a book which is not present in the list test
    Then the client receives status code 200
    And the client receives an empty book list
  Scenario: Filter by bookName present in the list
    When the client searches by bookName A Game of Thrones
    Then the client receives status code 200
    And the client receives a non-empty book list
    And the book name is correct
  Scenario: Get book not present in the list by bookId
    When the client searches a book which is not present in the list by id 123456
    Then returned status code for not found book is 500
  Scenario: Get book present in the list by bookId
    When the client searches a book which is present in the list by id 1
    Then returned status code for found book is 200
    And the client receives a book with id 1
