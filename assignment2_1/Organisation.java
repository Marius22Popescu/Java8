package assignment2_1;

import java.util.ArrayList;

public class Organisation {
	
	private String name;
	private int nrEmployees;
	private ArrayList<Employee> employeeDB;
	
	public Organisation(String name) {
		super();
		this.name = name;
		employeeDB = new ArrayList<Employee>();
		nrEmployees++;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getNrEmployees() {
		return nrEmployees;
	}
	public void setNrEmployees(int nrEmployees) {
		this.nrEmployees = nrEmployees;
	}
	public ArrayList<Employee> getEmployee() {
		return employeeDB;
	}
	public void setEmployee(ArrayList<Employee> employee) {
		this.employeeDB = employee;
	}
	public void addEmployee(Employee e) {
		employeeDB.add(e);
	}
}
