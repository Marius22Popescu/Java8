package day0416;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class ConcurrentModificationExceptionTest {
	public static void main(String[] args) {
		//Hash Map
		Map<String, String> myMap = new ConcurrentHashMap<>(); //With hash map I get a ConcurrentModificationException error , with ConcurrentHashMap no more errors
			myMap.put("1", "1");
			myMap.put("2", "1");
			myMap.put("3", "1");
			myMap.put("4", "1");
			myMap.put("5", "1");
			myMap.put("6", "1");
			System.out.println("HashMap before iterator: "+myMap);
			Iterator<String> it1 = myMap.keySet().iterator();
			while(it1.hasNext()) {
				String key = it1.next();
				if(key.contentEquals("3")) myMap.put(key+"new", "2");
			}
			System.out.println("HashMap after iterator: "+myMap);
	}
}
