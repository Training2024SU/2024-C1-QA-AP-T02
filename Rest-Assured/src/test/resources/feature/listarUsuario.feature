Feature: Listar un usuario por su id en Reqrest
  Yo como usuario de reqrest
  Quiero poder listar la información de un usuario
  Para ver sus detalles y realizar acciones relacionadas

  @testcorrecto
  Scenario: Listar informacion de un usuario existente correctamente
    When se llama el servicio listar un solo usuario por su id
    Then el servicio deberia responder con un codigo de estado HTTP 200 OK
    And se deberia visualizar los detalles del usuario correctamente
