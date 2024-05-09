Feature: Eliminar un post específico
  yo como admin de json holder
  quiero eliminar un usuario
  para confirmar que si proceda

  @deleteJH

  Scenario: Eliminar un post existente exitosamente
    Given Estoy en la página del API jsonplaceholder
    When Envío una solicitud DELETE para eliminar el post con ID 1
    Then Debería recibir un código de respuesta 200