Feature: obtener usuario por id en Reqres
  yo como usuario registrado de Reqres
  quiero obtener la informacion de un usuario en el sistema
  para poder acceder a su informacion
#Autor: Julio Vasquez

  Background:
    Given el usuario se encuentra en la pagina de perfil
  @task2
  Scenario Outline: Obtener la informacion de un usuario
    When se pide al servicio la informacion por su id <id>
    Then deberia recibir una respuesta con el codigo 200
    And deberia recibir la informacion del usuario <id>
    Examples:
      | id   |
      | "1"  |
      | "12" |