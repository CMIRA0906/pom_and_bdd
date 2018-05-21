package test;

import org.testng.Assert;
import org.testng.annotations.Test;

import common.BaseClass;
import common.Utiles;
import page.LoginPage;

public class LoginExitosoTest extends BaseClass{
	
	
	@Test
	public void loginExitoso() throws InterruptedException {
		
		Utiles utiles = new Utiles(driver);
		utiles.abrirNavegador(urlBase);
		
		LoginPage login = new LoginPage(driver);
		login.hacerLogin("test", "secret");
		
		//redireccione a la url http://sahitest.com/demo/training/books.htm
		Assert.assertEquals("http://sahitest.com/demo/training/books.htm", driver.getCurrentUrl());
		Thread.sleep(5000);
  }
}
