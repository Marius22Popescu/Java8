package day0416;

import java.util.ArrayList;
import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.IntPredicate;

class User{
	double userId;
	String userName;
	User(int userId, String userName){
		this.userId=userId;
		this.userName = userName;
	}
	@Override
	public String toString() {
		return "User [userId=" + userId + ", userName=" + userName + "]";
	}
	
}
public class BiFunctionTest {
	
	public static void display(List<User> user) {
		user.add(new User(1000, "David"));
		user.add(new User(2000, "Emre"));
		user.add(new User(3000, "Akku"));
		user.add(new User(4000, "Amar"));
	}
	public static void main(String[] args) {
		
		System.out.println("..Function..");
		List<User> user = new ArrayList<>();
		BiFunction<Integer, String, User> bi = (userId, userName) ->
		new User(userId, userName);
		user.add(bi.apply(1000, "David"));
		user.add(bi.apply(2000, "Emre"));
		user.add(bi.apply(3000, "Akku"));
		user.add(bi.apply(4000, "Amar"));
		user.forEach(System.out::println);

		System.out.println("..display user...");
		display(user);
		
		System.out.println("..Consumer..");
		BiConsumer<User, Double> c=(d,e)->d.userId=d.userId+e;
		for(User u:user) {
			c.accept(u,  500.0);
		}
		user.forEach(System.out::println);
		
		System.out.println("..Predicate..");
		IntPredicate i1 = (x)-> x < 0;
		System.out.println(i1.test(123)); //false
		
		IntPredicate i = (x)-> x < 0;
		System.out.println(i.negate().test(123)); //true
		
		IntPredicate i2 = (x)-> x < 0;
		IntPredicate j2 = (x)-> x == 0;
		System.out.println(i2.or(j2).test(123)); //false
	}
	

}
