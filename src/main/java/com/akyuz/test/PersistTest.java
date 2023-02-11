package com.akyuz.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.akyuz.pojo.Product;
import com.akyuz.pojo.User;

public class PersistTest {

	public static void main(String[] args) {
		EntityManagerFactory  factory = Persistence.createEntityManagerFactory("MyPersistenceUnit");
		EntityManager manager = factory.createEntityManager();
		
		Product product1 = new Product("Masa", 1250.00, new Date());
		Product product2 = new Product("Defter", 1350.00, new Date());
		List<Product> products = Arrays.asList(product1,product2);
		
		
		User user = new User("Kasım");
		user.setProductList(products);
		
		
		
		manager.getTransaction().begin();
		manager.persist(user);
		manager.getTransaction().commit();
		
		
	}

}
