package p1;

public class DemoApp {

	public static void main(String[] args) {
		
		Engineer e = new Engineer();
		
		TestEngineer te = new TestEngineer();
		new DemoApp().doTask(te);
	}
	public void doTask(Employee e)
	{
		if(e instanceof Engineer)
		{
			
		
			Engineer engineer2 = (Engineer)e;
			engineer2.doCoding();
			System.out.println("Engineer 2 : "+engineer2.getValue());
		}	
		if(e instanceof TestEngineer)
		{
			TestEngineer te = (TestEngineer)e;
			te.doTesting();
		}	
		
	
	}
}
