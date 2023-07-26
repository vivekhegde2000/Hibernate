package org.jsp.personPanCard;

import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

public class FetchPersonById {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Id to fetch Details of Person");
		int id = sc.nextInt();
		
		EntityManager manager = Persistence.createEntityManagerFactory("dev").createEntityManager();
		
		Person p = manager.find(Person.class, id);
		if(p != null) {
			System.out.println("Name : "+p.getName());
			System.out.println("Email : "+p.getEmail());
			System.out.println("Phone : "+p.getPhone());
			System.out.println("Card : "+p.getCard());
			
		}
		else {
			System.out.println("Person not found with Id : "+id);
		}
	}

}
