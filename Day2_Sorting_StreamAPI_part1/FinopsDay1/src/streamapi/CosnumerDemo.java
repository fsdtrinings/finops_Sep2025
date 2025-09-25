package streamapi;

import java.util.function.Consumer;

public class CosnumerDemo {

	public static void main(String[] args) {
		
		Consumer<Integer> consumer = (t)->{
			System.out.println(t);
		};
		
	}
}
