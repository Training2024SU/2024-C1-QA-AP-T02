#language:es
  #encoding:UTF-8
  #Author: Devon Jose Alvarez Osorio

@test4
Característica: Verificar respuesta exitosa con código 200 en servicios REST
  yo como usuario del sistema
  quiero verificar que un servicio rest responda correctamente con un código 200
  para asegurar su disponibilidad y funcionamiento adecuado

  Escenario:Probar servicio REST con respuesta exitosa
    Dado que el servicio REST está en línea y accesible
    Cuando se realiza una solicitud tipo GET
    Entonces deberia ver un código de estado HTTP 200