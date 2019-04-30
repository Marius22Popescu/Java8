package assignment2_1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class EmployeeTrackerWithJava8 {
	public static void main(String[] args) {
		List<Employee> employees = Arrays.asList(new Employee("John", "m", "manager", "Walmart", 38), 
				new Employee("Diana", "f", "contabil", "Walmart", 32), new Employee("Derek", "m", "softwarer", "Walmart", 28),
				new Employee("George", "m", "software", "Target", 24), new Employee("John", "m", "manager", "Walmart", 38));
		
		List<Employee> employee1 = employees.stream().filter(p ->p.getName().equals("John")).collect(Collectors.toList());
		List<Employee> employee2 = employees.stream().filter(p ->p.getName().equals("Derek")).collect(Collectors.toList());		
		List<Employee> employee3 = employees.stream().filter(p ->p.getName().equals("John")).collect(Collectors.toList());
		
		//Display if two employee are the same person
		isTheSame(employee1, employee2);
		isTheSame(employee1, employee3);
			
		//Filter the employees by organization
		List<Employee> organization1 = employees.stream().filter(p ->p.getOrganization().equals("Walmart")).collect(Collectors.toList());
		List<Employee> organization2 = employees.stream().filter(p ->p.getOrganization().equals("Target")).collect(Collectors.toList());
		
		//Display if is the same organization
		isTheSame(organization1, organization2);
	}	
	//The method will display if two entities are the same
	static void isTheSame(List<Employee> x, List<Employee> y) {
		if (x.equals(y)) System.out.println("Are the same");
		else System.out.println("Are different");
	}

}
