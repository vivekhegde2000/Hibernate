package hibernateTest;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class SavePerson {

	public static void main(String[] args) {
		EntityManager manager = Persistence.createEntityManagerFactory("dev").createEntityManager();
		EntityTransaction trans = manager.getTransaction();
		
		Person p1 = new Person();
		p1.setName("Raj");
		p1.setAge(20);
		p1.setEmail("raj@gmail.com");
		p1.setPhone(9434233456L);
		p1.setPassword("raj@123");
		
		manager.persist(p1);
		trans.begin();
		trans.commit();
		
		System.out.println("Person Saved!");
	}

}
