
package com.ems.userInterface;

import java.io.IOException;
import java.util.LinkedHashSet;
import java.util.Scanner;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.ems.controller.AppController;
import com.ems.employee.Employee;

public class UserInterface {

	public UserInterface() throws IOException {
		acceptData();
	}

	ApplicationContext context = new ClassPathXmlApplicationContext("contextproperty.xml");

	AppController appControl = (AppController) context.getBean("controller");
	
	Scanner src = new Scanner(System.in);

	public void acceptData() throws IOException {
		Employee employee = new Employee();
		
		System.out.println("Enter number of users");
		int n =src.nextInt();
		
		for (int i = 0; i < n; i++) {
			System.out.println("Enter the name, id and salary of the employee");
			employee = new Employee(src.next(), src.nextInt(), src.nextInt());
			appControl.addEmployee(employee);
		}

		displayData();
		
		System.out.println(" ");
		
		System.out.println("#################################################################################");

		System.out.println("Enter the EmployID of the employee to be deleted");
		appControl.deleteEmployee(src.nextInt());

		System.out.println("After deletion the list of employees is given below");
		
		displayData();
		
		System.out.println(" ");
		
		System.out.println("#################################################################################");

		System.out.println("Enter the EmployID of the employee to be Searched");
		appControl.getEmployeeByID(src.nextInt());

	}

	public void displayData() {
		System.out.println("All the employees are listed below: ");
		appControl.viewALlEmployee();

		LinkedHashSet<Employee> set = new LinkedHashSet<>();

		set.stream().forEach(System.out::println);
	}


}
