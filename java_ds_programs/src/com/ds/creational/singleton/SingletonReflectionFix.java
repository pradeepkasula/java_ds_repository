package com.ds.creational.singleton;

import java.lang.reflect.Constructor;

/*
 * Singleton Violation on Using Reflection
 * Using reflection, we can set the private constructor to become accessible at runtime as shown in the example below.
 */

public class SingletonReflectionFix {

public static SingletonReflectionFix instance= new SingletonReflectionFix();
	
	private SingletonReflectionFix() {
		System.out.println("creating instance.....");
		//If already instance created, throwing runtime exception, so that avoid to create new object using reflection.
		if(instance!=null)
			throw new RuntimeException("Instance already created...");
		
	}
	
	public static SingletonReflectionFix getInstance() {
		return instance;
	}

	public static void main(String[] args) throws Exception{
		SingletonReflectionFix s1 = SingletonReflectionFix.getInstance();
		SingletonReflectionFix s2 = SingletonReflectionFix.getInstance();
		System.out.println("Hashcode of Object s1: " +s1.hashCode());
		System.out.println("Hashcode of Object s2: " +s2.hashCode());
		
		//By below logic, we can create singleton object using reflection api.
		// So here singleton violation happened here.
		Class clazz = Class.forName("com.ds.creational.singleton.SingletonReflectionFix");
		Constructor<SingletonReflectionFix> ctr= clazz.getDeclaredConstructor();
		ctr.setAccessible(true);
		SingletonReflectionFix s3 = ctr.newInstance();
		System.out.println("Hashcode of Object s3: " +s3.hashCode());

	}
}
