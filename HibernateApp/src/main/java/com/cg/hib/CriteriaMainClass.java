package com.cg.hib;

import java.util.List;


import org.hibernate.Session;

import com.cg.hib.entity.Customer;

import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;

public class CriteriaMainClass {
	
	public static void main(String[] args) {
		CriteriaMainClass obj = new CriteriaMainClass();
		//obj.simpleSelect();
		obj.selectUsingWhere();
	}//end main
	
	public void simpleSelect() {
		Session session = HibernateUtil.getSessionFactory().openSession();
		
		CriteriaBuilder cb = session.getCriteriaBuilder();
		CriteriaQuery<Customer> cq = cb.createQuery(Customer.class);
		
		Root<Customer> root = cq.from(Customer.class); // actual query
		cq.select(root);
		
		List<Customer> list = session.createQuery(cq).getResultList();
		System.out.println(list.size());
	}
	
	public void selectUsingWhere()
	{
		Session session = HibernateUtil.getSessionFactory().openSession();
		
		CriteriaBuilder cb = session.getCriteriaBuilder();
		CriteriaQuery<Customer> cq = cb.createQuery(Customer.class);
		Root<Customer> root = cq.from(Customer.class); // actual query
		
		String filterName = "Ramesh";
		long filterPhone = 435654123L;

		
		//	Predicate p1 = 
		
		//cq.select(root).where()
		
		
	}

}//end class









































