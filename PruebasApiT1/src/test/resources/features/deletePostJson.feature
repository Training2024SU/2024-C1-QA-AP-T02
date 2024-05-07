Feature: Post delete of JSON api

  Scenario: Deleting a post
    Given the JSONPlaceholder API endpoint for posts is accessible
    And there exists a post with id 1
    When sends a DELETE request to the post endpoint with id 1
    Then the response delete status code must be 200 deleting the user

