package org.jsp.userproduct;

import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class VerifyUserEmailPassword {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter your Email and Password to Verify");
		String email = sc.next();
		String password = sc.next();
		
		EntityManager manager = Persistence.createEntityManagerFactory("dev").createEntityManager();
		String qry = "select u from User u where email = ?1 and password = ?2";
		Query q = manager.createQuery(qry);
		q.setParameter(1, email);
		q.setParameter(2, password);
		
		try {
			User u = (User) q.getSingleResult();
			System.out.println("User Verified with Email : "+email +" and Password : "+password);
		}
		catch(NoResultException e){
			System.out.println("No user with Entered Email and Password!");
		}
	}

}
