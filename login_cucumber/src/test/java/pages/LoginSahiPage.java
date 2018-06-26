package pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class LoginSahiPage {
	

	private  WebDriver driver;
	
//	public LoginSahiPage(WebDriver driver) {
//		
//		this.driver=driver;
//		PageFactory.initElements(driver, this);		
//		
//	}
	
	/**********************************************************
	 ********Se declaran los elementos del DOM**********
	**********************************************************/
	
	private @FindBy(name="user") WebElement txtUser;
	
	private @FindBy(name="password") WebElement txtPassword;
	
	private @FindBy(className="button") WebElement btnLogin;
	
	private @FindBy(id="errorMessage") WebElement msjError;
	
	
	/** Método que ingresa datos en el campo user
	 * 
	 */
	
	public void setUser(String user){
		
		try {
			
			txtUser.clear();
			txtUser.sendKeys(user);
			
		} catch (NoSuchElementException e) {
			
			System.err.println("Se presentó un error ingresando datos en el login: "+e);
			// TODO: handle exception
		}
		
	}
	
	/**
	 * Método que ingresa datos en el campo password
	 * 
	 */
	public void setPassword(String password){
		
		try {
			
			highlightElement(txtPassword);
		//	Thread.sleep(5000);
			
			txtPassword.clear();
			txtPassword.sendKeys(password);
			
		} catch (NoSuchElementException e) {
			
			System.err.println("Se presentó un error ingresando datos en el login: "+e);
			// TODO: handle exception
		}
			//catch (InterruptedException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		
	}
	
	/**
	 * Método que hace clic en el botón aceptar
	 * 
	 */
	
	public void clicAceptar(){
		
		try {
			
			
			btnLogin.click();
			
		} catch (NoSuchElementException e) {
			
			System.err.println("Se presentó un error ingresando datos en el login: "+e);
			// TODO: handle exception
		}
		
	}
	
	/**
	 * @author cristian.mira
	 * 
	 * Método que retorna el valor
	 * contenido dentro del texto del WebElement msjError
	 * @return msjError.getText()
	 */
	
	

	public String getmsjError(){
		
		WebDriverWait wait = new WebDriverWait(driver, 5);
		wait.until(ExpectedConditions.visibilityOf(msjError));
		return msjError.getText();
	}
	
	
	/**
	 * Método que ejecuta la acción de login
	 * 
	 * @param user: usuario para realizar login
	 * @param password: clave de usuario que realiza login
	 */
	public void hacerLogin(String user, String password){
		
		try {
			highlightElement(txtUser);
			Thread.sleep(5000);
			setUser(user);
			Thread.sleep(5000);
			highlightElement(txtPassword);
			setPassword(password);
			clicAceptar();
			
		} catch (NoSuchElementException e) {
			
			System.err.println("Se presentó un error en la clase "+LoginSahiPage.class+": "+e);
			
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void abrirNavegador(){
		
		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
		
		ChromeOptions options = new ChromeOptions();
		//options.addArguments("--headless");
		//iniciar la pg maximizada
		options.addArguments("start-maximized");
		//Se deshabilita la barra info
		options.addArguments("disable-infobars");
		driver = new ChromeDriver(options);
//		driver = new ChromeDriver();
		//driver.manage().window().maximize();
		
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
//		this.driver=driver;
		PageFactory.initElements(driver,this);	
		driver.get("http://sahitest.com/demo/training/login.htm");
		
	}
	
	public String getTituloPaginaActual(){
		
		try {
			WebDriverWait wait = new WebDriverWait(driver, 20);
			wait.until(ExpectedConditions.urlContains("http://sahitest.com/demo/training/"));
			String tituloPagina = driver.getTitle();
			return tituloPagina;
		} catch (NoSuchElementException e) {
			
			System.err.println("Se presentó un error obteniendo el titulo");

			return null;
		}
		
		
	}
	
	public void cerrarNavegador(){
		
		driver.quit();
	}
	
	public  void highlightElement(WebElement element) {
		
            JavascriptExecutor js = ((JavascriptExecutor)driver);
//            js.executeScript("arguments[0].setAttribute('style', arguments[1]);", element, "color: yellow; border: 2px solid yellow;");
            js.executeScript("arguments[0].style.border='3px solid red'", element);
        }

}
