package com.cg.hib;

import java.util.List;

import org.hibernate.Session;

import com.cg.hib.entity.Customer;
import com.cg.hib.projection.MyDTO;

public class JoinHQL {
/* Applying Join HQL over one-Many entities
 * 1) ProductOrder
 * 2) OrderItem
 * 3) Product
 * 4) Customer
 * 
 * */
	
	public static void main(String[] args)
	{
		JoinHQL obj = new JoinHQL();
		//obj.getProductDetailsBasedOnOrder();
		//obj.getCustomerProductDetailsBasedOn_POID();
	
		obj.doInnerQuery();
	
	
	}//end main
	
	public void doInnerQuery()
	{
		Session session = HibernateUtil.getSessionFactory().openSession();
		
		// SQL : select * from customer where cid in 
		//(select customerid from productorder where orderid = 2);
		
		String hql = "From Customer c where c.cid In ( "
									+ "Select po.customer.cid "
									+ "From ProductOrder po "
									+ "Where po.orderId = 2) ";
		List<Customer> row  = session.createQuery(hql, Customer.class).getResultList();
		
		System.out.println(row.size());
		row.stream().forEach((r)->{
			System.out.println(r.getCustomerName()+" "+r.getPhone());
		});
		
	}
	
	
	public void getCustomerProductDetailsBasedOn_POID()
	{

		Session session = HibernateUtil.getSessionFactory().openSession();
		
		/*
		 select c.fullname , p.name
		from productorder po
		Join customer c on po.customerId = c.cid
		Join orderitem oi on po.orderId = oi.poid
		join product p on p.pid = oi.pid
		where po.orderId = 2;
  
		  */
		
		String hql = "select c.customerName, p.name "
				+ "from ProductOrder  po "
				+ "Join po.customer c "
				+ "Join po.orderItems oi "
				+ "Join oi.product p "
				+ "where po.orderId = :paramName";
		
		List<Object[]> list = session.
				createQuery(hql, Object[].class)
				.setParameter("paramName", 2).getResultList();
		
		if( list!= null ||list.isEmpty() == false)
		{
			System.out.println(""+list);
		}
		
	}
	
	
	public void getProductDetailsBasedOnOrder()
	{
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		
		
		/*
		 select oi.poid ,oi.orderItemId , p.name,p.unitcost,
		 		oi.unitPrice as saleAmount
		 from orderitem oi
		 join product p on p.pid = oi.pid
		 Join productorder po on po.orderId = oi.poid
		 where po.orderId = 2;
		  
		  */
		
		String hql = "select oi.orderItemId,p.name,p.unitcost,oi.unitPrice "
				+ " from OrderItem oi "
				+ " Join oi.product p "
				+ " Join oi.order po "
				+ " where po.orderId = :paramName";
		
		
				
		List<Object[]> list = session.
							createQuery(hql, Object[].class)
							.setParameter("paramName", 2).getResultList();
		
		list.stream().forEach((row)->{
			
			System.out.println("OrderItemId "+(int)row[0]);
			System.out.println("Product Name "+(String)row[1]);
			System.out.println("Unit Cost (Product) "+(int)row[2]);
			System.out.println("Unit Price(Order Item) "+(int)row[3]);
			System.out.println("-----------------------------");
			
		});
		
	
	}
	
	public void getProductDetailsBasedOnOrder_Projection()
	{
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		
		
		/*
		 select oi.poid ,oi.orderItemId , p.name,p.unitcost,
		 		oi.unitPrice as saleAmount
		 from orderitem oi
		 join product p on p.pid = oi.pid
		 Join productorder po on po.orderId = oi.poid
		 where po.orderId = 2;
		  
		  */
		
		String hql = "select new com.cg.hib.projection.MyDTO"
				+ "(oi.orderItemId,p.name,p.unitcost,oi.unitPrice) "
				+ " from OrderItem oi "
				+ " Join oi.product p "
				+ " Join oi.order po "
				+ " where po.orderId = :paramName";
		
		
				
		List<MyDTO> list = session.
							createQuery(hql, MyDTO.class)
							.setParameter("paramName", 2).getResultList();
		
		System.out.println(list.size());
		
		list.stream().forEach((row)->{
			
			System.out.println(row.getOrderItemId());
			System.out.println(row.getName());
			System.out.println("Unit Cost Internal :- "+row.getUnitCostInternal());
			System.out.println("Actual Selling Price : "+row.getActualSellingPrice());
			
		});
		
	
	}
	
	
	
}//end class



































