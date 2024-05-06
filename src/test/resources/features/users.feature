Feature: Consultar usuarios Api Rest
  Como administrador del aplicativo web
  Quiero consultar la información de los usuarios
  Para gestionar sus perfiles y datos

  #autor: Daniel Chaparro

  Background:
    Given que el administrador tiene acceso al sistema

    @test2
  Scenario Outline: Consultar un usuario existente por ID
    When se busca al usuario con Id <id>
    Then la respuesta debería tener el código de estado 200
    And la respuesta debería incluir la información del usuario con ID <id>
    Examples:
      | id |
      | 1  |
      | 2  |
      | 3  |
      | 4  |