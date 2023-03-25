class Jump {
	public int jump(int[] nums) {
		int n = nums.length, end = 0, farthest = 0, jumps = 0;
		for (int i = 0; i < n - 1; i++) {
			farthest = Math.max(nums[i] + i, farthest);
			if (end == i) {
				jumps++;
				end = farthest;
			}
		}
		return jumps;
	}
}