class Solution {
	private int[] preSum;
	private Random random = new Random();

	public Solution(int[] w) {
		int n = w.length;
		preSum = new int[n + 1];
		for (int i = 1; i <= n; i++) preSum[i] = preSum[i - 1] + w[i - 1];

	}

	public int pickIndex() {
		int n = preSum.length;
		int target = random.nextInt(preSum[n - 1]) + 1;
		return search(target) - 1;
	}

	private int search(int target) {
		int l = 0, r = preSum.length;
		while (l < r) {
			int mid = l + (r - l) / 2;
			if (preSum[mid] >= target) r = mid;
			else if (preSum[mid] < target) l = mid + 1;
		}
		return l;
	}
}