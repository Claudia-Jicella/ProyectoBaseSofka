
Feature: Carro de compras
  Como cliente de la pagina My Store
  necesito hacer uso del carrito de commpras
  para guardar los productos que deseo comprar


  Background:
    Given que el cliente se encuentra en la pagina de inicio y se loggeo con exito

  Scenario: Agregar producto al carrito
    When el cliente escoge los productos que quiere comprar y los agrega al carrito
    Then en la pagina debera aparecer los productos escogidos en el carro

  Scenario: borrar los productos del carro
    When el cliente tenga productos en el carrito y quiera borrarlos
    Then  en la pagina le debe aparecer el carro vacio