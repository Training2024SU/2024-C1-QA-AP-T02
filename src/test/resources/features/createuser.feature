Feature: Pruebas del Recurso de Usuarios en Reqres.in

  Background:
    Given que soy un usuario que quiere autenticarse

  @CrearUsuario
  Scenario: Crear un nuevo usuario
    Given que tengo los siguientes datos :
      | nombre      | Emma    |
      | trabajo     | QA      |
      | email       | emma@example.com |
    When envía una solicitud POST para crear un nuevo usuario
    Then la respuesta debería de ser el código de estado 201
    And el contenido de la respuesta deberia ser un JSON
    And la respuesta debería contener los detalles del nuevo usuario
