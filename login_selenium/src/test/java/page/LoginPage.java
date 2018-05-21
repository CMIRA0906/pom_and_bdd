package page;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class LoginPage {
	
	private WebDriver driver;
	
	public LoginPage(WebDriver driver) {
		
		this.driver=driver;
		PageFactory.initElements(driver, this);		
		
	}
	
	/**********************************************************
	 ********Se declaran los elementos del DOM**********
	**********************************************************/
	
	private @FindBy(name="user") WebElement txtUser;
	
	private @FindBy(name="password") WebElement txtPassword;
	
	private @FindBy(className="button") WebElement btnLogin;
	
	private @FindBy(id="errorMessage") WebElement msjError;
	
	
	/** M�todo que ingresa datos en el campo user
	 * 
	 */
	
	public void setUser(String user){
		
		try {
			
			txtUser.clear();
			txtUser.sendKeys(user);
			
		} catch (NoSuchElementException e) {
			
			System.err.println("Se present� un error ingresando datos en el login: "+e);
			// TODO: handle exception
		}
		
	}
	
	/**
	 * M�todo que ingresa datos en el campo password
	 * 
	 */
	public void setPassword(String password){
		
		try {
			
			txtPassword.clear();
			txtPassword.sendKeys(password);
			
		} catch (NoSuchElementException e) {
			
			System.err.println("Se present� un error ingresando datos en el login: "+e);
			// TODO: handle exception
		}
		
	}
	
	/**
	 * M�todo que hace clic en el bot�n aceptar
	 * 
	 */
	
	public void clicAceptar(){
		
		try {
			
			
			btnLogin.click();
			
		} catch (NoSuchElementException e) {
			
			System.err.println("Se present� un error ingresando datos en el login: "+e);
			// TODO: handle exception
		}
		
	}
	
	/**
	 * @author cristian.mira
	 * 
	 * M�todo que retorna el valor
	 * contenido dentro del texto del WebElement msjError
	 * @return msjError.getText()
	 */
	
	

	public String getmsjError(){
		
		WebDriverWait wait = new WebDriverWait(driver, 5);
		wait.until(ExpectedConditions.visibilityOf(msjError));
		return msjError.getText();
	}
	
	
	/**
	 * M�todo que ejecuta la acci�n de login
	 * 
	 * @param user: usuario para realizar login
	 * @param password: clave de usuario que realiza login
	 */
	public void hacerLogin(String user, String password){
		
		try {
			
			setUser(user);
			setPassword(password);
			clicAceptar();
			
		} catch (NoSuchElementException e) {
			
			System.err.println("Se present� un error en la clase "+LoginPage.class+": "+e);
			
		}
	}
	

}
