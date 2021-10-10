# new feature
# Tags: optional

Feature: Como empleaado administrativo
  necesito ingresar al sistema los estudiantes de los nuevos ciclos academicos
  con el fin de cumplir las politicas administrativas y de auditoria de la universidad

  Scenario: Ingreso de un estudiante con los campos obligatorios
    Given que el empleado administrativo se encuentre en la pagina web de los ingresos de estudiantes
    When el empleado administrativo ingresa los campos obligatorios y confirma la accion
    Then el sistema debera mostrar por pantalla el registro del estudiante ingresado.