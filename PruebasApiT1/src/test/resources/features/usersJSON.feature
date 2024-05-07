Feature: Get users of JSON API
  Me as a user of the JSON service
  want to retrieve the list of users from the site
  for interaction with user data effectively
  #Juan Garcia

  Scenario: Retrieving users
    Given the JSONAPI endpoint for users is accessible
    When sends a GET request to the users endpoint
    Then the response status code must be 200
    And the response should contain at least one user with a valid name
