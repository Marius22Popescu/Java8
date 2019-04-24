package day0415;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class EmpCollect {
	public static void main(String[] args) {
		List<Emp> list1 = new ArrayList<>();
		List<Emp> list2 = new ArrayList<>();
		Emp[] emp1 = new Emp[3];
		Emp[] emp2 = new Emp[3];
		{
			list1.add(new Emp(1001, "David"));
			list1.add(new Emp(1002, "Emre"));
			list1.add(new Emp (1003, "Amaar"));
			
			list2.add(new Emp (1001, "Davidr"));
			list2.add(new Emp (1002, "Emre"));
			list2.add(new Emp (1003, "Amaar"));
			
			emp1[0] = new Emp(1001, "David");
			emp1[1] = new Emp(1001, "Marius");
			emp1[2] = new Emp(1001, "Kashitij");
			emp2[0] = new Emp(1001, "David");
			emp2[1] = new Emp(1001, "Marius");
			emp2[2] = new Emp(1001, "Kashitij");
		}
		List<Emp> list=Stream.concat(list1.parallelStream(), list2.stream()).collect(Collectors.toList());
		list.forEach(b->System.out.println(b.getEmpId()+" "+b.getEmpName()));
		
		//Remove the duplicates
		System.out.println(".....");
		list=Stream.concat(list.parallelStream(), list2.stream()).distinct().collect(Collectors.toList());
		list.forEach(b->System.out.println(b.getEmpId()+" "+b.getEmpName()));
		
		
		System.out.println(".....");
		Emp[] emps=(Emp[])Stream.concat(Stream.of(emp1),Stream.of(emp2)).toArray(b->new Emp[b]);
		for(Emp b:emps) {
			System.out.println(b.getEmpId()+" "+b.getEmpName());
		}
		
		//Remove the duplicates
		
		emps=(Emp[])Stream.concat(Stream.of(emp1), Stream.of(emp2))
				.distinct()
				.toArray(b->new Emp[b]);
		for(Emp b:emps) {
			System.out.println(b.getEmpId()+" "+b.getEmpName());
		}
	}

}
