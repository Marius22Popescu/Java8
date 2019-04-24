package day0415;

import java.util.Arrays;

class Calculate2{
	public static int add(int a, int b) {
		return a+b;
	}
	public static int mul(int a, int b) {
		return a*b;
	}
}

public class ReduceTest {
	public static void main(String[] args) {
		int[] array = {23, 43, 56, 97, 32};
		Arrays.stream(array).reduce((x,y) -> x+y).ifPresent(s->System.out.println(s));
		
		Arrays.stream(array).reduce(Integer::sum).ifPresent(s->System.out.println(s));
		
		Arrays.stream(array).reduce(Calculate2::add).ifPresent(s->System.out.println(s));
		
		Arrays.stream(array).reduce(Calculate2::mul).ifPresent(s->System.out.println(s));
	}

}
