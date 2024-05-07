Feature: List users
  Me as a user of the get service
  want to handle the list of users
  for manage his information

  Background:
    Given the reqres API endpoint for users is accessible

  @GetAll
  Scenario: Getting users from page 2
    When sends the query Get to the system with page parameter set to 2
    Then the response status code should be 200
    And the response should contain user data

  @VerifyInfo
  Scenario: Verifying user information
    When sends the query Get to the system with page parameter set to 2
    Then the response status code should be 200
    And each user in the response should have a valid id
    And each user in the response should have a valid email

  @EmptyData
  Scenario: Requesting users with an invalid page number
    When sends the query Get to the system with page parameter set to 5
    Then the response status code should be 200
    And the response body should not contain user data

