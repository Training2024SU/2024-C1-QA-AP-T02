Feature: Actualizar Usuario del servicio PUT de JSONPlaceholder
  Como usuario del sistema
  Quiero poder editar mi información registrada
  Para corregir errores o actualizar la información según sea necesario

  @testcorrecto
  @actualizarexitoso
  Scenario Outline: Actualizar la informacion de un usuario existente correctamente
    Given que el usuario con ID <id> requiere actualizar su informacion titulo <title> cuerpo <body> y userId <userId>
    When solicita el servicio PUT para actualizar la informacion del usuario
    Then deberia visualizar que el servicio responde con un codigo de estado HTTP 200 OK
    And deberia ver los datos del usuario actualizados, coincidiendo con los cambios realizados
    Examples:
    |id |title     |body     |userId|
    |1  |"Andreina"|"mesa"   |6     |
    |2  |"Casa"    |"Sofa"   |3     |

