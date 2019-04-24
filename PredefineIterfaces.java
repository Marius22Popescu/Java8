package day0416;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

class Inventory{
	String name;

         Inventory(String name) {
	super();
	this.name = name;
}
}         

public class PredefineIterfaces {
	public static int square(int a) {
		return a*a;
	}
	public static void main(String[] args) {
		String s[] = {"david", "emre", "marius", "trupti", "akku", "umair"};
		System.out.println(square(10));
		Function<Integer, Integer> f = i->i*i;  //create the function f
		System.out.println(f.apply(10));
		
		Predicate<Integer> p  = i->i%2 == 0;
		System.out.println(p.test(5));
		System.out.println(p.test(6));
		
		System.out.println(".........");
		Predicate<String> p1 = s1->s1.length() > 4;
		for(String s2:s) {
			if(p1.test(s2)) {
				System.out.println(s2);
			}
		}
		
		Consumer<Inventory> c1 = m-> System.out.println(m.name+"new item release");
		Consumer<Inventory> c2 = m-> System.out.println(m.name+"no users release");
		Consumer<Inventory> c3 = m-> System.out.println(m.name+"wait for item release");
		Consumer<Inventory> cc = c1.andThen(c2).andThen(c3);
		
		Inventory i1 = new Inventory("New branded laptop");
		//c1.accept(i1); c2.accept(i1); c3.accept(i1);
		c1.accept(i1);
		
		//Supplier
		
		Supplier<String> ss = ()->{
			String otp = "";
			for(int i=0; i<6; i++) {
				otp=otp+(int)(Math.random()*10);
			}
			return otp;
		};
		System.out.println(ss.get());
		System.out.println(ss.get());
		System.out.println(ss.get());
		System.out.println(ss.get());
	}
}
