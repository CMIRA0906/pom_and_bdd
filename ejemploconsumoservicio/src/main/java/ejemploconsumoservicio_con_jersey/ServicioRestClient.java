package ejemploconsumoservicio_con_jersey;

import org.codehaus.jettison.json.JSONObject;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.config.ClientConfig;
import com.sun.jersey.api.client.config.DefaultClientConfig;
import com.sun.jersey.api.json.JSONConfiguration;

public class ServicioRestClient {
	
	public static void main(String[] args) {
		
		consumirServicioRest();
	
	}
	
	public static void consumirServicioRest(){

		try {
			
			ClientConfig clientConfig = new DefaultClientConfig();
			clientConfig.getFeatures().put(JSONConfiguration.FEATURE_POJO_MAPPING, Boolean.TRUE);
			Client client = Client.create(clientConfig);
			
			WebResource webresource = client.
					resource("https://gturnquist-quoters.cfapps.io/api/random");
			
			
			ClientResponse response = webresource.accept("application/json").type("application/json").
					get(ClientResponse.class);
			
			
			JSONObject respuesta = response.getEntity(JSONObject.class);
			System.out.println(respuesta.get("type"));
			System.out.println(respuesta.get("value"));
			System.out.println(respuesta.getJSONObject("value").get("id"));
			
			System.err.println(response.getLength());
			       
			
			System.out.println("la respuesta del servicio es: "+respuesta.toString());
			
		} catch (Exception e) {
			
			System.err.println("Error"+e);
		}
		
	}

}
