package org.jsp.personPanCard;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class FetchPersonByName {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter name to fetch Person Details");
		String name = sc.next();
		
		EntityManager manager = Persistence.createEntityManagerFactory("dev").createEntityManager();
		
		String qry = "select p from Person p where name = ?1";
		Query q = manager.createQuery(qry);
		q.setParameter(1, name);
		List<Person> persons = q.getResultList();
		if(persons.size()>0) {
			for(Person p : persons) {
				System.out.println("Name : "+p.getName());
				System.out.println("Email : "+p.getEmail());
				System.out.println("Phone : "+p.getPhone());
				System.out.println("Card : "+p.getCard());
			}
		}
		else {
			System.out.println("Person not found with Name : "+name);
		}
		
	}

}
