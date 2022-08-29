import java.util.Stack;

class IsValidSerialization {
	public boolean isValidSerialization(String preorder) {
		Stack<Character> stack = new Stack<>();
		String[] pre = preorder.split(",");
		for (String s : pre) {
			char c = s.charAt(0);
			while (stack.size() >= 2 && stack.peek() == '#' && c == '#') {
				stack.pop();
				if (stack.pop() == '#') return false;
			}
			stack.push(c);
		}

		return stack.size() == 1 && stack.pop() == '#';
	}

	public static void main(String[] args) {
		IsValidSerialization valid = new IsValidSerialization();
		System.out.println(valid.isValidSerialization("9,3,4,#,#,1,#,#,2,#,6,#,#"));
		System.out.println(valid.isValidSerialization("1,#"));
		System.out.println(valid.isValidSerialization("9,#,#,1"));
	}
}