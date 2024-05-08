Feature: Ver un usuario en especifico
  yo como usuario de la aplicacions regres.in
  quiero obener un usuario en especifico
  para visualizarlo
#autor: Jorge

  @test1
  Scenario Outline: Obtener un usuario en especifico exitosamente
    Given Estando el usuario en la seccion de obtener un usuario
    When Se hace la solicitud de encontrar un usuario
    Then hace la peticion get al servicio con sus id 2
      | id   | email   | firstName   | lastName   |
      | <id> | <email> | <firstName> | <lastName> |
    And deberia obetner la informacion del usuario
   Examples:
     | id | email                  | firstName | lastName |
     | 2  | janet.weaver@reqres.in | Janet     | Weaver   |
