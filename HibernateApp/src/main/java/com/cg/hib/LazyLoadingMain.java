package com.cg.hib;

import java.util.List;

import org.hibernate.Session;

import com.cg.hib.entity.BankAccount;
import com.cg.hib.entity.Customer;
import com.cg.hib.entity.OrderItem;
import com.cg.hib.entity.Product;
import com.cg.hib.entity.ProductOrder;

public class LazyLoadingMain {
	Session session ;

	public LazyLoadingMain() {
		session = HibernateUtil.getSessionFactory().openSession();
	}
	
	public static void main(String[] args) {

		LazyLoadingMain obj = new LazyLoadingMain();
		obj.doLazyIssue3();
		
	}// end main

	public void doLazyIssue() {
		Session session = HibernateUtil.getSessionFactory().openSession();

		Product p = session.get(Product.class, 1);
		session.close();
		System.out.println(p.getName());
	}

	public void doLazyIssue2() {
		Session session = HibernateUtil.getSessionFactory().openSession();

		Customer c = session.get(Customer.class, 1003);
		session.close();
		BankAccount ba = c.getBankAccount();
		System.out.println(ba);
	}

	public void doLazyIssue3() {
		Session session = HibernateUtil.getSessionFactory().openSession();

		ProductOrder po = session.get(ProductOrder.class,2);
		session.close();
		List<OrderItem> list = po.getOrderItems();
		System.out.println(list.size());
	}

}// end class
