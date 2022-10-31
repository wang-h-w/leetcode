import java.util.List;
import java.util.ArrayList;

class FizzBuzz {
	public List<String> fizzBuzz(int n) {
		List<String> ret = new ArrayList<>();
		for (int i = 1; i <= n; i++) {
			if (i % 3 == 0 && i % 5 == 0) ret.add("FizzBuzz");
			else if (i % 3 == 0) ret.add("Fizz");
			else if (i % 5 == 0) ret.add("Buzz");
			else ret.add(String.valueOf(i));
		}
		return ret;
	}

	public static void main(String[] args) {
		FizzBuzz fb = new FizzBuzz();
		System.out.println(fb.fizzBuzz(3));
		System.out.println(fb.fizzBuzz(5));
		System.out.println(fb.fizzBuzz(15));
	}
}