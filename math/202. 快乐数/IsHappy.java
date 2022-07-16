class IsHappy {
	public boolean isHappy(int n) {
		int slow = n, fast = n;
		do {
			slow = calSum(slow);
			fast = calSum(fast);
			fast = calSum(fast);
		} while (slow != fast);

		if (slow == 1) return true;
		return false;
	}

	private int calSum(int n) {
		int res = 0;
		while (n != 0) {
			res += Math.pow(n % 10, 2);
			n /= 10;
		}
		return res;
	}

	public static void main(String[] args) {
		IsHappy h = new IsHappy();
		System.out.println(h.isHappy(19));
		System.out.println(h.isHappy(2));
		System.out.println(h.isHappy(7));
		System.out.println(h.isHappy(1111111));
	}
}