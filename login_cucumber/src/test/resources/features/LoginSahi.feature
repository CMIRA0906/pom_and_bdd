Feature: Hacer Login
Esta Feature contiene la especificacion de la funcionalidad Login 
de la aplicación SahiDemo
	
Scenario Outline: Login Exitoso
Given Que estoy en la interfaz de login del sitio web sahitest
When Ingrese las credenciales en Login <userName> and <Password>
And Verficar que la pagina desplegada sea "Books"

Examples:
	|userName|Password|
	|test	 |secret  |
	|test	 |secret |
	|test	 |secret |


