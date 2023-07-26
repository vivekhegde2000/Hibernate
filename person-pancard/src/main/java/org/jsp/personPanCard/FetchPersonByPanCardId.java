package org.jsp.personPanCard;

import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class FetchPersonByPanCardId {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter PanCard Id to fetch Person Details");
		int id = sc.nextInt();
		
		EntityManager manager = Persistence.createEntityManagerFactory("dev").createEntityManager();
		
		String qry = "select p from Person p where card_id=?1";
		Query q = manager.createQuery(qry);
		q.setParameter(1,id);
		try {
			Person p = (Person)q.getSingleResult();
			System.out.println("Name : "+p.getName());
			System.out.println("Email : "+p.getEmail());
			System.out.println("Phone : "+p.getPhone());
			System.out.println("Card : "+p.getCard());
		
		}
		catch(NoResultException e) {
			System.out.println("No Person Found withe Entered PanCard ID :"+id);
		}
	}

}
