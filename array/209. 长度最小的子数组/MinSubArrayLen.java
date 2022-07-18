class MinSubArrayLen {
	public int minSubArrayLen(int target, int[] nums) {
		if (nums == null || nums.length == 0) return 0;
		int start = 0, end = 0, sum = nums[0], minLen = Integer.MAX_VALUE;
		while (end < nums.length) {
			while (sum >= target && start <= end) {
				minLen = Math.min(minLen, end - start + 1);
				sum -= nums[start++];
			}
			while (sum < target && ++end < nums.length) {
				sum += nums[end];
			}
		}

		return minLen == Integer.MAX_VALUE ? 0 : minLen;
	}

	public static void main(String[] args) {
		MinSubArrayLen min = new MinSubArrayLen();
		System.out.println(min.minSubArrayLen(7, new int[] {2,3,1,2,4,3}));
		System.out.println(min.minSubArrayLen(4, new int[] {1,4,4}));
		System.out.println(min.minSubArrayLen(11, new int[] {1,1,1,1,1,1,1,1,1}));
	}
}