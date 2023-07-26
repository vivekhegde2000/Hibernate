package org.jsp.personPanCard;

import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class FetchPersonByPanCardNumber {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Pan Number to Fetch Person Details");
		String number = sc.next();
		
		EntityManager manager = Persistence.createEntityManagerFactory("dev").createEntityManager();
		
		String qry = "select p from Person p where card_id = (select card.id from PanCard card where card.number=?1)";
		Query q = manager.createQuery(qry);
		q.setParameter(1, number);
		
		try {
			Person p = (Person)q.getSingleResult();
			System.out.println("Name : "+p.getName());
			System.out.println("Email : "+p.getEmail());
			System.out.println("Phone : "+p.getPhone());
			System.out.println("Card : "+p.getCard());
		
		}
		catch(NoResultException e) {
			System.out.println("No Person Found withe Entered PanCard Number :"+ number);
		}
		
	}

}
