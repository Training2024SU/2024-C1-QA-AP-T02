Feature: Agrear un nuevo post
  Como usuario del aplicativo web
  Quiero escribir un nuevo post
  Para expresar mi opinión y compartir contenido en el aplicativo

  #autor: Daniel Chaparro

  Background:
    Given que el usuario esta autenticado en el aplicativo web

    @testpost
  Scenario: Agregar un nuevo post exitosamente
    When el usuario escribe un nuevo post
    Then debería ver un mensaje de confirmación con la informacion de post actualizado
