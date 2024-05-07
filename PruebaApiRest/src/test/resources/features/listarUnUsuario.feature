#language:es
  #encoding:UTF-8
  #Author: Devon Jose Alvarez Osorio

  @test1
Característica: Verificar la funcionalidad de un servicio GET para obtener un solo usuario
  Yo Como usuario
  Quiero verificar que un servicio GET devuelva un solo usuario correctamente
  Para asegurarme de que puedo obtener la información de un usuario específico

  Escenario: Verificar obtención de un solo usuario
    Dado que el servicio GET de usuarios está en línea y accesible
    Cuando realiza una solicitud GET al endpoint
    Entonces deberia devolver un código de estado HTTP 200
    Y la respuesta con información del usuario con email
