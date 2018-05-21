package stepsSahi;


import org.junit.Assert;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pages.LoginSahiPage;

public class Steps_Def_Login_Sahi{
	
			
	LoginSahiPage login = new LoginSahiPage();
	
	@Given("^El navegador desplegado")
	public void abrir_navegador() throws Exception{
		
		login.abrirNavegador();
	}
	@When("^Yo ingrese las credenciales \"([^\"]*)\" and \"([^\"]*)\"$")
	public void ingresarUsuario(String usuario, String clave){
		
		login.setUser(usuario);
		login.setPassword(clave);
	}
	
	@And("^De clic en el boton Aceptar")
	public void clicAceptar(){
		
		login.clicAceptar();
		
	}
	
	@Then("^Verficar que la pagina desplegada sea \"([^\"]*)\"$")
	public void getPaginaDesgleda(String tituloPage){
	
			Assert.assertEquals(tituloPage, login.getTituloPaginaActual());
		
		System.out.println("Este es el titulo: "+tituloPage);
		
		login.cerrarNavegador();
		
		
	}
	
	

}
