class MovesToMakeZigzag {
	public int movesToMakeZigzag(int[] nums) {
		int odd = 0, even = 0, n = nums.length;
		// odd
		for (int i = 1; i < n; i += 2) {
			int l = i > 0 ? nums[i - 1] : Integer.MAX_VALUE;
			int r = i < n - 1 ? nums[i + 1]  : Integer.MAX_VALUE;
			odd += Math.max(nums[i] - Math.min(l, r) + 1, 0);
		}
		// even
		for (int i = 0; i < n; i += 2) {
			int l = i > 0 ? nums[i - 1] : Integer.MAX_VALUE;
			int r = i < n - 1 ? nums[i + 1]  : Integer.MAX_VALUE;
			even += Math.max(nums[i] - Math.min(l, r) + 1, 0);
		}
		return Math.min(odd, even);
	}
}