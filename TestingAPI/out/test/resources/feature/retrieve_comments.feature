Feature: Retrieve comments from JSONPlaceholder API

  @RetrieveAllComments
  @RetrieveAll
  Scenario: Retrieve all comments information
    When a GET request is made to "https://jsonplaceholder.typicode.com/comments"
    Then the response should have status code 200
