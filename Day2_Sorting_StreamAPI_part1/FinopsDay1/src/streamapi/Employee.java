package streamapi;

import java.time.LocalDate;
import java.util.Objects;

public class Employee {

	private String empName;
	private int salary;
	private String department;
	private LocalDate doj;
	private String location;
	
	
	public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Employee(String empName, int salary, 
			String department, LocalDate doj,String location) {
		super();
		this.empName = empName;
		this.salary = salary;
		this.department = department;
		this.doj = doj;
		this.location = location;
	}

	

	
	public String getLocation() {
		return location;
	}


	public void setLocation(String location) {
		this.location = location;
	}


	public String getEmpName() {
		return empName;
	}


	public void setEmpName(String empName) {
		this.empName = empName;
	}


	public int getSalary() {
		return salary;
	}


	public void setSalary(int salary) {
		this.salary = salary;
	}


	public String getDepartment() {
		return department;
	}


	public void setDepartment(String department) {
		this.department = department;
	}


	public LocalDate getDoj() {
		return doj;
	}


	public void setDoj(LocalDate doj) {
		this.doj = doj;
	}




	@Override
	public int hashCode() {
		return Objects.hash(department, doj, empName, salary);
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Employee other = (Employee) obj;
		return Objects.equals(department, other.department) && Objects.equals(doj, other.doj)
				&& Objects.equals(empName, other.empName) && salary == other.salary;
	}
	
	
	@Override
	public String toString() {
		return "Employee [empName=" + empName + ", salary=" + salary + ", department=" + department + ", doj=" + doj
				+ "]";
	}

	
}
