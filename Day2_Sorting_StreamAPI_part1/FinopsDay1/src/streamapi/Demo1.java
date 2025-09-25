package streamapi;

import java.util.stream.IntStream;

public class Demo1 {

	public static void main(String[] args) {
		 long x = IntStream.range(1, 5).sum();
		 System.out.println(x);
	}
}
