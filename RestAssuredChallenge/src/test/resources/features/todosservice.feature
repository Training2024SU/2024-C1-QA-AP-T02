Feature: Handling todos service
  i as a user of JsonPlaceholder services
  want to check my todo list
  to achieve the goals set

  Background:
    Given the user is browsing the web page "https://jsonplaceholder.typicode.com"

  @todos
  @test1
  Scenario: list all todos by userId
    And and queries by userId 1
    When sends the todos request
    Then the amount of todos should be 20
    And the status code would be 200

  @todos
  @test2
  Scenario: check completed value
    And queries by Id 4
    When executes the todos request
    Then the completed valued should be true
    And the status code shown would be 200

  @todos
  @test3
  Scenario: create a new todo
    And types information for a new todo for the user 5 "execute tests" "true"
    When executes the creation request
    Then should has a status code 201
    And in the title space should be "execute tests"


