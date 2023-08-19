package hibernateTest;

import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class VerifyByEmailPassword {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Email to verify Person");
		String email = sc.next();
		System.out.println("Enter Password to verify Person");
		String password = sc.next();
		EntityManager manager = Persistence.createEntityManagerFactory("dev").createEntityManager();
		
		String qry = "select p from Person p where email=?1 and password=?2";
		Query q = manager.createQuery(qry);
		q.setParameter(1, email);
		q.setParameter(2, password);
		
		try {
			Person p1 = (Person)q.getSingleResult();
			System.out.println("Name : "+p1.getName());
			System.out.println("Email : "+p1.getEmail());
			System.out.println("Phone : "+p1.getPhone());
			System.out.println("Age : "+p1.getAge());
			System.out.println("Password : "+p1.getPassword());
		}
		catch(NoResultException e) {
			System.out.println("Not Verified Person!");
		}
	}

}
