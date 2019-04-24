package day0417;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;


public class CustSer {
	public static void main(String[] args) throws Exception{
		Login a2 = new Login();
		FileOutputStream fos = new FileOutputStream("xyz.ser");
		ObjectOutputStream oos = new ObjectOutputStream(fos);
		oos.writeObject(a2);
		
		FileInputStream fis = new FileInputStream("xyz.ser");
		ObjectInputStream ois = new ObjectInputStream(fis);
		Login a3 = (Login)ois.readObject();
		System.out.println("User Name: "+" "+a3.username+" Password: "+a3.pwd+" PIN: "+a3.pin);
		
	}

}
