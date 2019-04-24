package com.marius.MavenCoreJava;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.*;


/**
 * Hello world!
 *
 */
public class App {

    public static void main(String... args) { //... means variable arguments, can do this or array []
        // TODO Auto-generated method stub
        List<Apple> inventory=Arrays.asList(new Apple(80,"green"),new Apple(155,"green"),new Apple(123,"red"));
        
        List<Apple> greenApples=filterApples(inventory, App::isGreenApple); //:: means method reference in java 8, its same as FilterApples.isgreenapple()
        System.out.println("Green Apples: " + greenApples);
        
        List<Apple> heavyApples=filterApples(inventory, App::isHeavyApple);
        System.out.println("Heavy Apples: "+ heavyApples);
        
        List<Apple> greenApples2=filterApples(inventory, (Apple a)-> "green".contentEquals(a.getColor())); 
        System.out.println("Green Apples2: " +greenApples2);
        
        List<Apple> heavyApples2=filterApples(inventory, (Apple a)-> a.getWeight()>150); 
        System.out.println("Heavy Apples2: "+heavyApples2);
        
        List<Apple> unknownApples=filterApples(inventory, (Apple a)-> a.getWeight()<80 || "brown".equals(a.getColor()));
        System.out.println("Unknown Apples: "+unknownApples);
        
        Runnable r = ()->System.out.println("calling runnable"); //Lambda expression with no parameter 
        r.run();
    }
    
    public static List<Apple> filterOnlyGreenApples(List<Apple> inventory) {
        List<Apple> result = new ArrayList<>();
        for(Apple apple:inventory) {
            if("green".contentEquals(apple.getColor())) {
                result.add(apple);
            }
        }
        return result;
    }
    
    public static List<Apple> filterOnlyHeavyApples(List<Apple> inventory) {
        List<Apple> result = new ArrayList<>();
        for(Apple apple:inventory) {
            if(apple.getWeight()>150) {
                result.add(apple);
            }
        }
        return result;
    }
    
    public static boolean isGreenApple(Apple apple) {
        return "green".contentEquals(apple.getColor());
    }
    
    public static boolean isHeavyApple(Apple apple) {
        return apple.getWeight()>150;
    }
    
    public static List<Apple> filterApples(List<Apple> inventory, Predicate<Apple> a){
        List<Apple> result = new ArrayList<>();
        for(Apple apple:inventory) {
            if(a.test(apple)) { //for predicate test 
                result.add(apple);
            }
        }
        return result;
    }
    
    
    //inner class
    public static class Apple{
        private int weight=0;
        private String color="";
        
        public Apple(int weight, String color) {
            super();
            this.weight = weight;
            this.color = color;
        }
        
        public int getWeight() {
            return weight;
        }
        public void setWeight(int weight) {
            this.weight = weight;
        }
        public String getColor() {
            return color;
        }
        public void setColor(String color) {
            this.color = color;
        }

        @Override
        public String toString() {
            return "Apple [weight=" + weight + ", color=" + color + "]";
        }          
    }
}
