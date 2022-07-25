import java.util.Stack;

class Calculate {
	public int calculate(String s) {
		Stack<Integer> stack = new Stack<>();
		int tempNum = 0, res = 0;
		char operate = '+';
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			if (c >= '0') tempNum = tempNum * 10 - '0' + c;
			if ((c < '0' && c != ' ') || i == s.length() - 1) {
				if (operate == '+') stack.push(tempNum);
				else if (operate == '-') stack.push(-tempNum);
				else if (operate == '*') stack.push(stack.pop() * tempNum);
				else if (operate == '/') stack.push(stack.pop() / tempNum);
				operate = c;
				tempNum = 0;
			}
		}
		while (!stack.isEmpty()) res += stack.pop();

		return res;
	}

	public static void main(String[] args) {
		Calculate c = new Calculate();
		System.out.println(c.calculate("3+2*2"));
		System.out.println(c.calculate("  3/2  "));
		System.out.println(c.calculate("  3+5 / 2"));
	}
}