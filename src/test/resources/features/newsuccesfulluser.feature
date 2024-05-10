Feature: Crear Nuevo Usuario con Éxito

  Background:
    Given que soy un usuario autenticado

  Scenario: Crear un nuevo usuario con éxito
    When creo un nuevo usuario con los siguientes detalles:
      | nombre  | email            |
      | John    | john@example.com |
    Then el código de estado de la respuesta debería de ser 201
    And el tipo de contenido de la respuesta debería ser un JSON
    And la respuesta debería contener los detalles del usuario creado
