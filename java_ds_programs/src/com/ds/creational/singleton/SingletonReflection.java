package com.ds.creational.singleton;

import java.lang.reflect.Constructor;

/*
 * Singleton Violation on Using Reflection
 * Using reflection, we can set the private constructor to become accessible at runtime as shown in the example below.
 */

public class SingletonReflection {

public static SingletonReflection instance= new SingletonReflection();
	
	private SingletonReflection() {
		System.out.println("creating instance.....");
		
	}
	
	public static SingletonReflection getInstance() {
		return instance;
	}

	public static void main(String[] args) throws Exception{
		SingletonReflection s1 = SingletonReflection.getInstance();
		SingletonReflection s2 = SingletonReflection.getInstance();
		System.out.println("Hashcode of Object s1: " +s1.hashCode());
		System.out.println("Hashcode of Object s2: " +s2.hashCode());
		
		//By below logic, we can create singleton object using reflection api.
		// So here singleton violation happened here.
		Class clazz = Class.forName("com.ds.creational.singleton.SingletonReflection");
		Constructor<SingletonReflection> ctr= clazz.getDeclaredConstructor();
		ctr.setAccessible(true);
		SingletonReflection s3 = ctr.newInstance();
		System.out.println("Hashcode of Object s3: " +s3.hashCode());

	}
}
