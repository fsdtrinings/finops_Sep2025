package streamapi.grouping;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import streamapi.Employee;

public class GroupingDemo {
	
	List<Employee> listEmp = new ArrayList<>();

	public GroupingDemo() {
		Employee e1 = new Employee("A", 6000, "Development", LocalDate.of(2025, 1, 10), "Pune");
		Employee e2 = new Employee("B", 5000, "Development", LocalDate.of(2025, 11, 10), "Delhi");
		Employee e3 = new Employee("C", 8000, "Testing", LocalDate.of(2025, 7, 10), "Banglore");
		Employee e4 = new Employee("D", 2000, "Development", LocalDate.of(2025, 3, 10), "Pune");
		Employee e5 = new Employee("D", 2000, "Testing", LocalDate.of(2025, 3, 10), "Chennai");

		listEmp = Arrays.asList(e1, e2, e3, e4, e5);

	}
	
	public static void main(String[] args) {
		GroupingDemo obj = new GroupingDemo();
		obj.groupBy1();
		obj.groupby2();
	}

	/* map<String,integer> : String :- Department name 
	 *     integer : totalSalarypaid*/

	public void groupby2()
	{
		Map<String, Integer> map
		=
		listEmp.stream().collect(Collectors.groupingBy(
				(e)->e.getDepartment(),
				Collectors.summingInt((e)->e.getSalary())
				));
						
		for (Map.Entry<String,Integer> entry : map.entrySet()) {
			System.out.println(entry.getKey());
			System.out.println(entry.getValue()); //list
		}
		
	}
	
	
	// Groups of Employees based on department
	public void groupBy1()
	{
		
		Map<String, List<Employee>> map
		=
		listEmp.stream().collect(
				Collectors.groupingBy(e->e.getDepartment()));
		
		for (Map.Entry<String, List<Employee>> entry : map.entrySet()) {
			System.out.println(entry.getKey());
			System.out.println(entry.getValue()); //list
		}
	}

	public void group3()
	{
		// map<name,salary>
	}
	

}























