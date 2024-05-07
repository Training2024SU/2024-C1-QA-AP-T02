Feature: Handling user service
  i as a user
  want to create, read, update and delete users
  in order the access to the web page

  Background:
    Given the user's in the web page "https://reqres.in/api"

  @user
  @test1
  Scenario: create an user
    When types information for a new user "Alice" "QA automation"
    And sends the create user request
    Then should get a response with status code 201
    And the name shown should be "Alice"

  @user
  @test2
  Scenario: get all users
    When requests for all users
    Then total pages should be 2
    And the status code should get a 200

  @user
  @test3
  Scenario: update an user
    And with user id 7
    When type information to the user "Luis" "Leader"
    Then the status code for the update should be 200
    And the name should be "Luis"

  @user
  @test4
  Scenario: delete an user
    And has the user with id 8
    When executes the request for deleting
    Then should has a code 204

