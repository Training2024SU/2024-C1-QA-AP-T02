Feature: Obtener un post específico desde JSONPlaceholder

  Como usuario de la aplicación JSONPlaceholder
  Quiero obtener un post específico por su ID
  Para poder ver sus detalles


  @post1
  Scenario: Obtener un post específico exitosamente
    Given Estoy en la sección de obtener un post específico
    When Hago la solicitud para obtener el post con ID 1
    Then Debería recibir el post con ID 1 y sus detalles
      | userId | id | title                                                                      | body                                                                                                                                                           |
      | 1      | 1  | sunt aut facere repellat provident occaecati excepturi optio reprehenderit | quia et suscipit\nsuscipit recusandae consequuntur expedita et cum\nreprehenderit molestiae ut ut quas totam\nnostrum rerum est autem sunt rem eveniet architecto|
