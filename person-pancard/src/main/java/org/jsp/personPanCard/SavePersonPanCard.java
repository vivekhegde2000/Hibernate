package org.jsp.personPanCard;

import java.time.LocalDate;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class SavePersonPanCard {

	public static void main(String[] args) {
		EntityManager manager = Persistence.createEntityManagerFactory("dev").createEntityManager();
		EntityTransaction trans = manager.getTransaction();
		
		Person p = new Person();
		p.setName("Vivek");
		p.setEmail("vivek@mail.com");
		p.setPhone(9898767876L);
		
		PanCard card = new PanCard();
		card.setNumber("BVCVC1232W");
		card.setDob(LocalDate.parse("2023-07-23"));
		card.setCity("Sirsi");
		card.setState("Karnataka");
		card.setCountry("India");
		card.setPerson(p);
		card.setPincode(581402);
		p.setCard(card);
		
		Person p2= new Person();
		p2.setName("Anagha");
		p2.setEmail("anagha@mail.com");
		p2.setPhone(9611556434L);
		
		PanCard card2 = new PanCard();
		card2.setNumber("ABCDE1234W");
		card2.setDob(LocalDate.parse("2023-07-13"));
		card2.setCity("Siddapur");
		card2.setState("Karnataka");
		card2.setCountry("India");
		card2.setPerson(p2);
		card2.setPincode(123321);
		p2.setCard(card2);
		
		manager.persist(card);
		manager.persist(card2);
		
		trans.begin();
		trans.commit();
		
		System.out.println("Saved!!");
	}	

}
