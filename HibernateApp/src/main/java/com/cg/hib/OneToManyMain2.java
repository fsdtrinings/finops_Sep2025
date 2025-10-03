package com.cg.hib;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.cg.hib.entity.Customer;
import com.cg.hib.entity.OrderItem;
import com.cg.hib.entity.Product;
import com.cg.hib.entity.ProductOrder;

public class OneToManyMain2 {

	public static void main(String[] args) {
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction t = session.beginTransaction();
		
		
		// Extract the Product
		
		Product p1 = session.get(Product.class, 1);// pen
		Product p2 = session.get(Product.class, 2);// notebook
		Product p3 = session.get(Product.class, 3);// tshirt
		Product p4 = session.get(Product.class, 4);//shirt
		
		Customer c1 = session.get(Customer.class, 1003);
	
		
		
		// public ProductOrder(int totalAmount, LocalDate orderDate, String status)
		ProductOrder po = new ProductOrder(400, LocalDate.of(2025, 4, 1),"Completed");
		po.setCustomer(c1);
		
		OrderItem oi1 = new OrderItem(p3, 1, 800);
		oi1.setOrder(po);
		
		OrderItem oi2 = new OrderItem(p2, 2, 170);
		oi2.setOrder(po);
		
		List<OrderItem> allOrderItems = Arrays.asList(oi1,oi2);
		po.setOrderItems(allOrderItems);
		
		
		session.persist(po);
		
		
		
		
		
		
	
		
		t.commit();
		session.close();
		System.out.println("One To many data Insertion ends");
	}
}
