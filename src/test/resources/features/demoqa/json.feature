Feature: Pruebas del Recurso de Posts

  Background:
  Given soy un usuario autenticado
  @Test1
  Scenario: Obtener detalles de un post existente
  When solicito los detalles del post con ID 1
  Then el código de estado de la respuesta debería ser 200
  And el tipo de contenido de la respuesta debería ser JSON
  And la respuesta debería contener los siguientes campos:
  | userId |
  | id     |
  | title  |
  | body   |

  @rutacritica
  Scenario: Crear un nuevo post
  Given que tengo un objeto de post válido
  When envío una solicitud POST para crear un nuevo post
  Then el código de estado de la respuesta debería ser 201
  And el tipo de contenido de la respuesta debería ser JSON
  And la respuesta debería contener el ID del nuevo post creado

  Scenario: Intentar obtener detalles de un post inexistente
  When solicito los detalles de un post que no existe
  Then el código de estado de la respuesta debería ser 404

  Scenario: Intentar crear un post sin autenticación
  When que no estoy autenticado
  When envío una solicitud POST para crear un nuevo post
  Then el código de estado de la respuesta debería ser 401




Feature: Pruebas del Recurso de Usuarios

  Background:
  Given que soy un usuario autenticado

  @test2
  Scenario: Obtener detalles de un usuario existente
  When solicito los detalles del usuario con ID 1
  Then el código de estado de la respuesta debería ser 200
  And el tipo de contenido de la respuesta debería ser JSON
  And la respuesta debería contener los siguientes campos:
  | id     |
  | name   |
  | email  |
  | phone  |
  | website|

  @rutacritica
  Scenario: Intentar obtener detalles de un usuario inexistente
  When solicito los detalles de un usuario que no existe
  Then el código de estado de la respuesta debería ser 404

  Scenario: Actualizar los detalles de un usuario existente
  Given que tengo detalles de usuario actualizados
  When envío una solicitud PUT para actualizar el usuario con ID 1
  Then el código de estado de la respuesta debería ser 200
  And el tipo de contenido de la respuesta debería ser JSON
  And la respuesta debería contener los detalles actualizados del usuario

  Scenario: Intentar actualizar los detalles de un usuario inexistente
  Given que tengo detalles de usuario actualizados
  When envío una solicitud PUT para actualizar un usuario que no existe
  Then el código de estado de la respuesta debería ser 404

  Scenario: Intentar actualizar los detalles de un usuario sin autenticación
  Given que no estoy autenticado
  When envío una solicitud PUT para actualizar al usuario con ID 1
  Then el código de estado de la respuesta debería ser 401

