Feature: Pruebas del Recurso de Usuarios en Reqres.in

  Background:
    Given que soy un usuario autenticado correctamente


  Scenario: Obtener detalles de un usuario que es existente
    When solicito los detalles del usuario con el ID 1
    Then el codigo de estado de la respuesta deberia de ser un 200
    And la respuesta deberia de ser un JSON
    And la respuesta debería de contener los siguientes campos:
      | id     |
      | email  |
      | first_name |
      | last_name |

  @ActualizarUsuario
  Scenario: Actualizar los detalles de un usuario existente
    Given que tengo detalles de usuario actualizados
    When envío una solicitud PUT para actualizar el usuario con ID 1
    Then la respuesta debería tener el código de estado 200
    And el contenido de la respuesta debería ser JSON
    And la respuesta debería contener los detalles actualizados del usuario
