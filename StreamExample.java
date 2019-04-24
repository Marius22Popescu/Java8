package day0415;

import java.util.stream.Stream;

public class StreamExample {
	public static void main(String[] args) {
		Stream<String> a1 = Stream.of("AA","BB","CC");
		Stream<String> a2 = Stream.of("AA","BB","CC");
		Stream<String> s = Stream.concat(a1, a2);
		s.forEach(e->System.out.println(e+" "));
		System.out.println("....");
		
		a1 = Stream.of("AA","BB","CC");
		a2 = Stream.of("AA","BB","CC");
		s=Stream.concat(a1, a2).distinct();
		s.forEach(e->System.out.println(e+" "));
		a1.close(); a2.close(); s.close();
		
	}
}
