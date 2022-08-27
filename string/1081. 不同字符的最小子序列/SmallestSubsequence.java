import java.util.Stack;
import java.util.Set;
import java.util.HashSet;

class SmallestSubsequence {
	public String smallestSubsequence(String s) {
		Stack<Character> stack = new Stack<>();
		Set<Character> exist = new HashSet<>();
		int[] count = new int[26];
		int n = s.length();
		String res = "";

		for (int i = 0; i < n; i++) count[s.charAt(i) - 'a']++;

		for (int i = 0; i < n; i++) {
			char c = s.charAt(i);
			if (!exist.contains(c)) {
				while (!stack.empty() && c < stack.peek() && count[stack.peek()-'a'] > 0) exist.remove(stack.pop());
				stack.push(c);
				exist.add(c);
			}
			count[c-'a']--;
		}
		while (!stack.empty()) res = stack.pop() + res;
		return res;
	}

	public static void main(String[] args) {
		SmallestSubsequence r = new SmallestSubsequence();
		System.out.println(r.smallestSubsequence("bcabc"));
		System.out.println(r.smallestSubsequence("cbacdcbc"));
	}
}