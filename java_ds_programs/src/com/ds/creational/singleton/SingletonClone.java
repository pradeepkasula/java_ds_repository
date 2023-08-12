package com.ds.creational.singleton;

/**
 * Singleton Violation on Object Cloning.
 * If we try to make an instance by cloning it,
 * generated hash code of cloned copy doesn’t match with the actual object 
 * so it also violates the Singleton principle.
 * @author PKasula
 *
 */
public class SingletonClone implements Cloneable {

	public static SingletonClone instance = new SingletonClone();
	
	private SingletonClone() {
		System.out.println("Creating instance ....");
	}
	
	public static SingletonClone getInstance() {
		return instance;
	}
	
	protected Object clone() throws CloneNotSupportedException {
		return super.clone();
	}
	
	public static void main(String[] args) {
		SingletonClone sc1 = SingletonClone.getInstance();
		SingletonClone sc2 = SingletonClone.getInstance();
		
		System.out.println("Hashcode of the sc1 : " + sc1.hashCode());
		System.out.println("Hashcode of the sc2 : " + sc2.hashCode());
		
		//Clone object;
		try {
			SingletonClone sc3 = (SingletonClone) sc2.clone();
			System.out.println("Hashcode of the sc3 : " + sc3.hashCode());
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
		}
		
	}

}
