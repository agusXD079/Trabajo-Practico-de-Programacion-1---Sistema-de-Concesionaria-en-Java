# Sistema de Concesionaria
Trabajo Práctico de Programación 1 - IFES

## Integrantes

* Thiago Vecchi
* Franco Araneda
* Ángel Venditti

## Descripción

Sistema de gestión de una concesionaria desarrollado en Java. Permite registrar vehículos, clientes, realizar ventas, consultar vehículos disponibles y visualizar el inventario ordenado por precio.

## Compilación

Abrir la terminal de **PowerShell** en el directorio raíz del proyecto y ejecuta:

javac -d bin (Get-ChildItem -Recurse *.java | Select-Object -ExpandProperty FullName)

## Ejecución
java -cp bin Main

## Funcionalidades

* Agregar vehículos.
* Registrar clientes.
* Vender vehículos.
* Mostrar vehículos disponibles.
* Mostrar inventario ordenado por precio.
* Persistencia de datos mediante serialización.
