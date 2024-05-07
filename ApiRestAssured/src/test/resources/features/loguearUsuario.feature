Feature: loguear usuario en Reqres
  yo como usuario registrado de Reqres
  quiero loguearme en el sistema
  para poder acceder a las funcionalidades
#Autor: Julio Vasquez

  Background:
    Given el usuario se encuentra en la pagina inicio de sesion

  @task1
  Scenario Outline: Inicio de sesion exitoso
    When ingresa su email <email> con la contraseña <contrasena>
    Then deberia recibir una respuesta con el codigo de estado 200
    And deberia recibir un token
    Examples:
      | email                | contrasena |
      | "eve.holt@reqres.in" | "1548"     |
      | "eve.holt@reqres.in" | "hola2"    |