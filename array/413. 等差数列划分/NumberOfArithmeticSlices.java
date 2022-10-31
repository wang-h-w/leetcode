class NumberOfArithmeticSlices {
	public int numberOfArithmeticSlices(int[] nums) {
		int n = nums.length;
		if (n < 3) return 0;
		int cnt = 2, sub = Integer.MIN_VALUE, res = 0;
		for (int i = 1; i < n; i++) {
			if (nums[i] - nums[i-1] == sub) cnt++;
			if (i == n - 1 || nums[i] - nums[i-1] != sub) {
				if (cnt >= 3) {
					res += (cnt - 1) * (cnt - 2) / 2;
				}
				cnt = 2;
				sub = nums[i] - nums[i-1];
			}
		}
		return res;
	}

	public static void main(String[] args) {
		NumberOfArithmeticSlices a = new NumberOfArithmeticSlices();
		System.out.println(a.numberOfArithmeticSlices(new int[] {1,2,3,4}));
	}
}