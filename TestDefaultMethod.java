package day0416;


interface X{
	public void m1();
	public void m2();
	default void m3() {
		System.out.println("call m3 default method");
	}
	static void m4() {
		System.out.println("static method is called");
	}
}

public class TestDefaultMethod implements X{
	@Override
	public void m1() {
		System.out.println("calling m1 method");
	}
	@Override
	public void m2() {
		System.out.println("calling m2 method");
	}
	public static void main(String[] args) {
		X x1 = new TestDefaultMethod();
		TestDefaultMethod x2 = new TestDefaultMethod();
		x1.m3();x1.m1(); x1.m2();
		X.m4();
	}
	
}
