package hibernateTest;

import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class FetchByName {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter name to fetch Person Details");
		String name = sc.nextLine();
		EntityManager manager = Persistence.createEntityManagerFactory("dev").createEntityManager();
		
		String qry = "select p from Person p where name=?1";
		Query q = manager.createQuery(qry);
		q.setParameter(1, name);
		
		List<Person> persons = q.getResultList();
		if(persons.size()>0) {
			for(Person p1 : persons) {
				System.out.println("Name : "+p1.getName());
				System.out.println("Email : "+p1.getEmail());
				System.out.println("Phone : "+p1.getPhone());
				System.out.println("Age : "+p1.getAge());
				System.out.println("Password : "+p1.getPassword());
			}
		}
		else {
			System.out.println("No user found with name :"+name);
		}
	}

}
