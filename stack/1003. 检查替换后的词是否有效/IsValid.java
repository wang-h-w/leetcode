import java.util.*;

class IsValid {
	public boolean isValid(String s) {
		Deque<Character> stack = new LinkedList<>();
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			if (c == 'c') {
				if (!stack.isEmpty() && stack.peekLast() == 'b') {
					char b = stack.pollLast();
					if (!stack.isEmpty() && stack.peekLast() == 'a') {
						stack.pollLast();
						continue;
					}
					stack.addLast(b);
					stack.addLast(c);
				} else stack.addLast(c);
			} else stack.addLast(c);
		}
		return stack.isEmpty();
	}

	public static void main(String[] args) {
		IsValid v = new IsValid();
		System.out.println(v.isValid("aabcbc"));
		System.out.println(v.isValid("abcabcababcc"));
		System.out.println(v.isValid("abccba"));
		System.out.println(v.isValid("aabbcc"));
		System.out.println(v.isValid("abacbcabcc"));
	}
}