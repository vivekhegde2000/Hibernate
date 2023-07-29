package org.jsp.userproduct;

import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class VerifyUserPhonePassword {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter your Phone and Password to Verify");
		long phone = sc.nextLong();
		String password = sc.next();
		
		EntityManager manager = Persistence.createEntityManagerFactory("dev").createEntityManager();
		String qry = "select u from User u where phone = ?1 and password = ?2";
		Query q = manager.createQuery(qry);
		q.setParameter(1, phone);
		q.setParameter(2, password);
		
		try {
			User u = (User) q.getSingleResult();
			System.out.println("User Verified with Phone : "+phone +" and Password : "+password);
		}
		catch(NoResultException e){
			System.out.println("No user with Entered phone and Password!");
		}
	}

}
