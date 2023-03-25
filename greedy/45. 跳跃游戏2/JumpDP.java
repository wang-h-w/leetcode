class Jump {
	public int jump(int[] nums) {
		// dp[i]跳到i的最少步数
		int n = nums.length;
		int[] dp = new int[n];
		Arrays.fill(dp, Integer.MAX_VALUE);
		dp[0] = 0;
		for (int i = 1; i < n; i++) {
			for (int j = 0; j < i; j++) {
				dp[i] = Math.min(dp[i], i - j <= nums[j] ? dp[j] + 1 : Integer.MAX_VALUE); 
			}
		}
		return dp[n - 1];
	}
}