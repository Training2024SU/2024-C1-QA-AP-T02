Feature: Retrieve albums from JSONPlaceholder API

  @RetrieveAllAlbums
  @RetrieveAll
  Scenario: Retrieve all albums information
    When a GET request is made to "https://jsonplaceholder.typicode.com/albums"
    Then the response should have status code 200
