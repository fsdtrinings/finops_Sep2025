package streamapi.reduceop;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import streamapi.Employee;

public class ReduceOperation {
	
	List<Employee> listEmp = new ArrayList<>();

	public ReduceOperation() {
		Employee e1 = new Employee("A", 6000, "Development", LocalDate.of(2025, 1, 10), "Pune");
		Employee e2 = new Employee("B", 5000, "Development", LocalDate.of(2025, 11, 10), "Delhi");
		Employee e3 = new Employee("C", 8000, "Testing", LocalDate.of(2025, 7, 10), "Banglore");
		Employee e4 = new Employee("D", 2000, "Development", LocalDate.of(2025, 3, 10), "Pune");
		Employee e5 = new Employee("D", 2000, "Testing", LocalDate.of(2025, 3, 10), "Chennai");

		listEmp = Arrays.asList(e1, e2, e3, e4, e5);

	}

	public static void main(String[] args) {
		ReduceOperation app = new ReduceOperation();
		app.reduceCount();
		
	}
	
	public void reduceCount()
	{
		// #1 using filter
		long count1 = listEmp.stream().filter((e)->e.getDepartment().
				equalsIgnoreCase("testing")).count();


		System.out.println(count1);
		
		// #2nd approach
		long count2 = listEmp.stream()
						.map((e)->
							e.getDepartment().equalsIgnoreCase("testing")?1:0
						).reduce(0, (a,b)->a+b);
						
				System.out.println(count2);


		
		
	}
	
	public void reduceForCompare()
	{
		// max Salary 
		
	}
	
	public void reduceBasic1()
	{
		// Total Salary paid 
		long totalSalary = listEmp.stream()
				                  .map(e->e.getSalary())
				                  .reduce(0,(s1,s2)->s1+s2 );
		System.out.println(totalSalary);
	}



}
