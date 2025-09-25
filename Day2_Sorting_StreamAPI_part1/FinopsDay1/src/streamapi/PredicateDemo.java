package streamapi;

import java.util.function.Predicate;

public class PredicateDemo {
	
	public static void main(String[] args) {
		
		Predicate<Integer> pre1 = new Predicate<Integer>() {
			
			@Override
			public boolean test(Integer t) {
				if(t>100) return true;
				return false;
			}
		};
		
		
		int arr[] = {20,200,280,40,300};
		for (int i : arr) {
			if(pre1.test(i))
			{
				System.out.println(i);
			}
		}
		
		// ------------------------------------------------------
		
		Predicate<Integer> pre2 = (x)->{
			if(x>100) return true;
			return false;
		};
		Predicate<Integer> pre3 = (x)->x>100;
		
		
		
					
	}//end main

}
