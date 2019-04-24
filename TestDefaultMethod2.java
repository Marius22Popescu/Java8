package day0416;

interface A{
	default void t1() {
		System.out.println("calling t1 from A");
	}
}
interface B{
	default void t1() {
		System.out.println("calling t1 from B");
	}
}
public class TestDefaultMethod2 implements A,B {
	public void t1() {
		System.out.println("calling t1 from Main");
	}
	public static void main(String[] args) {
		TestDefaultMethod2 b1 = new TestDefaultMethod2();
		b1.t1();
	}

}
