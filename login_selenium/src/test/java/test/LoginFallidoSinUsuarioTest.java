package test;

import org.testng.Assert;
import org.testng.annotations.Test;

import common.BaseClass;
import common.Utiles;
import page.LoginPage;

public class LoginFallidoSinUsuarioTest extends BaseClass{
  @Test
  public void loginFallido() throws InterruptedException {
	  
	  Utiles utiles = new Utiles(driver);
	  utiles.abrirNavegador(urlBase);
		
		
		LoginPage login = new LoginPage(driver);
		login.hacerLogin("", "secret");
		
		Assert.assertEquals("Invalid username or password", login.getmsjError());
  }
}
