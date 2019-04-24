package day0416;

import java.util.Optional;

public class OptionalExample {
	public static void main(String[] args) {
		Optional<String> gender = Optional.of("MALE");
		Optional<String> emptyGender = Optional.empty();
		//orElse
		System.out.println(gender.orElse("N/A")); //MALE
		System.out.println(emptyGender.orElse("N/A")); //(N\A)
		//orElseGet
		System.out.println(gender.orElseGet(()->"N/A")); //MALE
		System.out.println(emptyGender.orElseGet(()->"N/A")); //(N\A)
		//Apply Filter on Optional
		System.out.println(gender.filter(g->g.contentEquals("male"))); //MALE
		System.out.println(gender.filter(g->g.equalsIgnoreCase("MALE"))); //(N\A)
		System.out.println(emptyGender.filter(g->g.equalsIgnoreCase("MALE"))); //(N\A)		
		
		String ans1 = "Yes"; String ans2 = null;
		System.out.println("Non Empty optional" + gender);
		System.out.println("Non Empty optional gender value" + gender.get());
		System.out.println("Empty optional" + Optional.empty());
		
		System.out.println("ofNullable on Non Empty optional" + Optional.ofNullable(ans1));
		System.out.println("ofNullable on Non Empty optional" + Optional.ofNullable(ans2));
		System.out.println("ofNullable on Non Empty optional" + Optional.of(ans2));
		if(gender.isPresent()) {
			System.out.println("value is present");
		}else {
			System.out.println("value is not pressent");
		}
	}
}
