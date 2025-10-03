package com.cg.hib;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.cg.hib.entity.Product;

public class ProductMainCLass {

	public static void main(String[] args) {
		
		ProductMainCLass obj = new ProductMainCLass();
		//obj.saveproduct();
		obj.doLazyIssue();
	}
	
	public void saveproduct()
	{
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction t = session.beginTransaction();
		
		
		Product p1 = new Product("pen", 10, 15);
		Product p2 = new Product("notebook", 60, 85);
		Product p3 = new Product("T-Shirt", 1000, 1500);
		Product p4 = new Product("Shirt", 2010, 2515);
		
		session.save(p1);
		session.save(p2);
		session.save(p3);
		session.save(p4);
		
		
		
		t.commit();
		session.close();
	}
	
	public void doLazyIssue()
	{
		Session session = HibernateUtil.getSessionFactory().openSession();
		
		Product p = session.get(Product.class,1);
		session.close();
		System.out.println(p.getName());
	}
	
	
}
