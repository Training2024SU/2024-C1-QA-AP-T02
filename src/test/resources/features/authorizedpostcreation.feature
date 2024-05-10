Feature: Pruebas del Recurso de Posts

  Background:
    Given soy un usuario que se encuentra autenticado

  @Test4
  Scenario: Intentar crear un post con autenticación
    Given que estoy autenticado
    When envio una solicitud POST para crear un nuevo post
    Then el codigo de estado de la respuesta deberia de ser 201

