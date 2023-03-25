class Jump {
	public int jump(int[] nums) {
		int n = nums.length;
		if (n == 1) return 0;
		int start = 0, end = n - 1, res = 1;
		while (true) {
			while (start < n && start + nums[start] < end) start++;
			if (start == 0 && start + nums[start] >= end) return res;
			end = start;
			start = 0;
			res++;
		}
	}
}