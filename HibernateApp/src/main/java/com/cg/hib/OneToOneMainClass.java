package com.cg.hib;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.cg.hib.entity.Address;
import com.cg.hib.entity.BankAccount;
import com.cg.hib.entity.Customer;

public class OneToOneMainClass {

	public static void main(String[] args) throws Exception{

		OneToOneMainClass obj = new OneToOneMainClass();
		Session session = HibernateUtil.getSessionFactory().openSession();
		obj.saveData_With_Cascading(session);
	}
	
	
	public void saveData_With_Cascading(Session session)throws Exception
	{
		Transaction t = session.beginTransaction();

		Customer c = new Customer("A", "a@outlook.com", 435654123L);
		Address ca = new Address("xyz-123", "Pune", "Pune");
		BankAccount ba = new BankAccount(789696, "ICICI-Bank", "i456");

		c.setAddress(ca);
		c.setBankAccount(ba);
		session.persist(c);

		t.commit();
	}
	
	
	
	


	
	
	public void saveOneToOneWithout_cascading(Session session) throws Exception
	{
		/* Save Bank Account & Customer Saperatly*/
		
		Transaction t = session.beginTransaction();

		Customer c = new Customer("Punnet", "punnet@outlook.com", 435654123L);
		Address ca = new Address("ABC-123", "Delhi", "Delhi");
		BankAccount ba = new BankAccount(745896, "HDFC-Bank", "h123");

		c.setAddress(ca);
		session.persist(ba);
		c.setBankAccount(ba);
		session.persist(c);

		t.commit();
	}

}
