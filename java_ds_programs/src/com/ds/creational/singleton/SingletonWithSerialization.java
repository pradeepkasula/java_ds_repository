package com.ds.creational.singleton;

/**
 * Singleton Violation on Serialization/Deserialization
 * When we serialize an object and deserialize it again 
 * there are different hash code values generated as shown in the example below. 
 * Therefore, our Singleton principle breaks in case of object serialization/deserialization also.
*/
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class SingletonWithSerialization implements Serializable{
	
	private static SingletonWithSerialization instance = new SingletonWithSerialization();
	
	private SingletonWithSerialization() {
		System.out.println("creating instance ....");
	}
	
	public static SingletonWithSerialization getInstance() {
		return instance;
	}
	
	public static void main(String[] args) {
		
		SingletonWithSerialization ss1 = SingletonWithSerialization.getInstance();
		SingletonWithSerialization ss2 = SingletonWithSerialization.getInstance();
		System.out.println("hashcode of ss1 ---" + ss1.hashCode());
		System.out.println("hashcode of ss2 ---" + ss2.hashCode());
		ObjectOutputStream oos=null;
		ObjectInputStream ois=null;
		try {
			String path = "c://apps/s2.ser";
			
			//Serializing object
			oos = new ObjectOutputStream(new FileOutputStream(path));
			oos.writeObject(ss2);
			
			
			//De Serializing Object
			ois = new ObjectInputStream(new FileInputStream(path));
			SingletonWithSerialization ss3 = (SingletonWithSerialization) ois.readObject();
			System.out.println("hashcode of ss3 --- " + ss3.hashCode());
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		finally {
			try {
				oos.close();
				ois.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		
		
		
		
	}

}
