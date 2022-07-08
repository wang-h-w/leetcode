import java.util.Stack;

class EvalRPN {
	public int evalRPN(String[] tokens) {
		Stack<Integer> stack = new Stack<>();

		for (String s: tokens) {
			if (s.equals("+")) stack.push(stack.pop() + stack.pop());
			else if (s.equals("-")) stack.push(-stack.pop() + stack.pop());
			else if (s.equals("*")) stack.push(stack.pop() * stack.pop());
			else if (s.equals("/")) {
				int a = stack.pop();
				int b = stack.pop();
				stack.push(b / a);
			} else stack.push(Integer.valueOf(s));
		}

		return stack.pop();
	}

	public static void main(String[] args) {
		EvalRPN eval = new EvalRPN();
		String[] tokens = new String[] {"4", "13", "5", "/", "+"};
		tokens = new String[] {"10","6","9","3","+","-11","*","/","*","17","+","5","+"};
		System.out.println(eval.evalRPN(tokens));
	}
}