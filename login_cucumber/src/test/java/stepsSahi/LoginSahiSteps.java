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

public class LoginSahiSteps {

	LoginSahiPage login = new LoginSahiPage();
	

	@Given("^Que estoy en la interfaz de login del sitio web sahitest")
	public void abrir_navegador() throws Exception {

		login.abrirNavegador();
	}

	@When("^Ingrese las credenciales en Login ([^\"]*) and ([^\"]*)$")
	public void ingresarUsuario(String userName, String password) {

		login.setUser(userName);

		login.setPassword(password);
		login.clicAceptar();
	}


	@Then("^Verficar que la pagina desplegada sea \"([^\"]*)\"$")
	public void getPaginaDesgleda(String tituloPage) {

		System.out.println("Este es el titulo: " + tituloPage);

		Assert.assertEquals(tituloPage, login.getTituloPaginaActual());

	}

	@After
	public void cerrarNavegador(Scenario scenario) {

		System.out.println("Este es el escenario ejecutado" + scenario.getName());
		login.cerrarNavegador();

	}

}
