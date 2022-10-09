import java.util.Stack;

class ScoreOfParentheses {
	public int scoreOfParentheses(String s) {
		char[] charArray = s.toCharArray();
		Stack<Integer> stack = new Stack<>();
		for (char c : charArray) {
			if (c == '(') {
				stack.push(0);
			} else {
				int score = 0;
				while (stack.peek() != 0) score += stack.pop();
				stack.pop();
				stack.push(score == 0 ? 1 : score * 2);
			}
		}

		int res = 0;
		while (!stack.empty()) res += stack.pop();
		return res;
	}

	public static void main(String[] args) {
		ScoreOfParentheses p = new ScoreOfParentheses();
		System.out.println(p.scoreOfParentheses("()"));
		System.out.println(p.scoreOfParentheses("(())"));
		System.out.println(p.scoreOfParentheses("()()"));
		System.out.println(p.scoreOfParentheses("(()((()()))"));
	}
}