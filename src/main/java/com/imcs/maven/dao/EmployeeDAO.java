package com.imcs.maven.dao;

import java.sql.SQLException;
import java.util.List;

import com.imcs.maven.entity.Employee;
import com.imcs.maven.exceptions.EmployeeNotFoundException;

public interface EmployeeDAO {

	List<Employee> getEmployees() throws SQLException;

	Employee getEmployee(int id) throws EmployeeNotFoundException, SQLException;

	boolean addEmployee(Employee e) throws SQLException;

	boolean updateEmployee(Employee e) throws SQLException;

	boolean deleteEmployee(int id) throws EmployeeNotFoundException, SQLException;

	List<Employee> sortById() throws SQLException;

	List<Employee> sortByDeptId();

	List<Employee> sortBySalary();

	List<Employee> getHighSalaryEmployees(double salary) throws SQLException;

}
