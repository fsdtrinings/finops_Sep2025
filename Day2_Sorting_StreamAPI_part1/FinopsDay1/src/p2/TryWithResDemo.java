package p2;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

class MyFileType implements AutoCloseable
{
	public void doABC()throws Exception
	{
		
	}

	@Override
	public void close() throws Exception {
		// code while closing the object 
		// logging or transaction close , session close etc
		
	}
	
	
}


public class TryWithResDemo {

	public static void main(String[] args)throws Exception {
		
		
		try(BufferedReader br = new BufferedReader(new FileReader(new File("abc.txt")))) 
		{
			
			
			
			
		} 
		catch (Exception e) {
			// TODO: handle exception
		}
		
		
		try(MyFileType obj = new MyFileType())
		{
			
		}
		catch (Exception e) {
			// TODO: handle exception
		}
		
		
		
	}//end main

}//end class
