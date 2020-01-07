package org.saheb.client;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.glassfish.jersey.client.ClientConfig;
import org.glassfish.jersey.client.authentication.HttpAuthenticationFeature;
import org.glassfish.jersey.logging.LoggingFeature;
import org.glassfish.jersey.server.monitoring.ResponseStatistics;
import org.saheb.beans.Employee;
import org.saheb.beans.Employees;

public class JerseyClient
{
	public static void main(String[] args) throws IOException 
	{
		//System.out.println("");
		//httpGETCollectionExample();
		/*httpGETEntityExample();
		httpPOSTMethodExample();
		httpPUTMethodExample();
		httpDELETEMethodExample();*/
		ScheduledExecutorService service = Executors.newSingleThreadScheduledExecutor();
		service.scheduleAtFixedRate(runnable, 0, 5, TimeUnit.SECONDS);
	}
	
	private static void httpGETCollectionExample() 
	{
		/*HttpAuthenticationFeature feature = HttpAuthenticationFeature.basicBuilder()
																    .nonPreemptive()
																    .credentials("howtodoinjava", "password")
																    .build();

		ClientConfig clientConfig = new ClientConfig();
		clientConfig.register(feature) ;*/

		Client client = ClientBuilder.newClient();
		WebTarget webTarget = client.target("http://localhost:8080/services-status/rs").path("status");
		
		Invocation.Builder invocationBuilder =	webTarget.request(MediaType.APPLICATION_JSON);
		Response response = invocationBuilder.get();
		System.out.println(response);
		if(response.getStatus() == 200) {
			Employee employee = response.readEntity(Employee.class);
			System.out.println(employee.getName());
		}
		
	}
	
	private static void httpGETEntityExample() 
	{
		Client client = ClientBuilder.newClient( new ClientConfig().register( LoggingFeature.class ) );
		WebTarget webTarget = client.target("http://localhost:8080/JerseyDemos/rest").path("employees").path("1");
		
		Invocation.Builder invocationBuilder =	webTarget.request(MediaType.APPLICATION_XML);
		Response response = invocationBuilder.get();
		
		Employee employee = response.readEntity(Employee.class);
			
		System.out.println(response.getStatus());
		System.out.println(employee);
	}

	private static void httpPOSTMethodExample() 
	{
		Client client = ClientBuilder.newClient( new ClientConfig().register( LoggingFeature.class ) );
		WebTarget webTarget = client.target("http://localhost:8080/JerseyDemos/rest").path("employees");
		
		Employee emp = new Employee();
		emp.setId(1);
		emp.setName("David Feezor");
		
		Invocation.Builder invocationBuilder =	webTarget.request(MediaType.APPLICATION_XML);
		Response response = invocationBuilder.post(Entity.entity(emp, MediaType.APPLICATION_XML));
		
		System.out.println(response.getStatus());
		System.out.println(response.readEntity(String.class));
	}
	
	private static void httpPUTMethodExample() 
	{
		Client client = ClientBuilder.newClient( new ClientConfig().register( LoggingFeature.class ) );
		WebTarget webTarget = client.target("http://localhost:8080/JerseyDemos/rest").path("employees").path("1");
		
		Employee emp = new Employee();
		emp.setId(1);
		emp.setName("David Feezor");
		
		Invocation.Builder invocationBuilder =	webTarget.request(MediaType.APPLICATION_XML);
		Response response = invocationBuilder.put(Entity.entity(emp, MediaType.APPLICATION_XML));
		
		Employee employee = response.readEntity(Employee.class);
			
		System.out.println(response.getStatus());
		System.out.println(employee);
	}
	
	private static void httpDELETEMethodExample() 
	{
		Client client = ClientBuilder.newClient( new ClientConfig().register( LoggingFeature.class ) );
		WebTarget webTarget = client.target("http://localhost:8080/JerseyDemos/rest").path("employees").path("1");
		
		Invocation.Builder invocationBuilder =	webTarget.request();
		Response response = invocationBuilder.delete();
		
		System.out.println(response.getStatus());
		System.out.println(response.readEntity(String.class));
	}
}

