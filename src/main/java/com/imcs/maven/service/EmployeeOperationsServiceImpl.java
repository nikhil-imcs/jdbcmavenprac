package com.imcs.maven.service;

import java.sql.SQLException;
import java.util.List;

import com.imcs.maven.dao.EmployeeDAO;
import com.imcs.maven.dao.EmployeeDAOImpl;
import com.imcs.maven.entity.Employee;
import com.imcs.maven.exceptions.EmployeeNotFoundException;
import com.imcs.maven.exceptions.InvalidSalaryException;

public class EmployeeOperationsServiceImpl implements EmployeeOperationsService {

	private EmployeeDAO empDao = new EmployeeDAOImpl();

	public List<Employee> getEmployees() throws SQLException {
		List<Employee> employees = empDao.getEmployees();
		return employees;
	}

	public Employee getEmployee(int id) throws EmployeeNotFoundException, SQLException {
		Employee e = empDao.getEmployee(id);
		return e;
	}

	public boolean addEmployee(Employee e) throws InvalidSalaryException, SQLException {
		double salary = e.getSalary();
		if (salary < 5000) {
			throw new InvalidSalaryException("Employee Salary Should be greater than 5000");
		} else {
			boolean status = empDao.addEmployee(e);
			return status;
		}

	}

	public boolean updateEmployee(Employee e) throws InvalidSalaryException, SQLException {
		double salary = e.getSalary();
		if (salary < 5000) {
			throw new InvalidSalaryException("Employee Salary Should be greater than 5000");
		} else {
			boolean status = empDao.updateEmployee(e);
			return status;
		}
	}

	public boolean deleteEmployee(int id) throws EmployeeNotFoundException, SQLException {
		boolean status = empDao.deleteEmployee(id);
		return status;
	}

	public List<Employee> sortById() throws SQLException {
		List<Employee> sortedEmps = empDao.sortById();
		return sortedEmps;
	}

	public List<Employee> sortByDeptId() throws SQLException {
		List<Employee> sortedEmps = empDao.sortByDeptId();
		return sortedEmps;
	}

	public List<Employee> sortBySalary() throws SQLException {
		List<Employee> sortedEmps = empDao.sortBySalary();
		return sortedEmps;
	}

	public List<Employee> getHighSalaryEmployees(double salary) throws SQLException {
		List<Employee> highSalariedEmps=empDao.getHighSalaryEmployees(salary);
		return highSalariedEmps;
	}

}
