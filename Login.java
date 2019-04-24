package day0417;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class Login implements Serializable{
	
	String username = "saran";
	String pwd = "saran";
	String epwd;
	int pin = 3456;
	
	private void writeObject(ObjectOutputStream oos) throws Exception{
	oos.defaultWriteObject();
	epwd="1@3" + pwd;
	int epin = 7777+pin;
	oos.writeObject(epwd);
	oos.writeInt(epin);
	}
	
	private void readObject(ObjectInputStream ois) throws Exception{
		ois.defaultReadObject();
		String epw = (String) ois.readObject();
		pwd= pwd.substring(3);
		int epin = ois.readInt();
		pin = epin - 7777;
	}
}
