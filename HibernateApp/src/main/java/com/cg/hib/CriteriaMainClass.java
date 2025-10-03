package com.cg.hib;

import java.util.List;


import org.hibernate.Session;

import com.cg.hib.entity.BankAccount;
import com.cg.hib.entity.Customer;
import com.cg.hib.entity.ProductOrder;

import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;

public class CriteriaMainClass {
	
	public static void main(String[] args) {
		CriteriaMainClass obj = new CriteriaMainClass();
		//obj.simpleSelect();
		//obj.selectUsingWhere();
		//obj.getCustomerBasedOnAddress();

		obj.getCustomerBasedOnProductOrder();
		
		System.out.println("\n-------------------------------------\n");
		obj.getBankBasedOnCustomer();
	}//end main
	
	public void simpleSelect() {
		Session session = HibernateUtil.getSessionFactory().openSession();
		
		CriteriaBuilder cb = session.getCriteriaBuilder();
		CriteriaQuery<Customer> cq = cb.createQuery(Customer.class);
		// this is what we select
		
		/* this is on what Object basis we filter*/
		Root<Customer> root = cq.from(Customer.class); // actual query
		cq.select(root);
		
		List<Customer> list = session.createQuery(cq).getResultList();
		System.out.println(list.size());
	}
	
	public void selectUsingWhere()
	{
		
		/*
		 * select * from Customer
		 * where customerName = ? and phone = ?
		 * 
		 * 
		 * */
		Session session = HibernateUtil.getSessionFactory().openSession();
		
		CriteriaBuilder cb = session.getCriteriaBuilder();
		CriteriaQuery<Customer> cq = cb.createQuery(Customer.class); // Select
		Root<Customer> root = cq.from(Customer.class); // actual query  
		// based on what object we want to filter
		
		String filterName = "Ramesh";
		long filterPhone = 435654123L;

		
		//Predicate p1 = cb.equal(root, root)
		
		Predicate p1 = cb.equal(root.get("customerName"), filterName);
		Predicate p2 = cb.equal(root.get("phone"), filterPhone);
		
		
		cq.select(root).where(cb.and(p1,p2));
		List<Customer> list = session.createQuery(cq).getResultList();
		list.stream().forEach((row)->{
			System.out.println(row.getCid());
			System.out.println(row.getEmail());
		});
		
		
	}

	
	public void getCustomerBasedOnAddress()
	{
		/*
		 * select * from customer where city = 'abc'
		 * */
		Session session = HibernateUtil.getSessionFactory().openSession();
		
		CriteriaBuilder cb = session.getCriteriaBuilder();
		CriteriaQuery<Customer> cq = cb.createQuery(Customer.class);
		Root<Customer> root = cq.from(Customer.class); // actual query
		
		String filterCity = "Banglore";
		// Note: city is not the direct entity , instead it is coming through 
		// embadded class

		
		Predicate p1 = cb.equal(root.get("address").get("city"), filterCity);
			
		cq.select(root).where(p1);
		List<Customer> list = session.createQuery(cq).getResultList();
		list.stream().forEach((row)->{
			System.out.println(row.getCid());
			System.out.println(row.getEmail());
		});
		
	}


	public void getCustomerBasedOnProductOrder()
	{
		/*		 
	Predicate childPredicate = cb.equal
						(childJoin.get("childAttributeName"), "someValue");
    cq.where(childPredicate);
		  
	Predicate parentPredicate = cb.greaterThan(parentRoot.get("parentAttributeName"), 100);
    cq.where(cb.and(parentPredicate, childPredicate)); // Combining predicates	  
  
		 select customer-----
			 * From ProductOrder po
			 * where po.orderId = 2
			 * */
			
		Session session = HibernateUtil.getSessionFactory().openSession();
		
		CriteriaBuilder cb = session.getCriteriaBuilder();
		/* Enity for the Select columns*/
		CriteriaQuery<Customer> cq = cb.createQuery(Customer.class);
		
		/* on what object basis we want to filter*/
		Root<ProductOrder> root = cq.from(ProductOrder.class); // actual query
		
		cq.select(root.get("customer"))
		  .where(cb.equal(root.get("orderId"),2));
		
		Customer customer = session.createQuery(cq).getSingleResult();
		System.out.println(customer);
		
		/*
		 * System.out.println(customer.getCid());
		 * System.out.println(customer.getCustomerName());
		 * System.out.println(customer.getPhone());
		 * System.out.println(customer.getAddress().toString());
		 */
		
		
	}
	
	public void getBankBasedOnCustomer()
	{
		/* SQL: 
		 * select * from bankaccount where accountNumber in
		 *  (select accountlinked from customer where cid=1003);
		 *  
		 *  in HQL:
		 *  BankAccount ba = (select c.bankAccount
		 *  from Customer c
		 *  where c.customerId = 1003).
		 * 
		 * */
		
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		
		CriteriaBuilder cb = session.getCriteriaBuilder();
		/* Enity for the Select columns*/
		CriteriaQuery<BankAccount> cq = cb.createQuery(BankAccount.class);
		
		/* on what object basis we want to filter*/
		Root<Customer> root = cq.from(Customer.class); // actual query
		
		Predicate p = cb.equal(root.get("cid"), 1003); // condition
		
		cq.select(root.get("bankAccount")).where(p);
		
		BankAccount ba = session.createQuery(cq).getSingleResult();
		System.out.println(ba);
		
		
	}



}//end class









































