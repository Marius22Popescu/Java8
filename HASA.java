package day0416;

class Address{
	@Override
	public String toString() {
		return "Address [city=" + city + ", state=" + state + "]";
	}
	public Address(String city, String state) {
		super();
		this.city = city;
		this.state = state;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	private String city, state;
	
}
class Employee{
	@Override
	public String toString() {
		return "Employee [empId=" + empId + ", emplName=" + emplName + ", address=" + address + "]";
	}
	public Employee(int empId, String emplName, Address address) {
		super();
		this.empId = empId;
		this.emplName = emplName;
		this.address = address;
	}
	public int getEmpId() {
		return empId;
	}
	public void setEmpId(int empId) {
		this.empId = empId;
	}
	public String getEmplName() {
		return emplName;
	}
	public void setEmplName(String emplName) {
		this.emplName = emplName;
	}
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
	private int empId;
	private String emplName;
	//HAS A relationship
	private Address address;
}
public class HASA {
	public static void main(String[] args) {
		Address a1 = new Address("PIT", "PA");
		Address a2 = new Address("FLL", "FL");
		Address a3 = new Address("BethelPark", "PA");
		
		Employee e1 = new Employee(1001, "David", a1);
		Employee e2 = new Employee(1001, "Emre", a2);
		Employee e3 = new Employee(1001, "Akku", a3);
		
		System.out.println(e1);
		System.out.println(e2);
		System.out.println(e3);
	}

}
