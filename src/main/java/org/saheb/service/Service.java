package org.saheb.service;

import java.util.ArrayList;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.saheb.beans.Employee;
import org.saheb.beans.Employees;

@Path("/employees")
public class Service {
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Employees getAllEmployees() {
		Employees employeeListList = new Employees();
		employeeListList.setEmployeeList(new ArrayList<Employee>());

		employeeListList.getEmployeeList().add(new Employee(1, "Lokesh Gupta"));
		employeeListList.getEmployeeList().add(new Employee(2, "Alex Kolenchiskey"));
		employeeListList.getEmployeeList().add(new Employee(3, "David Kameron"));

		return employeeListList;
	}

	@GET
	@Path("{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Employee getAllEmployees(@PathParam("id") String id) {
		return new Employee(3, "David Kameron");
	}
}
