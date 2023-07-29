package org.jsp.userproduct;

import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class UpdateUser {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Id , Name , Email , Phone and Password to Update!");
		int id = sc.nextInt();
		String name = sc.next();
		String email = sc.next();
		long phone = sc.nextLong();
		String password = sc.next();
		
		User u = new User();
		u.setId(id);
		u.setName(name);
		u.setEmail(email);
		u.setPhone(phone);
		u.setPassword(password);
		
		EntityManager manager = Persistence.createEntityManagerFactory("dev").createEntityManager();
		EntityTransaction trans = manager.getTransaction();
		
		manager.merge(u);
		
		trans.begin();
		trans.commit();
		
		
	}

}
