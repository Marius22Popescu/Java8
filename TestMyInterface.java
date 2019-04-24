package com.marius.MavenCoreJava;

import java.util.Arrays;
import java.util.List;
import java.util.*;
import java.util.concurrent.TimeUnit;
import java.util.function.*;

interface Calculate{
double sum(int a);
default double sqrt(int a) {	
return Math.sqrt(a);
}
}

public class TestMyInterface {

public static void main(String[] args) {
Calculate c=new Calculate() {			//instantiating an object and creating a class in the same time 
public double sum(int x) {return sqrt(x*100);
}};
System.out.println("c.sum(100) is: "+c.sum(100));
System.out.println("c.sqrt(25) is: "+c.sqrt(25));

List<String> emps=Arrays.asList("David","Marius","Emre","Umair");
Collections.sort(emps, new Comparator<String>() {
public int compare(String a,String b) {
return b.compareTo(a); 
}
});
Collections.sort(emps,(String a,String b)->b.compareTo(a));
Collections.sort(emps,(a,b)->b.compareTo(a));
emps.sort((a,b)->b.compareTo(a));
//sorted,filter --intermediate operation
List<String> collec=new ArrayList<>();
collec.add("ddd2"); collec.add("aaa2"); collec.add("bbb1");
collec.add("aaa1");
collec.add("bbb3"); collec.add("ccc"); collec.add("bbb2");
collec.add("ddd1");

System.out.println("start with a:");
collec.stream().filter((s)->s.startsWith("a")).forEach(System.out::println);
System.out.println("start with a sorted: ");
collec.stream().sorted().filter((s)->s.startsWith("a")).forEach(System.out::println);
System.out.println("to upper case:");
collec.stream().map(String::toUpperCase).forEach(System.out::println);

System.out.println("Terminal Function:");
//terminal function

boolean anyStartsWithA=collec.stream().anyMatch((s)->s.startsWith("a"));
System.out.println(anyStartsWithA);


boolean allStartsWithA=collec.stream().allMatch((s)->s.startsWith("a"));
System.out.println(allStartsWithA);

boolean noneStartsWithZ=collec.stream().noneMatch((s)->s.startsWith("z"));
System.out.println(noneStartsWithZ);

long startsWithB=collec.stream().filter((s)->s.startsWith("b")).count();
System.out.println(startsWithB);

Optional<String> reduced=collec.stream().sorted().reduce((s1,s2)->s1+"#"+s2);
reduced.ifPresent(System.out::println);

int x=1000000;
List<String> values=new ArrayList<>(x);
for(int i=0;i<x;i++) {
UUID uuid=UUID.randomUUID();
values.add(uuid.toString()); 
}

long x0=System.nanoTime();
long count=values.parallelStream().sorted().count();
System.out.println(count);
long x1=System.nanoTime();
long millis=TimeUnit.NANOSECONDS.toMillis(x1-x0);
System.out.println(String.format("sequential sort : %d ms", millis));

Map<Integer,String> map=new HashMap<>();
for(int i=0;i<10;i++) {
map.putIfAbsent(i, "val"+i);
}
map.forEach((id,val)-> System.out.println(val));
map.computeIfPresent(3,(num,val)->val+num);
map.get(3);

}
}
