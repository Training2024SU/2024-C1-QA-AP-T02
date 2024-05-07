Feature: Get users of JSON API

  Scenario: Retrieving users
    Given the JSONAPI endpoint for users is accessible
    When sends a GET request to the users endpoint
    Then the response status code must be 200
    And the response should contain at least one user with a valid name
