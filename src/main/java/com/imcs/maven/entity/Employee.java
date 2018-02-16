package com.imcs.maven.entity;

import java.util.Comparator;
import java.util.List;

public class Employee implements Comparable<Employee> {
	private int id;
	private String firstName;
	private String lastName;
	private Gender gender;
	private Address address;
	private List<Employee> managedEmployees;
	private Employee manager;
	private EmploymentPeriod employmentPeriod;
	private List<PhoneNumber> phoneNumbers;
	private List<String> responsibilities;
	private double salary;
	private long version;
	private int age;
	private int deptNo;

	public Employee() {

	}


	public Employee(int id, String firstName, String lastName, Gender gender, Address address,
			List<Employee> managedEmployees, Employee manager, EmploymentPeriod employmentPeriod,
			List<PhoneNumber> phoneNumbers, List<String> responsibilities, double salary, long version, int age,
			int deptNo) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.gender = gender;
		this.address = address;
		this.managedEmployees = managedEmployees;
		this.manager = manager;
		this.employmentPeriod = employmentPeriod;
		this.phoneNumbers = phoneNumbers;
		this.responsibilities = responsibilities;
		this.salary = salary;
		this.version = version;
		this.age = age;
		this.deptNo = deptNo;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Gender getGender() {
		return gender;
	}

	public void setGender(Gender gender) {
		this.gender = gender;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public List<Employee> getManagedEmployees() {
		return managedEmployees;
	}

	public void setManagedEmployees(List<Employee> managedEmployees) {
		this.managedEmployees = managedEmployees;
	}

	public Employee getManager() {
		return manager;
	}

	public void setManager(Employee manager) {
		this.manager = manager;
	}

	public EmploymentPeriod getEmploymentPeriod() {
		return employmentPeriod;
	}

	public void setEmploymentPeriod(EmploymentPeriod employmentPeriod) {
		this.employmentPeriod = employmentPeriod;
	}

	public List<PhoneNumber> getPhoneNumbers() {
		return phoneNumbers;
	}

	public void setPhoneNumbers(List<PhoneNumber> phoneNumbers) {
		this.phoneNumbers = phoneNumbers;
	}

	public List<String> getResponsibilities() {
		return responsibilities;
	}

	public void setResponsibilities(List<String> responsibilities) {
		this.responsibilities = responsibilities;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	public long getVersion() {
		return version;
	}

	public void setVersion(long version) {
		this.version = version;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}
	
	

	public int getDeptNo() {
		return deptNo;
	}


	public void setDeptNo(int deptNo) {
		this.deptNo = deptNo;
	}




	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Employee [id=");
		builder.append(id);
		builder.append(", firstName=");
		builder.append(firstName);
		builder.append(", lastName=");
		builder.append(lastName);
		builder.append(", salary=");
		builder.append(salary);
		builder.append(", age=");
		builder.append(age);
		builder.append(", deptNo=");
		builder.append(deptNo);
		builder.append("]");
		return builder.toString();
	}


	@Override
	public int compareTo(Employee o) {
		final int BEFORE = -1;
		final int AFTER = 1;
		final int EQUAL = 0;

		// first compare by name
		if (firstName.compareTo(o.firstName) > 0)
			return AFTER;
		if (firstName.compareTo(o.firstName) < 0)
			return BEFORE;

		// then compare by salary
		if (salary > o.salary)
			return AFTER;
		if (salary < o.salary)
			return BEFORE;

		return EQUAL;

	}

	public static class EmployeeSalaryComparator implements Comparator<Employee> {

		@Override
		public int compare(Employee o1, Employee o2) {
			final int BEFORE = -1;
			final int AFTER = 1;
			final int EQUAL = 0;

			// high salary first
			if (o1.salary > o2.salary)
				return BEFORE;
			if (o1.salary < o2.salary)
				return AFTER;

			return EQUAL;
		}

	}
	
	public static class EmployeeDepartmentComparator implements Comparator<Employee> {

		@Override
		public int compare(Employee o1, Employee o2) {
			final int BEFORE = -1;
			final int AFTER = 1;
			final int EQUAL = 0;

			// high deptNo first
			if (o1.deptNo > o2.deptNo)
				return BEFORE;
			if (o1.deptNo < o2.deptNo)
				return AFTER;

			return EQUAL;
		}

	}
	
	

}
