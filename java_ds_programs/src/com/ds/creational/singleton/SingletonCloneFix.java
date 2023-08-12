package com.ds.creational.singleton;

/**
 * Singleton Violation on Object Cloning.
 * If we try to make an instance by cloning it,
 * generated hash code of cloned copy doesn’t match with the actual object 
 * so it also violates the Singleton principle.
 * @author PKasula
 *
 */
public class SingletonCloneFix implements Cloneable {

	public static SingletonCloneFix instance = new SingletonCloneFix();
	
	private SingletonCloneFix() {
		System.out.println("Creating instance ....");
	}
	
	public static SingletonCloneFix getInstance() {
		return instance;
	}
	
	protected Object clone() throws CloneNotSupportedException {
		//Here verifyig Singleton instance already exist or not.
		if(instance!=null) {
			throw new RuntimeException("instance already created...");
		}
		return super.clone();
	}
	
	public static void main(String[] args) {
		SingletonCloneFix sc1 = SingletonCloneFix.getInstance();
		SingletonCloneFix sc2 = SingletonCloneFix.getInstance();
		
		System.out.println("Hashcode of the sc1 : " + sc1.hashCode());
		System.out.println("Hashcode of the sc2 : " + sc2.hashCode());
		
		//Clone object;
		try {
			SingletonCloneFix sc3 = (SingletonCloneFix) sc2.clone();
			System.out.println("Hashcode of the sc3 : " + sc3.hashCode());
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
		}
		
	}

}
