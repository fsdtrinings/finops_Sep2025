package com.cg.hib;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.cg.hib.entity.Customer;

public class TestApp {

	public static void main(String[] args) {
	
		TestApp app = new TestApp();
		Session session = HibernateUtil.getSessionFactory().openSession();
		System.out.println(session);// connection between the app & db via hibernate
		
		try {
			
			app.doSaveCustomers(session);
			//app.getCustomerbyID(session);
			//app.getCustomerbyName(session);
			//app.doUpdate(session);
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
		}
		
	}//end main
	
	public void doSaveCustomers(Session session)throws Exception
	{
		Customer c = new Customer("neha", "neah@outlook.com", 435654123L);
		
		// through session object we can communicate with the DB 
		
		Transaction t = session.beginTransaction();
		
		session.persist(c);

		
		
		t.commit();
				
		System.out.println("Customer Saved");
		
	}

	public void getCustomerbyID(Session session)throws Exception
	{
		// to get the customer through Id 
		
		Customer c = session.get(Customer.class,1);
		System.out.println(c);
	}
	
	public void getCustomerbyName(Session session)throws Exception
	{
		// extract customers by name 
		// SQL : select * from customer where name = queryName;

		String quriedName = "neha"; // must be entered by User
		// HQL :  From Customer c where c.name = :qName
		// setParameter(qname,quriedName);
		
		String strQuery = "From Customer c where c.customerName = :qName";
		// Customer is the java class name , not the table and customerName is the propertyName
	     Query<Customer> q = session.createQuery(strQuery);
	     q.setParameter("qName", quriedName);
	     
	     List<Customer> resultset = q.getResultList();
	     for (Customer customer : resultset) {
			printCustomer(customer);
		}
	
	}
	
	public void doUpdate(Session session)throws Exception
	{
		/* extract the email id's based on domain name and update those emails */
		
		// only call get query 
		// when the object is associated with hibernate object -> update operations
		
		Transaction t = session.beginTransaction();
		
		// SQL : select * from customer where email like '%gmail.com';
		String hql = "From Customer c where c.email LIKE :pattern";
		String filter = "%gmail.com";
		
		List<Customer> list = session.createQuery(hql, Customer.class)
			   .setParameter("pattern", filter)
			   .getResultList();
		
		for (Customer c : list) {
			
			String oldEmail = c.getEmail();
			String parts[] = oldEmail.split("@");
			String username = parts[0];
			c.setEmail(username+"_new@g.com");
		}
		
		
		t.commit();
		System.out.println(" Update process ends");
	}
	
	
	public void printCustomer(Customer c)
	{
		System.out.println(c);
	}

}//end Class

















































