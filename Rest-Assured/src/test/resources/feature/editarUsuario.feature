Feature: Actualizar Usuario del servicio de JSONPlaceholder
  Como usuario del sistema
  Quiero poder editar mi información registrada
  Para corregir errores o actualizar la información según sea necesario

  @testcorrecto
  Scenario: Actualizar la informacion de un usuario existente correctamente
    Given que el usuario con ID 1 usuario requiere actualizar su informacion
    When solicita el servicio de editar la informacion de un usuario
    Then deberia visualizar que el servicio responde con un codigo de estado HTTP 200 OK
