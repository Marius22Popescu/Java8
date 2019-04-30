package assignment2_1;

public class EmployeeTracker {
	public static void main(String[] args) {
		Organisation walmart = new Organisation("Walmart");
		Employee e1 = new Employee("John", "m", "manager", "Walmart", 38);
		Employee e2 = new Employee("Diana", "f", "contabil", "Walmart", 32);
		Employee e3 = new Employee("Derek", "m", "softwarer", "Walmart", 28);
		Employee e4 = new Employee("George", "m", "software", "Walmart", 24);
		Employee e5 = new Employee("John", "m", "manager", "Walmart", 38);
		
		walmart.addEmployee(new Employee("John", "m", "manager", "Walmart", 38));
		walmart.addEmployee(e1);
		walmart.addEmployee(e2);
		walmart.addEmployee(e3);
		walmart.addEmployee(e4);
		walmart.addEmployee(e5);
		
		Organisation target = new Organisation("Target");
		Employee e6 = new Employee("Alex", "m", "manager", "Targrt", 38);
		Employee e7 = new Employee("Maria", "f", "contabil", "Target", 28);
		Employee e8 = new Employee("Jack", "m", "software", "Target", 37);
		Employee e9 = new Employee("Lorena", "m", "software", "Target", 28);
		Employee e10 = new Employee("John", "m", "software", "Target", 22);
		
		target.addEmployee(e6);
		target.addEmployee(e7);
		target.addEmployee(e8);
		target.addEmployee(e9);
		target.addEmployee(e10);
		
		System.out.println(isTheSameOrganization(walmart, target));
		System.out.println(isTheSameEmployee(e1, e2));
		System.out.println(isTheSameEmployee(e1, e5));
		
	}
	public static boolean isTheSameOrganization (Organisation o1, Organisation o2) {
		return o1.getName() == o2.getName();
	}
	public static boolean isTheSameEmployee(Employee a, Employee b) {
		return a.getAge()==b.getAge() && a.getJobTitle() == b.getJobTitle() && a.getName() == b.getName() && a.getOrganization() == b.getOrganization() && 
				a.getSex()==b.getSex();
	}
}
