Feature: Post delete of JSON api
  Me as a user of the json service
  want to handle the posts of the site
  for make a correct handle of the posts
  #Juan Garcia

  @validID
  Scenario: Deleting a post
    Given the JSONPlaceholder API endpoint for posts is accessible
    And there exists a post with id 1
    When sends a DELETE request to the post endpoint with id 1
    Then the response delete status code must be 200 deleting the user
  @NoValidID
  Scenario: Deleting a post with invalid ID
    Given the JSONPlaceholder API endpoint for posts is accessible
    And there exists no post with id -1
    When sends a DELETE request to the post endpoint with id -1
    Then the response delete status code must be 404 indicating resource not found
