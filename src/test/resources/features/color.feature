Feature: Personalizar color del perfil
  Como usuario del aplicativo web
  Quiero gestionar el color de mi perfil
  Para personalizar la paleta de colores en el aplicativo

  #autor: Daniel Chaparro

  Background:
    Given que el usuario esta autenticado en el aplicativo

  @testcolor
  Scenario: Actualizar un nuevo color exitosamente
    When el usuario actualiza un color con nombre "rojo", año 2003, color "#C74375" y valor Pantone "17-2031"
    Then debería ver un mensaje de confirmación de que el color fue actualizado correctamente

  Scenario: Actualizar un color existente exitosamente
    Given que el usuasrio ha agregado un color con nombre "rojo"
    When el usuario actualiza el color con nombre "rojo" cambiando su año a 2020 y su color a "#C74375"
    Then debería ver un mensaje de confirmación con la informacion actualizada del color