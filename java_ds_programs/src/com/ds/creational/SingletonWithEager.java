package com.ds.creational;

/**
 * This program is Single ton class with eager initialization
 * @author PKasula
 *
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
