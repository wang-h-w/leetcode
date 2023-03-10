class Rob {
	public int rob(int[] nums) {
		// dp[i]: 从i开始抢，能抢到的最大值
		int n = nums.length;
		int[] dp = new int[n + 2];
		dp[n] = 0;
		for (int i = n - 1; i >= 0; i--) {
			dp[i] = Math.max(nums[i] + dp[i + 2], dp[i + 1]);
		}
		return dp[0];
	}

	public static void main(String[] args) {
		Rob r = new Rob();
		System.out.println(r.rob(new int[] {1,2,3,1}));
		System.out.println(r.rob(new int[] {2,7,9,3,1}));
	}
}