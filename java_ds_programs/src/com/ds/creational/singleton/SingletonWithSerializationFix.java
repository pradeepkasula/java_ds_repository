package com.ds.creational.singleton;

/**
 * Implement a new readResolve () method in the Singleton class as shown below.
 */
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class SingletonWithSerializationFix implements Serializable{
	
	private static SingletonWithSerializationFix instance = new SingletonWithSerializationFix();
	
	private SingletonWithSerializationFix() {
		System.out.println("creating instance ....");
	}
	
	public static SingletonWithSerializationFix getInstance() {
		return instance;
	}
	
	private Object readResolve() {
		System.out.println("Applying ReadResolve method...");
		return SingletonWithSerializationFix.instance;
	}
	
	public static void main(String[] args) {
		
		SingletonWithSerializationFix ss1 = SingletonWithSerializationFix.getInstance();
		SingletonWithSerializationFix ss2 = SingletonWithSerializationFix.getInstance();
		System.out.println("hashcode of ss1 ---" + ss1.hashCode());
		System.out.println("hashcode of ss2 ---" + ss2.hashCode());
		
		try {
			String path = "c://apps/s2.ser";
			//Serializing object
			ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(path));
			oos.writeObject(ss2);
			
			
			//De Serializing Object
			ObjectInputStream ois = new ObjectInputStream(new FileInputStream(path));
			SingletonWithSerializationFix ss3 = (SingletonWithSerializationFix) ois.readObject();
			System.out.println("hashcode of ss3 --- " + ss3.hashCode());
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

}
