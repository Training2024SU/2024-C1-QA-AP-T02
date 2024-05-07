Feature: Handling posts services
  i as a user of JsonPlaceholder services
  want to create, read, update and delete posts
  in order to manage my content effectively

  Background:
    Given the user is in the web page "https://jsonplaceholder.typicode.com"

  @test1
  Scenario: Create a new post successfully
    When types information for a new post "Testing" "Posts service testing"
    And sends the request
    Then should receive a response with status code 201
    And the title should be "Testing"

  @test2
  Scenario: get an existent post
    And has one posts id 5
    When requests for the id
    Then should has for title "nesciunt quas odio"
    And should has status code 200

  @test3
  Scenario: update an existing post
    And with post id 2
    When type information for update  2 "title updated" "body updated"
    And executes the request
    Then should receive status code 200

  @test4
  Scenario: delete a post
    And the post id to delete is 3
    When executes the delete request
    Then the status code should be 200