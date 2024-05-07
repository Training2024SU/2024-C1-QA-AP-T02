Feature: Create New Web Post
  I as the user on the services of Json placeholder
  Want to create new web posts
  for interact with the community with my own post

  @test1
  Scenario Outline: Successful Post Creation
    Given the user is in the web platform
    When the user correctly enters their post details
      | userId   | id   | title   | body   |
      | <userId> | <id> | <title> | <body> |
    Then it should see his webpost in the system
    And it should get a 201 code succesfully
    Examples:
      | userId | id  | title                    | body                         |
      | 11     | 101 | alice                    | wonderland is a crazy place  |
      | 11     | 101 | alice and the mirror     | everything is different here |
      | 11     | 101 | alice and the mad hatter | his perspective is twisted   |
