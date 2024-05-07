Feature: Search Post Information on Json placeholder

  As a registered user on Json placeholder,
  I want to search for web Posts
  for view all relevant details of the web post

  Background:
    Given the user is registered on the Json placeholder platform

  @test1
  Scenario Outline: Successfully Search for Post information
    When the user enters the registered ID <id> of the post in the database
    Then should be able to view the post information
      | userId   | id   | title   | body   |
      | <userId> | <id> | <title> | <body> |
    And the server response should have a valid status code of 200
    Examples:
      | userId | id | title                                                                      | body                                                                                                                                                                                                                     |
      | 1      | 1  | sunt aut facere repellat provident occaecati excepturi optio reprehenderit | quia et suscipit\nsuscipit recusandae consequuntur expedita et cum\nreprehenderit molestiae ut ut quas totam\nnostrum rerum est autem sunt rem eveniet architecto                                                        |
      | 1      | 2  | qui est esse                                                               | est rerum tempore vitae\nsequi sint nihil reprehenderit dolor beatae ea dolores neque\nfugiat blanditiis voluptate porro vel nihil molestiae ut reiciendis\nqui aperiam non debitis possimus qui neque nisi nulla        |
      | 1      | 3  | ea molestias quasi exercitationem repellat qui ipsa sit aut                | et iusto sed quo iure\nvoluptatem occaecati omnis eligendi aut ad\nvoluptatem doloribus vel accusantium quis pariatur\nmolestiae porro eius odio et labore et velit aut                                                  |
      | 2      | 20 | doloribus ad provident suscipit at                                         | qui consequuntur ducimus possimus quisquam amet similique\nsuscipit porro ipsam amet\neos veritatis officiis exercitationem vel fugit aut necessitatibus totam\nomnis rerum consequatur expedita quidem cumque explicabo |