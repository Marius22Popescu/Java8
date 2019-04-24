package day0417;

import java.io.FileInputStream;
import java.io.ObjectInputStream;

public class Deserializer {
	public static void main(String[] args) {
		Deserializer deserializer = new Deserializer();
		Address address = deserializer.deserializeAddress();
		System.out.println(address);
	}
	public Address deserializeAddress() {
		Address address;
		try {
			FileInputStream fin = new FileInputStream("/Users/marius/eclipse-workspace/MavenCoreJava/src/main/resources/address.txt");
			ObjectInputStream ois = new ObjectInputStream(fin);
			address = (Address) ois.readObject();
			ois.close();
			return address;
		}catch(Exception ex) {
			ex.printStackTrace();
			return null;
		}
	}

}
