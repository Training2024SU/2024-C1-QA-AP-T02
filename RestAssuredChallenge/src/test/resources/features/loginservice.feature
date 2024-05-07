Feature: login in the application
  i as a user of the reqres webpage
  want to make login
  to access to the available functionalities

  Background:
    Given the user browses the web page "https://reqres.in/api"

  @test1
  Scenario: login successful
    When uses the credentials "eve.holt@reqres.in" "cityslicka"
    Then the status code in the login should be 200
    And should get a token "QpwL5tke4Pnpja7X4"

  @test2
  Scenario: login with invalid credentials
    When enter the credentials "ev.holt@reqres.in" "cityslicka"
    Then the status code shown should be 400
    And should get a message "user not found"