package org.jsp.userproduct;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class SaveUserProduct {

	public static void main(String[] args) {
		EntityManager manager = Persistence.createEntityManagerFactory("dev").createEntityManager();
		EntityTransaction trans = manager.getTransaction();
		
		User u = new User();
		u.setName("Vivek");
		u.setEmail("vivek@gmail.com");
		u.setPhone(9887766543L);
		u.setPassword("vivek@123");
		
		Product p1 = new Product();
		p1.setName("Samsung S20 Fe");
		p1.setBrand("Samsung");
		p1.setCategory("Electronics");
		p1.setCost(25000);
		p1.setDescription("Its a Mobile");
		p1.setUsr(u);
		
		Product p2 = new Product();
		p2.setName("Hoodie");
		p2.setBrand("Lee Cooper");
		p2.setCategory("Mens Fashion");
		p2.setCost(1500);
		p2.setDescription("Its a Hoodie");
		p2.setUsr(u);
		
		Product p3 = new Product();
		p3.setName("WC Bag");
		p3.setBrand("WildCraft");
		p3.setCategory("Accessories");
		p3.setCost(2200);
		p3.setDescription("Its a Bag");
		p3.setUsr(u);
		
		List<Product> prods = new ArrayList<Product>();
		prods.add(p1);
		prods.add(p2);
		prods.add(p3);
		
		u.setProds(prods);
		
		manager.persist(u);
		trans.begin();
		trans.commit();
		System.out.println("User and Products Saved!!");
	}

}
