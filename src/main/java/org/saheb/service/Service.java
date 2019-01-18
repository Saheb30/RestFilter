package org.saheb.service;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.saheb.beans.Employee;

@Path("/employees")
public class Service {
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Employee> getAllEmployees() {
		List<Employee> list = new ArrayList<>();
		System.out.println("inside");
		list.add(new Employee(1, "Lokesh Gupta"));
		list.add(new Employee(2, "Alex Kolenchiskey"));
		list.add(new Employee(3, "David Kameron"));
		return list;
	}
}
