Feature: Crear un nuevo post

  Background:
    Given soy un usuario autenticado

  @Test2
  Scenario: Crear un nuevo post
    Given que tengo un objeto de post válido
    When envío una solicitud POST para crear un nuevo post
    Then el codigo de estado de la respuesta debería ser 201
    And el tipo de contenido de la respuesta deberia ser JSON
    And la respuesta debería contener el ID del nuevo post creado
