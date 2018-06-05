package stepsSahi;



import org.junit.Assert;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pages.LoginSahiPage;

public class Steps_Def_Login_Sahi{
	
			
	LoginSahiPage login = new LoginSahiPage();
	
	@Before
	public void  abrir_navegadorBefore(){
		
		login.abrirNavegador();
	}
	
	@Given("^El navegador desplegado")
	public void abrir_navegador() throws Exception{
		
//		login.abrirNavegador();
		System.out.println("Ya no hago nada");
	}
	//formato antiguo
	//@When("^Yo ingrese las credenciales \"([^\"]*)\" and \"([^\"]*)\"$")
	//@When("^Yo ingrese las credencialesen Loqin")
	@When("^Yo ingrese las credenciales en Login ([^\"]*) and ([^\"]*)$")
	public void ingresarUsuario(String userName, String password){
		
	//	List<List<String>> datos = table.raw();
		//System.out.println(datos.get(1).get(1));
		
		login.setUser(userName);
		
		login.setPassword(password);
	}
	
	@And("^De clic en el boton Aceptar")
	public void clicAceptar(){
		
		login.clicAceptar();
		
	}
	
	@Then("^Verficar que la pagina desplegada sea \"([^\"]*)\"$")
	public void getPaginaDesgleda(String tituloPage){
	
			Assert.assertEquals(tituloPage, login.getTituloPaginaActual());
		
		System.out.println("Este es el titulo: "+tituloPage);
		
		
		
		
	}
	
	@After
	public void cerrarNavegador(Scenario scenario){
		
		System.out.println("Este es el escenario "+scenario.getName());
		login.cerrarNavegador();
		
	}
	
	

}
