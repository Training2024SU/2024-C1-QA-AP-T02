Feature: listar usuarios por userId
  yo como usuario del servicio JsonPlaceholder
  quiero revisar mi lista de usuarios
  para alcanzar los objetivos
#Autor: Julio Vasquez

  Background:
    Given un usuario administrador en la pagina web de jsonplaceholder

  @task4
  Scenario Outline: listar todos los todos por Id
    And consulta por userId <id>
    When envía la solicitud todos los usuarios
    Then la cantidad de todos debe ser 20
    Examples:
      | id |
      | 1  |