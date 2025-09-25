package streamapi.terminal;

import java.lang.reflect.Array;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import streamapi.Employee;

public class StreamOperations {
	
	List<Employee> listEmp = new ArrayList<>();
	
	public StreamOperations() 
	{
		Employee e1 = new Employee("A",6000,"Development",LocalDate.of(2025, 1, 10),"Pune");
		Employee e2 = new Employee("B",5000,"Development",LocalDate.of(2025, 11, 10),"Delhi");
		Employee e3 = new Employee("C",8000,"Testing",LocalDate.of(2025, 7, 10),"Banglore");
		Employee e4 = new Employee("D",2000,"Development",LocalDate.of(2025, 3, 10),"Pune");
		Employee e5 = new Employee("D",2000,"Development",LocalDate.of(2025, 3, 10),"Chennai");
			
		listEmp = Arrays.asList(e1,e2,e3,e4,e5);
		
	}
	
	
	
	public static void main(String[] args) {
		
		StreamOperations app = new StreamOperations();
		
		//app.forEachTask();
		//app.collectOperations();
	   // 	app.matchOperations();
	//	app.doFilterOperations1();
		//app.doMapOperations();
		app.distinctOperations();
	}

	
	public void doMapOperations()
	{
		
		listEmp.stream().map((e)->e.getDepartment())
		.distinct()
		.forEach((e)->{
			System.out.println(e);
		});
		
		
	}
	
	public void distinctOperations()
	{
		// Same department but different locations
		listEmp.forEach(e->System.out.println(e));
		List<String> list = listEmp.stream()
						.filter((e)->e.getDepartment().equals("Development"))
						.map(e->e.getLocation())
						.distinct()
						.collect(Collectors.toList());
		
		System.out.println(list);
	}
	
	public void doFilterOperations1()
	{
		// Basic 
		
		listEmp.stream().filter((e)->{
			if(e.getDepartment().equalsIgnoreCase("testing")) return true;
			else return false;
		}).forEach((e)->System.out.println(e));
		
		
		List<Employee> resultList = listEmp.stream().filter((e)->{
			if(e.getDepartment().equalsIgnoreCase("testing")) return true;
			else return false;
		}).collect(Collectors.toList());
		
		
		List<Employee> resultList2 = listEmp.stream().filter((e)->{
			if(e.getDepartment().equalsIgnoreCase("development")) return true;
			else return false;
		}).map(e->{
			int oldSalary = e.getSalary();
			int newSalary = oldSalary+100;
			e.setSalary(newSalary);
			return e;
		}).collect(Collectors.toList());
	
		
		
		// ------ Implementing Comparator ------
		Comparator<Employee> com = (emp1,emp2)->{
			return emp1.getSalary() - emp2.getSalary();
		};
		
		Employee minSalary = listEmp.stream().min(com).get();
		
		
		
	}
	
	
	
	
	
	
	
	// allMatch :- give true if at least one element return true
	// anyMatch  :- give true if all elements return true
	// nonematch  :- give true id none of the elements returns true
	
	public void matchOperations()
	{
		List<Integer> list = Arrays.asList(15,78,96,74,17,63,74,34);
		
		boolean b = list.stream().allMatch((x)->{
			if(x>30) return true;
			else return false;
				
		});
		
		System.out.println(b);
		
		b = list.stream().anyMatch((x)->{
			if(x>30) return true;
			else return false;
				
		});
		
		System.out.println(b);
		
		b = list.stream().noneMatch((x)->{
			if(x>3000) return true;
			else return false;
				
		});
		
		System.out.println(b);
		
		boolean b2 = listEmp.stream().anyMatch((e)->e.getSalary()>4000);
		System.out.println(b2);
		
	}
	
	
	
	public void collectOperations()
	{
		List<Integer> list  = Stream.of(10,20,45,89,63,37).collect(Collectors.toList());
		Set<Integer> set  = Stream.of(10,20,45,89,63,37).collect(Collectors.toSet());
		
		list.forEach((x)->System.out.println(x));
		
		// ----- convert into map 
		
		Map<Integer, Integer> map = Stream.of(10,20,45,89,63,37)
				.collect(Collectors.toMap((k)->{
					return new Random().nextInt(500);
				}, e->e));
		
		System.out.println(map);
		
		
		long x = Stream.of(10,20,45,89,63,37).count();
		
		
	}
	
	
	
	
	public void forEachTask()
	{
		Stream.of(10,20,45,89,63,37).forEach((x)->{
			int t = x+100;
			System.out.println(t);
		});
		
	
	}
}
