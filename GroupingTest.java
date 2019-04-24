package day0415;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

class Student{
	private String name;
	private int age;
	private String dept;
	
	@Override
	public String toString() {
		return "Student [name=" + name + ", age=" + age + ", dept=" + dept + "]";
	}
	public String getDept() {
		return dept;
	}
	public void setDept(String dept) {
		this.dept = dept;
	}
	public Student(String name, String dept, int age) {
		super();
		this.name = name;
		this.age = age;
		this.dept = dept;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	

}
public class GroupingTest {
	public static void main(String[] args) {
		Student s1 = new Student("Marius", "Development", 30);
		Student s2 = new Student("David", "DBA", 35);
		Student s3 = new Student("Emre", "Maintanance", 25);
		Student s4 = new Student("Amar", "Sys Admin", 27);
		Student s5 = new Student("Akku", "Development", 30);
		Student s6 = new Student("David", "DBA", 35);
		Student s7 = new Student("Saran", "Maintanance", 25);
		Student s8 = new Student("Umair", "Sys Admin", 27);
	
		List<Student> list = Arrays.asList(s1, s2, s3, s4, s5, s6, s7, s8);
	
		//Group student on the basis of departament
		System.out.println("group students on the basis of Department");
		Map<String, List<Student>> studentByDept = list.parallelStream().collect(Collectors.groupingBy(Student::getDept));
		//	System.out.println(studentByDept);	
		
		//Group student on the basis of departament
		studentByDept.forEach((k,v) ->System.out.println(" Key "+k+ " "+v.stream().map(m->m.getName()).collect(Collectors.joining(","))));
		
		//Group student on the basis of age
		System.out.println("group students on the basis of Department");
		Map<Integer, List<Student>> studentByAge = list.stream().collect(Collectors.groupingBy(Student::getAge));
		studentByAge.forEach((k,v) ->System.out.println(" Key "+k+ " "+v.stream().map(m->m.getName()).collect(Collectors.joining(","))));
		
		System.out.println(studentByAge);
	}
}
