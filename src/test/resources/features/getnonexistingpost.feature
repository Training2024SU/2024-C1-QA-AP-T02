Feature: Pruebas del Recurso de Posts

  Background:
    Given Estoy autenticado como usuario

  @Test3
  Scenario: Intento obtener detalles de un post inexistente
    When solicito detalles de un post que no existe
    Then el codigo de estado de la respuesta deberia ser 404
