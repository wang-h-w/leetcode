class MaxValue {
	public int maxValue(int n, int index, int maxSum) {
		long l = 1, r = maxSum + 1;
		while (l < r) {
			long mid = l + (r - l) / 2;
			long minSum = sum(index + 1, mid) + sum(n - index, mid) - mid;
			if (minSum > maxSum) r = mid;
			else l = mid + 1;
		}
		return (int)(l - 1);
	}

	private long sum(int len, long target) {
		if (target > len) return (target + target - len + 1) * len / 2;
		else return (1 + target) * target / 2 + len - target;
	}

	public static void main(String[] args) {
		MaxValue mv = new MaxValue();
		System.out.println(mv.maxValue(4, 2, 6));
		System.out.println(mv.maxValue(6, 1, 10));
		System.out.println(mv.maxValue(1, 0, 8));
	}
}