Feature: Eliminar Usuario
  Como adminsitrador del servicio de JSONPlaceholder
  Quiero poder eliminar usuarios
  Para mantener la integridad de la base de datos y actualizado el sistema

  @testcorrecto
  @eliminarexitoso
  Scenario: Eliminar un usuario existente
    Given que se requiere eliminar el usuario con ID 1
    When se llama el servicio DELETE para eliminar usuario
    Then el sistema deberia responder con un codigo de estado HTTP 202
