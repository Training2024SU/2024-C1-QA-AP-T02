Feature: Handling posts services
  i as a user of JsonPlaceholder services
  want to create, read, update and delete posts
  to

  Scenario: Create a new post successfully
    Given the user is in the web page "https://jsonplaceholder.typicode.com/posts"
    When types the information for a new post
    And sends the request
    Then should receive a response with status code 201