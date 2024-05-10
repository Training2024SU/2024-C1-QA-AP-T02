Feature: Pruebas del Recurso de Posts

  Background:
    Given soy un usuario autenticado

  @Test1
  Scenario: Obtener detalles de un post existente
    When solicito los detalles del post con ID 1
    Then el código de estado de la respuesta debería ser 200
    And el tipo de contenido de la respuesta debería ser JSON
    And la respuesta debería contener los siguientes campos:
      | userId |
      | id     |
      | title  |
      | body   |


