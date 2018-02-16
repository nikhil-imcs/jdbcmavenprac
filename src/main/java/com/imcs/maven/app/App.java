package com.imcs.maven.app;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.imcs.maven.entity.Employee;
import com.imcs.maven.exceptions.EmployeeNotFoundException;
import com.imcs.maven.exceptions.InvalidSalaryException;
import com.imcs.maven.service.EmployeeOperationsService;
import com.imcs.maven.service.EmployeeOperationsServiceImpl;

public class App {

	EmployeeOperationsService empOp = new EmployeeOperationsServiceImpl();
	private static Scanner sc = new Scanner(System.in);
	private static int choice;

	public static void getMenu() {
		System.out.println("Welcome to Employee Management System Application");
		System.out.println("--------------------------------------------------------------------");
		System.out.println("Enter 1: To Add an Employee");
		System.out.println("Enter 2: To Update Existing Employee");
		System.out.println("Enter 3: To Get Employee Details");
		System.out.println("Enter 4: To Get All Employee Details");
		System.out.println("Enter 5: To Delete an Existing Employee");
		System.out.println("Enter 6: To Get Menu");
		System.out.println("Enter 7: To Sort By Salary ");
		System.out.println("Enter 8: To Sort By Department");
		System.out.println("Enter 9: To Sort By Id ");
		System.out.println("Enter 10: To Get Higher Salaried Employees compared to Your Given Salary");
		System.out.println("Enter 0: To Exit this Application");
		System.out.println("--------------------------------------------------------------------");
		System.out.println("Please Enter your choice:");
	}

	public void getEmployees() {
		List<Employee> emps = new ArrayList<>();
		try {
			emps = empOp.getEmployees();
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		for (Employee e : emps) {
			System.out.println(e);
		}
	}

	public void getEmployee() {
		System.out.println("Enter Employee Id: Example -> 1");
		int id = sc.nextInt();
		try {
			Employee e = empOp.getEmployee(id);
			System.out.println(e);
		} catch (EmployeeNotFoundException exp1) {
			System.out.println(exp1.getMessage());
		} catch (SQLException exp2) {
			exp2.printStackTrace();
		}

	}

	public void addEmployee() {
		Employee e = new Employee();
		System.out.println("Please Enter Employee Id: Example ->100");
		int id = sc.nextInt();
		e.setId(id);
		System.out.println("Please Enter First name of the Employee: Example ->Nikhil");
		String firstName = sc.next();
		e.setFirstName(firstName);
		System.out.println("Please Enter Last name of the Employee: Example ->Shende");
		String lastName = sc.next();
		e.setLastName(lastName);
		System.out.println("Please Enter Employee Salary: Example -> 60000");
		double salary = sc.nextDouble();
		e.setSalary(salary);
		System.out.println("Please Enter Employee Age: Example -> 45");
		int age = sc.nextInt();
		e.setAge(age);
		System.out.println("Please Enter Employee Dept No: Example -> 10");
		int deptNo = sc.nextInt();
		e.setDeptNo(deptNo);
		try {
			empOp.addEmployee(e);
			System.out.println("Employee Added Successfully");
		} catch (InvalidSalaryException e1) {
			System.out.println(e1.getMessage());
		} catch (SQLException e1) {
			e1.printStackTrace();
		}

	}

	public void updateEmployee() {
		System.out.println("Please Enter Employee Id: Example ->100");
		int id = sc.nextInt();
		Employee e;
		try {
			e = empOp.getEmployee(id);
			System.out.println("Please Enter First name of the Employee: Example ->Nikhil");
			String firstName = sc.next();
			e.setFirstName(firstName);
			System.out.println("Please Enter Last name of the Employee: Example ->Shende");
			String lastName = sc.next();
			e.setLastName(lastName);
			System.out.println("Please Enter Employee Salary: Example -> 60000");
			double salary = sc.nextDouble();
			e.setSalary(salary);
			System.out.println("Please Enter Employee Age: Example -> 45");
			int age = sc.nextInt();
			e.setAge(age);
			System.out.println("Please Enter Employee Dept No: Example -> 10");
			int deptNo = sc.nextInt();
			e.setDeptNo(deptNo);
			empOp.updateEmployee(e);
			System.out.println("Employee Updated Successfully");
		} catch (EmployeeNotFoundException e1) {
			System.out.println(e1.getMessage());
		} catch (SQLException e1) {
			e1.printStackTrace();
		} catch (InvalidSalaryException e1) {
			System.out.println(e1.getMessage());
		}
	}

	public void deleteEmployee() {
		System.out.println("Please Enter Existing Employee Id to Delete the Employee: Example -> 100");
		int id = sc.nextInt();
		try {
			empOp.deleteEmployee(id);
			System.out.println("Employee Deleted Successfully");
		} catch (EmployeeNotFoundException e) {
			System.out.println(e.getMessage());
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	public void sortById() {
		System.out.println("Sorting Employees By Id...");
		List<Employee> emps;
		try {
			emps = empOp.sortById();
			for (Employee e : emps) {
				System.out.println(e);
			}
		} catch (SQLException e1) {
			e1.printStackTrace();
		}

	}

	public void sortByDeptNo() {
		System.out.println("Sorting Employees By Dept Id...");
		List<Employee> emps;
		try {
			emps = empOp.sortByDeptId();
			for (Employee e : emps) {
				System.out.println(e);
			}
		} catch (SQLException e1) {
			e1.printStackTrace();
		}

	}

	public void sortBySalary() {
		System.out.println("Sorting Employees By Salary...");
		List<Employee> emps;
		try {
			emps = empOp.sortBySalary();
			for (Employee e : emps) {
				System.out.println(e);
			}
		} catch (SQLException e1) {
			e1.printStackTrace();
		}

	}

	public void getHighSalaryEmps() {
		System.out.println("Please Enter Salary: Example -> 60000");
		double salary = sc.nextDouble();
		List<Employee> highSalariedEmps;
		try {
			highSalariedEmps = empOp.getHighSalaryEmployees(salary);
			for (Employee e : highSalariedEmps) {
				System.out.println(e);
			}
		} catch (SQLException e1) {
			e1.printStackTrace();
		}

	}

	public static void main(String[] args) throws SQLException {
		App app = new App();

		do {
			App.getMenu();
			choice = sc.nextInt();
			switch (choice) {
			case 0:
				System.out.println("Thank you for using this Application ");
				System.exit(0);
				break;
			case 1:
				app.addEmployee();
				break;
			case 2:
				app.updateEmployee();
				break;
			case 3:
				app.getEmployee();
				break;
			case 4:
				app.getEmployees();
				break;
			case 5:
				app.deleteEmployee();
				break;
			case 6:
				App.getMenu();
				break;
			case 7:
				app.sortBySalary();
				break;
			case 8:
				app.sortByDeptNo();
				break;
			case 9:
				app.sortById();
				break;
			case 10:
				app.getHighSalaryEmps();
				break;

			}
		} while (choice != 0);

	}

}
