package com.cg.hib;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.cg.hib.entity.Customer;
import com.cg.hib.entity.Product;
import com.cg.hib.entity.ProductOrder;

public class OneToManyMain {

	public static void main(String[] args) {
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction t = session.beginTransaction();
		
		
		// Extract the Product
		
		Product p1 = session.get(Product.class, 1);// pen
		Product p2 = session.get(Product.class, 2);// notebook
		Product p3 = session.get(Product.class, 3);// tshirt
		Product p4 = session.get(Product.class, 4);//shirt
		
		
		
		
		
		
		// public ProductOrder(int totalAmount, LocalDate orderDate, String status)
		ProductOrder order1 = new ProductOrder(500, LocalDate.of(2025, 4, 1),"Completed");
		ProductOrder order2 = new ProductOrder(501, LocalDate.of(2025, 9, 10),"Completed");
		ProductOrder order3 = new ProductOrder(60, LocalDate.of(2025, 8, 11),"Cancelled");
		ProductOrder order4 = new ProductOrder(80, LocalDate.of(2025, 9, 21),"Completed");
		
		Customer c1 = session.get(Customer.class, 1000);
		Customer c2 = session.get(Customer.class, 1003);
		Customer c3 = session.get(Customer.class, 1004);
		
		
		order1.setCustomer(c1);
		order2.setCustomer(c1);
		order3.setCustomer(c2);
		order4.setCustomer(c3);
	
		List<ProductOrder> c1PO = Arrays.asList(order1,order2);
		List<ProductOrder> c2PO = Arrays.asList(order3);
		List<ProductOrder> c3PO = Arrays.asList(order4);
		
		c1.setOrders(c1PO);
		c2.setOrders(c2PO);
		c3.setOrders(c3PO);
		
		t.commit();
		session.close();
		System.out.println("One To mant data Insertion ends");
	}
}
