Feature: Ver un usuario en especifico
  yo como usuario de la aplicacions regres.in
  quiero obener un usuario en especifico
  para visualizarlo
#autor: Jorge


  Scenario: Obtener un usuario en especifico exitosamente
    Given que el usuario hace la solicitud de encontrar un usuarios
    When hace la peticion get al servicio con sus credenciales
    Then deberia obetner la informacion del usuario
    And  deberia visualizar los datos del usuario con ese numero
