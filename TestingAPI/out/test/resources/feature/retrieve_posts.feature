Feature: Retrieve posts from JSONPlaceholder API

  @RetrieveAllPosts
  @RetrieveAll
  Scenario: Retrieve all posts information
    When a GET request is made to "https://jsonplaceholder.typicode.com/posts"
    Then the response should have status code 200
