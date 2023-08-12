package com.ds.creational.singleton;

/**
 * This program is Single ton class with eager initialization
 * @author PKasula
 *
 */

/*
 * Using this approach, we rely on the JVM to create the unique instance of the Singleton when the class is loaded. 
 * The JVM guarantees that the instance will be created before any thread accesses the static uniqueInstance variable.
 * Now here is one catch! We have to think about thread safety. In that case, we go with lazy initialization.
 */
public class SingletonWithEager {
	
	private static SingletonWithEager singletonWithEager = new SingletonWithEager();
	
	private SingletonWithEager() {
		System.out.println("I am in constructor...");
	}

	public static SingletonWithEager getInstance() {
		System.out.println("I am in getInstance method...");
		return singletonWithEager;
	}
	
	public void display() {
		System.out.println("In display method....");
	}
	
	public static void main(String[] args) {
	
		SingletonWithEager eager = SingletonWithEager.getInstance();
		eager.display();
	}

}
