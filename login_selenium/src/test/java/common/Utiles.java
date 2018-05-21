package common;

import org.openqa.selenium.NotFoundException;
import org.openqa.selenium.WebDriver;

public class Utiles {
	
	public Utiles(WebDriver driver) {
		
		this.driver = driver;
		// TODO Auto-generated constructor stub
	}

	private  WebDriver driver;
	
	/**
	 * @author cristian.mira
	 * 
	 * Método que  abre la pagina web
	 */
	  public void abrirNavegador(String urlBase){
		  
		  try {
			  	
			  driver.get(urlBase);
			
		} catch (NotFoundException e) {
			
			System.err.println("No abrió el navegador: "+e);
		}
	  }
}
