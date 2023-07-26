package org.jsp.personPanCard;

import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class FetchPanCardByPersonId {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Person Id to fetch PanCard details");
		int id = sc.nextInt();
		
		EntityManager manager = Persistence.createEntityManagerFactory("dev").createEntityManager();
		
		String qry = "select card from PanCard card where person_id=?1";
		Query q = manager.createQuery(qry);
		q.setParameter(1, id);
		try {
			PanCard card = (PanCard) q.getSingleResult();
			System.out.println("Number : "+card.getNumber());
			System.out.println("DOB : "+card.getDob());
			System.out.println("City : "+card.getCity());
			System.out.println("State : "+card.getState());
			System.out.println("Country : "+card.getCountry());
			System.out.println("PinCode : "+card.getPincode());
			System.out.println("Person : "+card.getPerson());
		}
		catch(NoResultException e) {
			System.out.println("Card Details Not found with Person Id :"+id);
		}
	}

}
