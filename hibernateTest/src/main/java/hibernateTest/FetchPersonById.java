package hibernateTest;

import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

public class FetchPersonById {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Id to Fetch Person Details");
		int id = sc.nextInt();
		
		EntityManager manager = Persistence.createEntityManagerFactory("dev").createEntityManager();
		
		Person p1 = manager.find(Person.class, id);
		if(p1!=null) {
			System.out.println("Name : "+p1.getName());
			System.out.println("Email : "+p1.getEmail());
			System.out.println("Phone : "+p1.getPhone());
			System.out.println("Age : "+p1.getAge());
			System.out.println("Password : "+p1.getPassword());
		}
		else {
			System.out.println("Person not found with id : "+id);
		}
		
	}

}
