Feature: Yo como usuario quieron hacer Login en la pagina sahi para comprar libros

	
Scenario Outline: Logueo con usuario que contiene credenciales válidas
Given Que estoy en la interfaz de login del sitio web sahitest
When Ingrese las credenciales en Login <userName> and <Password>
And Verficar que la pagina desplegada sea "Books"

Examples:
	|userName|Password|
	|test	 |secret  |
	|test	 |secret |
	|test	 |secret |


