#language:es
  #encoding:UTF-8
  #Author: Devon Jose Alvarez Osorio
  @test2
Característica:Crear nuevo usuario mediante un servicio POST
yo como usuario del sistema
quiero Quiero poder crear un nuevo usuario utilizando un servicio POST
Para registrar usuarios en el sistema

Escenario: : Crear nuevo usuario exitosamente
Dado que el servicio POST está en línea y accesible
Cuando realiza una solicitud tipo POST
Entonces deberia devolver un codigo 201 indicando que el usuario fue creado correctamente