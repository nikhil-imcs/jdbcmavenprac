package com.imcs.maven.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;
import com.imcs.maven.entity.Employee;
import com.imcs.maven.exceptions.EmployeeNotFoundException;

public class EmployeeDAOImpl implements EmployeeDAO {

	private DBCPDataSourceFactory factory = new DBCPDataSourceFactory();
	private DataSource ds = factory.getDataSource();

	public List<Employee> getEmployees() throws SQLException {

		List<Employee> employees = new ArrayList<>();
		try (Connection con = ds.getConnection(); Statement stmt = con.createStatement();) {
			ResultSet rs = stmt.executeQuery("select id,first_name,last_name,age,salary,dept_no from employee");

			while (rs.next()) {
				Employee e = new Employee();
				e.setId(rs.getInt("id"));
				e.setFirstName(rs.getString("first_name"));
				e.setLastName(rs.getString("last_name"));
				e.setAge(rs.getInt("age"));
				e.setSalary(rs.getDouble("salary"));
				e.setDeptNo(rs.getInt("dept_no"));

				employees.add(e);
			}

		} catch (SQLException exp) {
			exp.printStackTrace();
		}

		return employees;
	}

	public Employee getEmployee(int id) throws EmployeeNotFoundException, SQLException {

		try (Connection con = ds.getConnection();
				PreparedStatement stmt = con.prepareStatement(
						"select id,first_name,last_name,age,salary,dept_no from employee where id= ?");) {
			stmt.setInt(1, id);
			ResultSet rs = stmt.executeQuery();
			if (rs.next()) {
				Employee e = new Employee();
				e.setId(rs.getInt("id"));
				e.setFirstName(rs.getString("first_name"));
				e.setLastName(rs.getString("last_name"));
				e.setAge(rs.getInt("age"));
				e.setSalary(rs.getDouble("salary"));
				e.setDeptNo(rs.getInt("dept_no"));
				return e;
			}

		} catch (SQLException exp) {
			exp.printStackTrace();
		}
		throw new EmployeeNotFoundException("Given id is Invalid. Please provide valid employee id");
	}

	public boolean addEmployee(Employee e) throws SQLException {
		int id = e.getId();
		String firstName = e.getFirstName();
		String lastName = e.getLastName();
		int age = e.getAge();
		double salary = e.getSalary();
		int deptNo = e.getDeptNo();
		Connection con = null;
		try {
			con = ds.getConnection();
			String sql = "insert into employee(id,first_name,last_name,age,salary,dept_no) values (?,?,?,?,?,?)";
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setInt(1, id);
			stmt.setString(2, firstName);
			stmt.setString(3, lastName);
			stmt.setInt(4, age);
			stmt.setDouble(5, salary);
			stmt.setInt(6, deptNo);
			stmt.executeUpdate();

		} catch (SQLException exp) {
			exp.printStackTrace();
			return false;
		} finally {
			con.close();
		}
		return true;
	}

	public boolean updateEmployee(Employee e) throws SQLException {
		int id = e.getId();
		String firstName = e.getFirstName();
		String lastName = e.getLastName();
		int age = e.getAge();
		double salary = e.getSalary();
		int deptNo = e.getDeptNo();
		Connection con = null;
		try {
			con = ds.getConnection();
			String sql = "update employee set first_name=?, last_name=?, age=?, salary=?, dept_no=? where id=?";
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setString(1, firstName);
			stmt.setString(2, lastName);
			stmt.setInt(3, age);
			stmt.setDouble(4, salary);
			stmt.setInt(5, deptNo);
			stmt.setInt(6, id);
			stmt.executeUpdate();

		} catch (SQLException exp) {
			exp.printStackTrace();
			return false;
		} finally {
			con.close();
		}
		return true;
	}

	public boolean deleteEmployee(int id) throws EmployeeNotFoundException, SQLException {
		@SuppressWarnings("unused")
		Employee e = getEmployee(id);
		Connection con = null;
		try {
			con = ds.getConnection();
			String sql = "delete from employee where id=?";
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setInt(1, id);
			stmt.executeUpdate();
		} catch (SQLException exp) {
			exp.printStackTrace();
			return false;
		} finally {
			con.close();
		}
		return true;
	}

	public List<Employee> sortById() throws SQLException {
		List<Employee> employees = new ArrayList<>();
		try (Connection con = ds.getConnection(); Statement stmt = con.createStatement();) {
			String sql = "select id,first_name,last_name,age,salary,dept_no from employee order by id";
			ResultSet rs = stmt.executeQuery(sql);
			while (rs.next()) {
				Employee e = new Employee();
				e.setId(rs.getInt("id"));
				e.setFirstName(rs.getString("first_name"));
				e.setLastName(rs.getString("last_name"));
				e.setAge(rs.getInt("age"));
				e.setSalary(rs.getDouble("salary"));
				e.setDeptNo(rs.getInt("dept_no"));

				employees.add(e);
			}
		} catch (SQLException exp) {
			exp.printStackTrace();
			return null;
		}
		return employees;
	}

	public List<Employee> sortByDeptId() {
		List<Employee> employees = new ArrayList<>();
		try (Connection con = ds.getConnection(); Statement stmt = con.createStatement();) {
			String sql = "select id,first_name,last_name,age,salary,dept_no from employee order by dept_no";
			ResultSet rs = stmt.executeQuery(sql);
			while (rs.next()) {
				Employee e = new Employee();
				e.setId(rs.getInt("id"));
				e.setFirstName(rs.getString("first_name"));
				e.setLastName(rs.getString("last_name"));
				e.setAge(rs.getInt("age"));
				e.setSalary(rs.getDouble("salary"));
				e.setDeptNo(rs.getInt("dept_no"));

				employees.add(e);
			}
		} catch (SQLException exp) {
			exp.printStackTrace();
			return null;
		}
		return employees;
	}

	public List<Employee> sortBySalary() {
		List<Employee> employees = new ArrayList<>();
		try (Connection con = ds.getConnection(); Statement stmt = con.createStatement();) {
			String sql = "select id,first_name,last_name,age,salary,dept_no from employee order by salary";
			ResultSet rs = stmt.executeQuery(sql);
			while (rs.next()) {
				Employee e = new Employee();
				e.setId(rs.getInt("id"));
				e.setFirstName(rs.getString("first_name"));
				e.setLastName(rs.getString("last_name"));
				e.setAge(rs.getInt("age"));
				e.setSalary(rs.getDouble("salary"));
				e.setDeptNo(rs.getInt("dept_no"));

				employees.add(e);
			}
		} catch (SQLException exp) {
			exp.printStackTrace();
			return null;
		}
		return employees;
	}

	public List<Employee> getHighSalaryEmployees(double salary) throws SQLException {
		Connection con = null;
		List<Employee> employees = new ArrayList<>();
		try {
			con = ds.getConnection();
			String sql = "select id,first_name,last_name,age,salary,dept_no from employee where salary > ?";
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setDouble(1, salary);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				Employee e = new Employee();
				e.setId(rs.getInt("id"));
				e.setFirstName(rs.getString("first_name"));
				e.setLastName(rs.getString("last_name"));
				e.setAge(rs.getInt("age"));
				e.setSalary(rs.getDouble("salary"));
				e.setDeptNo(rs.getInt("dept_no"));

				employees.add(e);
			}
		} catch (SQLException exp) {
			exp.printStackTrace();
			return null;
		} finally {
			con.close();
		}
		return employees;
	}

}
