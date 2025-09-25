package streamapi.flatmap;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import streamapi.Employee;

public class FlatMapOperation {
	
	public static void main(String[] args) {
		FlatMapOperation app = new FlatMapOperation();
	
		//app.basicFlatMap();
		app.flatternTheEmployeeBasedOnDepartment();
	}
	
	public void basicFlatMap()
	{
		// it used to flattern the stream of Stream , or collection inside another collection
		Map<String, List<String>> skillSet = new HashMap<>();
		skillSet.put("technical", Arrays.asList("Java","Testing","Salesforce","AWS"));
		skillSet.put("arts", Arrays.asList("Dancing","Music","Cooking","Painting"));
		
		 skillSet.values().stream().
				              flatMap((list)->list.stream())
				              .forEach((s)->System.out.println(s));
	}
	
	
	public void flatternTheEmployeeBasedOnDepartment()
	{
		// Imagine we a multiple list  of Employees based on Department 
		// in a map
		
		Employee e1 = new Employee("A", 6000, "Development", LocalDate.of(2025, 1, 10), "Pune");
		Employee e2 = new Employee("B", 5000, "Development", LocalDate.of(2025, 11, 10), "Delhi");
		Employee e3 = new Employee("C", 8000, "Testing", LocalDate.of(2025, 7, 10), "Banglore");
		Employee e4 = new Employee("D", 2000, "Development", LocalDate.of(2025, 3, 10), "Pune");
		Employee e5 = new Employee("D", 2000, "Testing", LocalDate.of(2025, 3, 10), "Chennai");

		
		
		List<Employee> devEmp = new ArrayList<>();
		devEmp.add(e1);
		devEmp.add(e2);
		devEmp.add(e4);
		
		List<Employee> testEmp = new ArrayList<>();
		devEmp.add(e3);
		devEmp.add(e5);
	
		Map<String, List<Employee>> map = new HashMap<>();
		map.put("Development", devEmp);
		map.put("testing", testEmp);
		
		// Objective : we have to extract all employees from the Map 
		List<Employee> allEmpList = map.values().stream()
		.flatMap((list)->list.stream())
		.collect(Collectors.toList());
		
		for (Employee e : allEmpList) {
			System.out.println(e);
		}
		
	}
	
	



}
