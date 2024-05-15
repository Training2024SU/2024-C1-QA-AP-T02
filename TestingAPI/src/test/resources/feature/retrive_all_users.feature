 Feature: Retrieve all user

 # Retrive all users from jsonplaceholder.typicode.com
 @RetrieveAllUser
 @RetrieveAll
 Scenario: Retrieve all the users information
 When a GET request is made to "https://jsonplaceholder.typicode.com/users"
 Then the response should have status code 200