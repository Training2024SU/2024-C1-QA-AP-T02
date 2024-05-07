Feature: Gestión de los servicios de correos
  yo como usuario del servicio JsonPlaceholder
  quiero gestionar mis correos
  para manejar mi contenido eficientemente
#Autor: Julio Vasquez

  Background:
    Given el usuario esta en la pagina web de jsonplaceholder

  @task3
  Scenario: crear un nuevo correo exitosamente
    When escribe la informacion para el nuevo correo "Prueba" "Prueba del servicio"
    And envia la solicitud
    Then deberia obtener un codigo de respuesta 201
    And el titulo debe ser "Prueba"