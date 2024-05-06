Feature: User Information Retrieval
  As a user of the application,
  I want to retrieve user information,
  So that I can interact with user data.

  Background:
    Given the user service is online

  @RetrieveUser
  @RetrieveAll
  @Users
  Scenario: User found
    When a GET request is made to "https://reqres.in/api/users/2"
    Then the response should have status code 200
    And the response should contain the expected user information

  @UserNotFound
  @RetrieveAll
  @Users
  Scenario: User not found
    When a GET request is made to "https://reqres.in/api/users/23"
    Then the response should have status code 404



