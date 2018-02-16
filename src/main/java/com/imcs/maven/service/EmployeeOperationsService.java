package com.imcs.maven.service;

import java.sql.SQLException;
import java.util.List;

import com.imcs.maven.entity.Employee;
import com.imcs.maven.exceptions.EmployeeNotFoundException;
import com.imcs.maven.exceptions.InvalidSalaryException;

public interface EmployeeOperationsService {

	List<Employee> getEmployees() throws SQLException;

	Employee getEmployee(int id) throws EmployeeNotFoundException, SQLException;

	boolean addEmployee(Employee e) throws InvalidSalaryException, SQLException;

	boolean updateEmployee(Employee e) throws InvalidSalaryException, SQLException;

	boolean deleteEmployee(int id) throws EmployeeNotFoundException, SQLException;

	List<Employee> sortById() throws SQLException;

	List<Employee> sortByDeptId() throws SQLException;

	List<Employee> sortBySalary() throws SQLException;

	List<Employee> getHighSalaryEmployees(double salary) throws SQLException;

}
