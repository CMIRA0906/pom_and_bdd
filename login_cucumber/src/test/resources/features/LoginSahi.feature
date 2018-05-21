Feature: Hacer Login
Esta Feature contiene la especificacion de la funcionalidad Login 
de la aplicación SahiDemo
	
Scenario: Login Exitoso
Given El navegador desplegado
When Yo ingrese las credenciales "test" and "secret"
And De clic en el boton Aceptar
And Verficar que la pagina desplegada sea "Books"

Scenario: Login fallido
Given El navegador desplegado
When Yo ingrese las credenciales "fallido" and "secret"
And De clic en el boton Aceptar
And Verficar que la pagina desplegada sea "Login"
