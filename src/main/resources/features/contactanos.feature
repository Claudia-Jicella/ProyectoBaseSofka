Feature: Contactenos
  Como cliente de la pagina My Store
  necesito contactarme por medio de Contactar Us
  para solicitar informacion del proveedor


  Background:
    Given que el cliente está en la página principal de la tienda virtual My Store

  @Scenario1
  Scenario: Servicio al cliente
    When selecciona Contac us la opcion Servicio al cliente e ingrese los campos obligatorios
    Then el sistema debera mostrar un mensaje de confimacion de envio de la solicitud

  @Scenario2
  Scenario: Webmaster
    When seleccione Contac us la opcion Webmaster e ingrese los campos obligatorios
    Then la pagina debera imprimir en pantalla la confirmacion de la solicitud
