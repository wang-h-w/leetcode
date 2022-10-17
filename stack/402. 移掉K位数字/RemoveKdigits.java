import java.util.Stack;

class RemoveKdigits {
	public String removeKdigits(String num, int k) {
		if (num.length() == k) return "0";
		Stack<Integer> stack = new Stack<>();
		int cnt = 0;
		for (int i = 0; i < num.length(); i++) {
			int digit = num.charAt(i) - '0';
			while (!stack.empty() && cnt < k && stack.peek() > digit) {
				stack.pop();
				cnt++;
			}
			stack.push(digit);
		}
		while (cnt++ < k) stack.pop();
		String res = "";
		while (!stack.empty()) res = stack.pop() + res;
		while (res.charAt(0) == '0' && res.length() > 1) res = res.substring(1, res.length());
		return res;
	}

	public static void main(String[] args) {
		RemoveKdigits k = new RemoveKdigits();
		System.out.println(k.removeKdigits("1432219", 3));
		System.out.println(k.removeKdigits("1324219", 3));
		System.out.println(k.removeKdigits("3241219", 3));
		System.out.println(k.removeKdigits("10200", 1));
		System.out.println(k.removeKdigits("10", 2));
	}
}