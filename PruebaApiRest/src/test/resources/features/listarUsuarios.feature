#language:es
  #encoding:UTF-8
  #Author: Devon Jose Alvarez Osorio

@test3
Característica: Verificar la funcionalidad de un servicio GET de la pagina jsonplaceholder.typicode
Yo Como usuario
Quiero verificar que un servicio GET devuelva todos los usuario
Para obtener una lista con la información de todos los usuarios

Escenario: : Verificar obtención de todos los usuarios
Dado que el servicio GET en la pagina jsonplaceholder.typicode está en línea y accesible
Cuando realiza una solicitud GET al endpoint en la pagina
Entonces deberia mostrar un código de estado HTTP 200
