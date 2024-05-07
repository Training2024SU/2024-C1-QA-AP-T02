Feature: Personalizar color del perfil
  Como usuario del aplicativo web
  Quiero gestionar el color de mi perfil
  Para personalizar la paleta de colores en el aplicativo

  #autor: Daniel Chaparro

  Background:
    Given que el usuario esta autenticado en el aplicativo

  @testcolor
  Scenario: Actualizar un nuevo color exitosamente mediante peticion put
    When el usuario realiza una solicitud PUT para actualizar el color con nombre "rojo"
    And actualiza los campos a año 2003, color "#C74375" y valor Pantone "17-2031"
    Then debería tener la respuesta el código de estado 200
    And se debería mostrar un mensaje con la informacion del color correctamente actualizada

  @testcolorDetele
  Scenario: Eliminar un color exitosamente mediante una solicitud DELETE
    When el usuario realiza una solicitud DELETE para eliminar el color con ID 2
    Then la respuesta debería tener un codigo de estado 204
    And el cuerpo de la respuesta debería estar vacío