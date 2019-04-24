package day0415;

import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

class Product{
	
	private String prdName;
	private double prdPrice;
	public String getPrdName() {
		return prdName;
	}
	public void setProdName(String prdName) {
		this.prdName = prdName;
	}
	public double getPrdPrice() {
		return prdPrice;
	}
	public void setPrdPrice(double prdPrice) {
		this.prdPrice = prdPrice;
	}
	public void setPrdName(String prdName) {
		this.prdName = prdName;
	}
	public Product(String prdName, double prdPrice) {
		super();
		this.prdName = prdName;
		this.prdPrice = prdPrice;
	}
	

}

public class ProductTest {
	public static void main(String[] args) {
		Map<String, Integer> map = new HashMap<>();
		map.put("TV",2500); map.put("Laptop", 1500); map.put("IPhone", 700);
		
		List<Product> list = map.entrySet().stream().sorted(Comparator.comparing(e->e.getKey()))
				.map(e->new Product(e.getKey(),e.getValue())).collect((Collectors.toList()));
		
		list.forEach(list2->System.out.println("Product Name "+ list2.getPrdName()+", Product Price "+list2.getPrdPrice()));
	}
}
