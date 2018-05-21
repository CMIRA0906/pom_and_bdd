package prueba_junit;

import org.junit.Assert;
import org.junit.Test;

import operaciones.Suma;

public class SumaTest {
	
	
	@Test 
	public void sumaConCerosOK(){
		
		Suma operacion = new Suma();
		
			int resultado= operacion.suma(0, 1);
			Assert.assertEquals(1, resultado);
		
	}
	
	@Test 
	public void sumaNumeroGrande(){
		
		Suma operacion = new Suma();
		
			int resultado= operacion.suma(100000, 100000);
			Assert.assertEquals(200000, resultado);
		
	}
	
	@Test 
	public void sumaNumeroNegativo(){
		
		Suma operacion = new Suma();
		
			int resultado= operacion.suma(-100000, 100);
			Assert.assertEquals(-99900, resultado);
		
	}

}
