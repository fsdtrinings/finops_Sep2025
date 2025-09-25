package p1;

public class Employee {

	private  int value;
	
	Employee()
	{
		value = 10;
	}
	
	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}


	public void doEmployeeThings()
	{
		value = 100;
		System.out.println(" employee task");
	}
}
