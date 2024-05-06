Feature: API Listar Usuarios (API Listar Usuarios)

  Scenario:  Listar todos los usuarios
    Given el URL base para la API Listar Usuarios
    When envíe una solicitud GET a "/api/users"
    Then el código de estado de la respuesta debe ser 200
    And el cuerpo de la respuesta debe contener una lista de usuarios
    And cada usuario debe tener un id, correo electrónico, nombre y apellido

  Scenario: Endpoint inválido
    Given el URL base para la API Listar Usuarios
    When envíe una solicitud GET a un endpoint inválido
    Then el código de estado de la respuesta debe ser 404


Feature: API Usuario Individual (Single User API)

  Scenario: Obtener usuario único por id
    Given el URL base para la API Usuario Individual
    When envíe una solicitud GET a "/api/users/{user_id}"
    Then el código de estado de la respuesta debe ser 200
    And el cuerpo de la respuesta debe contener detalles del usuario
    And los detalles del usuario deben incluir id, correo electrónico, nombre y apellido

  Scenario: Usuario no encontrado
    Given el URL base para la API Usuario Individual
    When envíe una solicitud GET con un id de usuario inválido
    Then el código de estado de la respuesta debe ser 404
    And el cuerpo de la respuesta debe contener un mensaje de error
