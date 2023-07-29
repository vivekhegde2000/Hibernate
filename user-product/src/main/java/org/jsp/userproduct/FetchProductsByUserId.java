package org.jsp.userproduct;

import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class FetchProductsByUserId {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter User Id to fetch Products");
		int userid = sc.nextInt();
		
		EntityManager manager = Persistence.createEntityManagerFactory("dev").createEntityManager();
		String qry = "select prods from Product prods where User_Id = ?1";
		Query q = manager.createQuery(qry);
		q.setParameter(1, userid);
		
		List<Product> prods = q.getResultList();
		if(prods.size()>0) {
			for(Product prod : prods) {
				System.out.println("Name : "+prod.getName());
				System.out.println("Brand : "+prod.getBrand());
				System.out.println("Category : "+prod.getCategory());
				System.out.println("Cost : "+prod.getCost());
				System.out.println("Description : "+prod.getDescription());
				System.out.println("User Id : "+prod.getUsr());
				System.out.println("-------------------------------------");
			}
		}
		else {
			System.out.println("No Products found with Useer Id : "+userid);
		}
	}

}
