package hibernateTest;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class UpdatePerson {

	public static void main(String[] args) {
		EntityManager manager = Persistence.createEntityManagerFactory("dev").createEntityManager();
		EntityTransaction trans = manager.getTransaction();
		
		Person p1 = new Person();
		p1.setId(1);
		p1.setName("Vivek");
		p1.setAge(22);
		p1.setEmail("vivek@gmail.com");
		p1.setPhone(8277338780L);
		p1.setPassword("vivek@123");
		
		manager.merge(p1);
		trans.begin();
		trans.commit();
		
		System.out.println("Updated / New Person Saved! Check once!");
	}

}
