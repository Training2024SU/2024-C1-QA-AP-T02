Feature:  Registro de usuario en Reqrest
  yo como usuario de reqrest
  quiero poder registrarme en el sistema
  para acceder a funciones adicionales


  @registroexitoso
  Scenario: Registro exitoso de un nuevo usuario
    Given que el usuario ingresa sus datos correctamente
    When el usuario llama el servicio para registrarse
    Then el servicio deberia responder con un estado HTTP 200 OK
    And deberia visualizar su id y token asignados

