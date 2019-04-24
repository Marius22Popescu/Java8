package day0417;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;

public class Serializer {
	public static void main(String[] args) {
		Serializer serializer = new Serializer();
		serializer.serializeAddress("wall street", "NY", "united states");
	}
	public void serializeAddress(String street, String state, String country) {
		Address address = new Address();
		address.setStreet(street);
		address.setState(state);
		address.setCountry(country);
		try {
			FileOutputStream fout = new FileOutputStream("/Users/marius/eclipse-workspace/MavenCoreJava/src/main/resources/address.txt");
			ObjectOutputStream oos = new ObjectOutputStream(fout);
			oos.writeObject(address);
			oos.close();
			System.out.println("Done");
		}catch(Exception ex) {
			ex.printStackTrace();
		}
	}
}
