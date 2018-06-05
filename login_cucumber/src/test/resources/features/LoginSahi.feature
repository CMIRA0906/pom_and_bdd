Feature: Hacer Login
Esta Feature contiene la especificacion de la funcionalidad Login 
de la aplicación SahiDemo
	
Scenario Outline: Login Exitoso
Given El navegador desplegado
When Yo ingrese las credenciales en Login <userName> and <Password>
And De clic en el boton Aceptar
And Verficar que la pagina desplegada sea "Books"

Examples:
	|userName|Password|
	|test	 |secret  |
	|test	 |secret |
	|test	 |secret |


