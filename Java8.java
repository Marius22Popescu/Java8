package day0415;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Java8 {
	public static void main(String[] args) throws IOException{
		System.out.println(IntStream.range(1, 15).sum());
		
		System.out.println("......");
		Stream.of("David", "Emre", "Trupti", "Umair").sorted().findFirst().ifPresent(System.out::println);
		
		System.out.println("......");
		String[] names = {"Kshitij", "Amar", "Sarab", "Akbar"};
		Arrays.stream(names).filter(x->x.startsWith("A")).sorted().forEach(System.out::println);
		
		System.out.println("......");
		Arrays.stream(new int[] {2, 4, 6, 8, 10}).map(x->x*x).average().ifPresent(System.out::println);
		
		System.out.println("......");
		List<String> empName = (List<String>)
				Files.lines(Paths.get("/Users/marius/eclipse-workspace/MavenCoreJava/src/main/resources/data")).filter(x->x.contains("Maa")).collect(Collectors.toList());
		empName.forEach(x ->System.out.println(x));
		
		System.out.println("......");
		Stream<String> rows =(Stream<String>)
		Files.lines(Paths.get("/Users/marius/eclipse-workspace/MavenCoreJava/src/main/resources/data"));
			rows.map(z->z.split(","))
			.filter(z->z.length ==3).filter(z->Integer.parseInt(z[1])>15).forEach(z->System.out.println(z[0]+" "+z[2]));
			rows.close();
		
		System.out.println("......");	
		Stream<String> rows2 = (Stream<String>) Files.lines(Paths.get("/Users/marius/eclipse-workspace/MavenCoreJava/src/main/resources/data"));
			Map<String, Integer> map = new HashMap<>();
			map = rows2.map(z->z.split(",")).filter(z->z.length==3).filter(z-> Integer.parseInt(z[1]) >15).collect(Collectors.toMap(
							z->z[0],z->Integer.parseInt(z[1])));
			rows2.close();
			
		System.out.println("......");
			for(String key:map.keySet()) {
				System.out.println(key + " "+map.get(key));
			}		
		System.out.println(map);
	}
}
